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
import com.yangguang.subsidy.domain.SubsidyPublicity;
import com.yangguang.subsidy.service.ISubsidyPublicityService;
import com.yangguang.common.utils.poi.ExcelUtil;
import com.yangguang.common.core.page.TableDataInfo;

/**
 * 补贴公示Controller
 * 
 * @author liwen
 * @date 2024-05-16
 */
@RestController
@RequestMapping("/subsidy/publicity")
public class SubsidyPublicityController extends BaseController
{
    @Autowired
    private ISubsidyPublicityService subsidyPublicityService;

    /**
     * 查询补贴公示列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:publicity:list')")
    @GetMapping("/list")
    public TableDataInfo list(SubsidyPublicity subsidyPublicity)
    {
        startPage();
        List<SubsidyPublicity> list = subsidyPublicityService.selectSubsidyPublicityList(subsidyPublicity);
        return getDataTable(list);
    }

    /**
     * 导出补贴公示列表
     */
    @PreAuthorize("@ss.hasPermi('subsidy:publicity:export')")
    @Log(title = "补贴公示", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SubsidyPublicity subsidyPublicity)
    {
        List<SubsidyPublicity> list = subsidyPublicityService.selectSubsidyPublicityList(subsidyPublicity);
        ExcelUtil<SubsidyPublicity> util = new ExcelUtil<SubsidyPublicity>(SubsidyPublicity.class);
        util.exportExcel(response, list, "补贴公示数据");
    }

    /**
     * 获取补贴公示详细信息
     */
    @PreAuthorize("@ss.hasPermi('subsidy:publicity:query')")
    @GetMapping(value = "/{publicityId}")
    public AjaxResult getInfo(@PathVariable("publicityId") Long publicityId)
    {
        return success(subsidyPublicityService.selectSubsidyPublicityByPublicityId(publicityId));
    }

    /**
     * 新增补贴公示
     */
    @PreAuthorize("@ss.hasPermi('subsidy:publicity:add')")
    @Log(title = "补贴公示", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SubsidyPublicity subsidyPublicity)
    {
        return toAjax(subsidyPublicityService.insertSubsidyPublicity(subsidyPublicity));
    }

    /**
     * 修改补贴公示
     */
    @PreAuthorize("@ss.hasPermi('subsidy:publicity:edit')")
    @Log(title = "补贴公示", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SubsidyPublicity subsidyPublicity)
    {
        return toAjax(subsidyPublicityService.updateSubsidyPublicity(subsidyPublicity));
    }

    /**
     * 删除补贴公示
     */
    @PreAuthorize("@ss.hasPermi('subsidy:publicity:remove')")
    @Log(title = "补贴公示", businessType = BusinessType.DELETE)
	@DeleteMapping("/{publicityIds}")
    public AjaxResult remove(@PathVariable Long[] publicityIds)
    {
        return toAjax(subsidyPublicityService.deleteSubsidyPublicityByPublicityIds(publicityIds));
    }
}
