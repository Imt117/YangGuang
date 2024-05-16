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
import com.yangguang.subsidy.domain.SubsidyApplication;
import com.yangguang.subsidy.service.ISubsidyApplicationService;
import com.yangguang.common.utils.poi.ExcelUtil;
import com.yangguang.common.core.page.TableDataInfo;

/**
 * 补贴申请Controller
 *
 * @author liwen
 * @date 2024-05-16
 */
@RestController
@RequestMapping("/subsidy/application")
public class SubsidyApplicationController extends BaseController
{
    @Autowired
    private ISubsidyApplicationService subsidyApplicationService;

    /**
     * 查询补贴申请列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(SubsidyApplication subsidyApplication)
    {
        startPage();
        List<SubsidyApplication> list = subsidyApplicationService.selectSubsidyApplicationList(subsidyApplication);
        return getDataTable(list);
    }

    /**
     * 导出补贴申请列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:application:export')")
    @Log(title = "补贴申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SubsidyApplication subsidyApplication)
    {
        List<SubsidyApplication> list = subsidyApplicationService.selectSubsidyApplicationList(subsidyApplication);
        ExcelUtil<SubsidyApplication> util = new ExcelUtil<SubsidyApplication>(SubsidyApplication.class);
        util.exportExcel(response, list, "补贴申请数据");
    }

    /**
     * 获取补贴申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('subsidy:application:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return success(subsidyApplicationService.selectSubsidyApplicationByApplicationId(applicationId));
    }

    /**
     * 新增补贴申请
     */
    @PreAuthorize("@ss.hasPermi('subsidy:application:add')")
    @Log(title = "补贴申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SubsidyApplication subsidyApplication)
    {
        return toAjax(subsidyApplicationService.insertSubsidyApplication(subsidyApplication));
    }

    /**
     * 修改补贴申请
     */
    @PreAuthorize("@ss.hasPermi('subsidy:application:edit')")
    @Log(title = "补贴申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SubsidyApplication subsidyApplication)
    {
        return toAjax(subsidyApplicationService.updateSubsidyApplication(subsidyApplication));
    }

    /**
     * 删除补贴申请
     */
    @PreAuthorize("@ss.hasPermi('subsidy:application:remove')")
    @Log(title = "补贴申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(subsidyApplicationService.deleteSubsidyApplicationByApplicationIds(applicationIds));
    }
}
