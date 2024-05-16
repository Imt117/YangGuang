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
import com.yangguang.subsidy.domain.SubsidyApplicationStatus;
import com.yangguang.subsidy.service.ISubsidyApplicationStatusService;
import com.yangguang.common.utils.poi.ExcelUtil;
import com.yangguang.common.core.page.TableDataInfo;

/**
 * 补贴申请状态Controller
 * 
 * @author liwen
 * @date 2024-05-16
 */
@RestController
@RequestMapping("/subsidy/status")
public class SubsidyApplicationStatusController extends BaseController
{
    @Autowired
    private ISubsidyApplicationStatusService subsidyApplicationStatusService;

    /**
     * 查询补贴申请状态列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:status:list')")
    @GetMapping("/list")
    public TableDataInfo list(SubsidyApplicationStatus subsidyApplicationStatus)
    {
        startPage();
        List<SubsidyApplicationStatus> list = subsidyApplicationStatusService.selectSubsidyApplicationStatusList(subsidyApplicationStatus);
        return getDataTable(list);
    }

    /**
     * 导出补贴申请状态列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:status:export')")
    @Log(title = "补贴申请状态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SubsidyApplicationStatus subsidyApplicationStatus)
    {
        List<SubsidyApplicationStatus> list = subsidyApplicationStatusService.selectSubsidyApplicationStatusList(subsidyApplicationStatus);
        ExcelUtil<SubsidyApplicationStatus> util = new ExcelUtil<SubsidyApplicationStatus>(SubsidyApplicationStatus.class);
        util.exportExcel(response, list, "补贴申请状态数据");
    }

    /**
     * 获取补贴申请状态详细信息
     */
    @PreAuthorize("@ss.hasPermi('subsidy:status:query')")
    @GetMapping(value = "/{statusId}")
    public AjaxResult getInfo(@PathVariable("statusId") Long statusId)
    {
        return success(subsidyApplicationStatusService.selectSubsidyApplicationStatusByStatusId(statusId));
    }

    /**
     * 新增补贴申请状态
     */
    @PreAuthorize("@ss.hasPermi('subsidy:status:add')")
    @Log(title = "补贴申请状态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SubsidyApplicationStatus subsidyApplicationStatus)
    {
        return toAjax(subsidyApplicationStatusService.insertSubsidyApplicationStatus(subsidyApplicationStatus));
    }

    /**
     * 修改补贴申请状态
     */
    @PreAuthorize("@ss.hasPermi('subsidy:status:edit')")
    @Log(title = "补贴申请状态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SubsidyApplicationStatus subsidyApplicationStatus)
    {
        return toAjax(subsidyApplicationStatusService.updateSubsidyApplicationStatus(subsidyApplicationStatus));
    }

    /**
     * 删除补贴申请状态
     */
    @PreAuthorize("@ss.hasPermi('subsidy:status:remove')")
    @Log(title = "补贴申请状态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{statusIds}")
    public AjaxResult remove(@PathVariable Long[] statusIds)
    {
        return toAjax(subsidyApplicationStatusService.deleteSubsidyApplicationStatusByStatusIds(statusIds));
    }
}
