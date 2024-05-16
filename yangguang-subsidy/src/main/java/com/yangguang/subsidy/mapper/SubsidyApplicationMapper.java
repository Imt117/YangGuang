package com.yangguang.subsidy.mapper;

import java.util.List;
import com.yangguang.subsidy.domain.SubsidyApplication;

/**
 * 补贴申请Mapper接口
 *
 * @author liwen
 * @date 2024-05-16
 */
public interface SubsidyApplicationMapper
{
    /**
     * 查询补贴申请
     *
     * @param applicationId 补贴申请主键
     * @return 补贴申请
     */
    public SubsidyApplication selectSubsidyApplicationByApplicationId(Long applicationId);

    /**
     * 查询补贴申请列表
     *
     * @param subsidyApplication 补贴申请
     * @return 补贴申请集合
     */
    public List<SubsidyApplication> selectSubsidyApplicationList(SubsidyApplication subsidyApplication);

    /**
     * 新增补贴申请
     *
     * @param subsidyApplication 补贴申请
     * @return 结果
     */
    public int insertSubsidyApplication(SubsidyApplication subsidyApplication);

    /**
     * 修改补贴申请
     *
     * @param subsidyApplication 补贴申请
     * @return 结果
     */
    public int updateSubsidyApplication(SubsidyApplication subsidyApplication);

    /**
     * 删除补贴申请
     *
     * @param applicationId 补贴申请主键
     * @return 结果
     */
    public int deleteSubsidyApplicationByApplicationId(Long applicationId);

    /**
     * 批量删除补贴申请
     *
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubsidyApplicationByApplicationIds(Long[] applicationIds);
}
