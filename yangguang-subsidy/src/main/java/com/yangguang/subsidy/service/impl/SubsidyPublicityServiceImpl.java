package com.yangguang.subsidy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yangguang.subsidy.mapper.SubsidyPublicityMapper;
import com.yangguang.subsidy.domain.SubsidyPublicity;
import com.yangguang.subsidy.service.ISubsidyPublicityService;

/**
 * 补贴公示Service业务层处理
 * 
 * @author liwen
 * @date 2024-05-16
 */
@Service
public class SubsidyPublicityServiceImpl implements ISubsidyPublicityService 
{
    @Autowired
    private SubsidyPublicityMapper subsidyPublicityMapper;

    /**
     * 查询补贴公示
     * 
     * @param publicityId 补贴公示主键
     * @return 补贴公示
     */
    @Override
    public SubsidyPublicity selectSubsidyPublicityByPublicityId(Long publicityId)
    {
        return subsidyPublicityMapper.selectSubsidyPublicityByPublicityId(publicityId);
    }

    /**
     * 查询补贴公示列表
     * 
     * @param subsidyPublicity 补贴公示
     * @return 补贴公示
     */
    @Override
    public List<SubsidyPublicity> selectSubsidyPublicityList(SubsidyPublicity subsidyPublicity)
    {
        return subsidyPublicityMapper.selectSubsidyPublicityList(subsidyPublicity);
    }

    /**
     * 新增补贴公示
     * 
     * @param subsidyPublicity 补贴公示
     * @return 结果
     */
    @Override
    public int insertSubsidyPublicity(SubsidyPublicity subsidyPublicity)
    {
        return subsidyPublicityMapper.insertSubsidyPublicity(subsidyPublicity);
    }

    /**
     * 修改补贴公示
     * 
     * @param subsidyPublicity 补贴公示
     * @return 结果
     */
    @Override
    public int updateSubsidyPublicity(SubsidyPublicity subsidyPublicity)
    {
        return subsidyPublicityMapper.updateSubsidyPublicity(subsidyPublicity);
    }

    /**
     * 批量删除补贴公示
     * 
     * @param publicityIds 需要删除的补贴公示主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyPublicityByPublicityIds(Long[] publicityIds)
    {
        return subsidyPublicityMapper.deleteSubsidyPublicityByPublicityIds(publicityIds);
    }

    /**
     * 删除补贴公示信息
     * 
     * @param publicityId 补贴公示主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyPublicityByPublicityId(Long publicityId)
    {
        return subsidyPublicityMapper.deleteSubsidyPublicityByPublicityId(publicityId);
    }
}
