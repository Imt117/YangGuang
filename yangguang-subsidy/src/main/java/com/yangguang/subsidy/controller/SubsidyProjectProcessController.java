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
import com.yangguang.subsidy.domain.SubsidyProjectProcess;
import com.yangguang.subsidy.service.ISubsidyProjectProcessService;
import com.yangguang.common.utils.poi.ExcelUtil;
import com.yangguang.common.core.page.TableDataInfo;

/**
 * 项目流程配置Controller
 * 
 * @author liwen
 * @date 2024-05-16
 */
@RestController
@RequestMapping("/subsidy/process")
public class SubsidyProjectProcessController extends BaseController
{
    @Autowired
    private ISubsidyProjectProcessService subsidyProjectProcessService;

    /**
     * 查询项目流程配置列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:process:list')")
    @GetMapping("/list")
    public TableDataInfo list(SubsidyProjectProcess subsidyProjectProcess)
    {
        startPage();
        List<SubsidyProjectProcess> list = subsidyProjectProcessService.selectSubsidyProjectProcessList(subsidyProjectProcess);
        return getDataTable(list);
    }

    /**
     * 导出项目流程配置列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:process:export')")
    @Log(title = "项目流程配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SubsidyProjectProcess subsidyProjectProcess)
    {
        List<SubsidyProjectProcess> list = subsidyProjectProcessService.selectSubsidyProjectProcessList(subsidyProjectProcess);
        ExcelUtil<SubsidyProjectProcess> util = new ExcelUtil<SubsidyProjectProcess>(SubsidyProjectProcess.class);
        util.exportExcel(response, list, "项目流程配置数据");
    }

    /**
     * 获取项目流程配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('subsidy:process:query')")
    @GetMapping(value = "/{processId}")
    public AjaxResult getInfo(@PathVariable("processId") Long processId)
    {
        return success(subsidyProjectProcessService.selectSubsidyProjectProcessByProcessId(processId));
    }

    /**
     * 新增项目流程配置
     */
    @PreAuthorize("@ss.hasPermi('subsidy:process:add')")
    @Log(title = "项目流程配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SubsidyProjectProcess subsidyProjectProcess)
    {
        return toAjax(subsidyProjectProcessService.insertSubsidyProjectProcess(subsidyProjectProcess));
    }

    /**
     * 修改项目流程配置
     */
    @PreAuthorize("@ss.hasPermi('subsidy:process:edit')")
    @Log(title = "项目流程配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SubsidyProjectProcess subsidyProjectProcess)
    {
        return toAjax(subsidyProjectProcessService.updateSubsidyProjectProcess(subsidyProjectProcess));
    }

    /**
     * 删除项目流程配置
     */
    @PreAuthorize("@ss.hasPermi('subsidy:process:remove')")
    @Log(title = "项目流程配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{processIds}")
    public AjaxResult remove(@PathVariable Long[] processIds)
    {
        return toAjax(subsidyProjectProcessService.deleteSubsidyProjectProcessByProcessIds(processIds));
    }
}
