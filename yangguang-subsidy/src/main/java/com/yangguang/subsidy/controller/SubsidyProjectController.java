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
import com.yangguang.subsidy.domain.SubsidyProject;
import com.yangguang.subsidy.service.ISubsidyProjectService;
import com.yangguang.common.utils.poi.ExcelUtil;
import com.yangguang.common.core.page.TableDataInfo;

/**
 * 补贴项目Controller
 * 
 * @author liwen
 * @date 2024-05-16
 */
@RestController
@RequestMapping("/subsidy/project")
public class SubsidyProjectController extends BaseController
{
    @Autowired
    private ISubsidyProjectService subsidyProjectService;

    /**
     * 查询补贴项目列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(SubsidyProject subsidyProject)
    {
        startPage();
        List<SubsidyProject> list = subsidyProjectService.selectSubsidyProjectList(subsidyProject);
        return getDataTable(list);
    }

    /**
     * 导出补贴项目列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:project:export')")
    @Log(title = "补贴项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SubsidyProject subsidyProject)
    {
        List<SubsidyProject> list = subsidyProjectService.selectSubsidyProjectList(subsidyProject);
        ExcelUtil<SubsidyProject> util = new ExcelUtil<SubsidyProject>(SubsidyProject.class);
        util.exportExcel(response, list, "补贴项目数据");
    }

    /**
     * 获取补贴项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('subsidy:project:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") Long projectId)
    {
        return success(subsidyProjectService.selectSubsidyProjectByProjectId(projectId));
    }

    /**
     * 新增补贴项目
     */
    @PreAuthorize("@ss.hasPermi('subsidy:project:add')")
    @Log(title = "补贴项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SubsidyProject subsidyProject)
    {
        return toAjax(subsidyProjectService.insertSubsidyProject(subsidyProject));
    }

    /**
     * 修改补贴项目
     */
    @PreAuthorize("@ss.hasPermi('subsidy:project:edit')")
    @Log(title = "补贴项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SubsidyProject subsidyProject)
    {
        return toAjax(subsidyProjectService.updateSubsidyProject(subsidyProject));
    }

    /**
     * 删除补贴项目
     */
    @PreAuthorize("@ss.hasPermi('subsidy:project:remove')")
    @Log(title = "补贴项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(subsidyProjectService.deleteSubsidyProjectByProjectIds(projectIds));
    }
}
