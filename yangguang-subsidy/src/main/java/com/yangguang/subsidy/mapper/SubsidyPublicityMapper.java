package com.yangguang.subsidy.mapper;

import java.util.List;
import com.yangguang.subsidy.domain.SubsidyPublicity;

/**
 * 补贴公示Mapper接口
 * 
 * @author liwen
 * @date 2024-05-16
 */
public interface SubsidyPublicityMapper 
{
    /**
     * 查询补贴公示
     * 
     * @param publicityId 补贴公示主键
     * @return 补贴公示
     */
    public SubsidyPublicity selectSubsidyPublicityByPublicityId(Long publicityId);

    /**
     * 查询补贴公示列表
     * 
     * @param subsidyPublicity 补贴公示
     * @return 补贴公示集合
     */
    public List<SubsidyPublicity> selectSubsidyPublicityList(SubsidyPublicity subsidyPublicity);

    /**
     * 新增补贴公示
     * 
     * @param subsidyPublicity 补贴公示
     * @return 结果
     */
    public int insertSubsidyPublicity(SubsidyPublicity subsidyPublicity);

    /**
     * 修改补贴公示
     * 
     * @param subsidyPublicity 补贴公示
     * @return 结果
     */
    public int updateSubsidyPublicity(SubsidyPublicity subsidyPublicity);

    /**
     * 删除补贴公示
     * 
     * @param publicityId 补贴公示主键
     * @return 结果
     */
    public int deleteSubsidyPublicityByPublicityId(Long publicityId);

    /**
     * 批量删除补贴公示
     * 
     * @param publicityIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubsidyPublicityByPublicityIds(Long[] publicityIds);
}
