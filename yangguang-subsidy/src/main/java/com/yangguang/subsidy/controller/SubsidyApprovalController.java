package com.yangguang.subsidy.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yangguang.common.annotation.Log;
import com.yangguang.common.core.controller.BaseController;
import com.yangguang.common.core.domain.AjaxResult;
import com.yangguang.common.enums.BusinessType;
import com.yangguang.subsidy.domain.SubsidyApproval;
import com.yangguang.subsidy.service.ISubsidyApprovalService;
import com.yangguang.common.utils.poi.ExcelUtil;
import com.yangguang.common.core.page.TableDataInfo;

/**
 * 补贴审批Controller
 * 
 * @author liwen
 * @date 2024-05-16
 */
@RestController
@RequestMapping("/subsidy/approval")
public class SubsidyApprovalController extends BaseController
{
    @Autowired
    private ISubsidyApprovalService subsidyApprovalService;

    /**
     * 查询补贴审批列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:approval:list')")
    @GetMapping("/list")
    public TableDataInfo list(SubsidyApproval subsidyApproval)
    {
        startPage();
        List<SubsidyApproval> list = subsidyApprovalService.selectSubsidyApprovalList(subsidyApproval);
        return getDataTable(list);
    }

    /**
     * 导出补贴审批列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:approval:export')")
    @Log(title = "补贴审批", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SubsidyApproval subsidyApproval)
    {
        List<SubsidyApproval> list = subsidyApprovalService.selectSubsidyApprovalList(subsidyApproval);
        ExcelUtil<SubsidyApproval> util = new ExcelUtil<SubsidyApproval>(SubsidyApproval.class);
        util.exportExcel(response, list, "补贴审批数据");
    }

    /**
     * 获取补贴审批详细信息
     */
    @PreAuthorize("@ss.hasPermi('subsidy:approval:query')")
    @GetMapping(value = "/{approvalId}")
    public AjaxResult getInfo(@PathVariable("approvalId") Long approvalId)
    {
        return success(subsidyApprovalService.selectSubsidyApprovalByApprovalId(approvalId));
    }

    /**
     * 新增补贴审批
     */
    @PreAuthorize("@ss.hasPermi('subsidy:approval:add')")
    @Log(title = "补贴审批", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SubsidyApproval subsidyApproval)
    {
        return toAjax(subsidyApprovalService.insertSubsidyApproval(subsidyApproval));
    }

    /**
     * 修改补贴审批
     */
    @PreAuthorize("@ss.hasPermi('subsidy:approval:edit')")
    @Log(title = "补贴审批", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SubsidyApproval subsidyApproval)
    {
        return toAjax(subsidyApprovalService.updateSubsidyApproval(subsidyApproval));
    }

    /**
     * 删除补贴审批
     */
    @PreAuthorize("@ss.hasPermi('subsidy:approval:remove')")
    @Log(title = "补贴审批", businessType = BusinessType.DELETE)
	@DeleteMapping("/{approvalIds}")
    public AjaxResult remove(@PathVariable Long[] approvalIds)
    {
        return toAjax(subsidyApprovalService.deleteSubsidyApprovalByApprovalIds(approvalIds));
    }
}
