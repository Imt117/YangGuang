package com.yangguang.subsidy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yangguang.subsidy.mapper.SubsidyApplicationMapper;
import com.yangguang.subsidy.domain.SubsidyApplication;
import com.yangguang.subsidy.service.ISubsidyApplicationService;

/**
 * 补贴申请Service业务层处理
 *
 * @author liwen
 * @date 2024-05-16
 */
@Service
public class SubsidyApplicationServiceImpl implements ISubsidyApplicationService
{
    @Autowired
    private SubsidyApplicationMapper subsidyApplicationMapper;

    /**
     * 查询补贴申请
     *
     * @param applicationId 补贴申请主键
     * @return 补贴申请
     */
    @Override
    public SubsidyApplication selectSubsidyApplicationByApplicationId(Long applicationId)
    {
        return subsidyApplicationMapper.selectSubsidyApplicationByApplicationId(applicationId);
    }

    /**
     * 查询补贴申请列表
     *
     * @param subsidyApplication 补贴申请
     * @return 补贴申请
     */
    @Override
    public List<SubsidyApplication> selectSubsidyApplicationList(SubsidyApplication subsidyApplication)
    {
        return subsidyApplicationMapper.selectSubsidyApplicationList(subsidyApplication);
    }

    /**
     * 新增补贴申请
     *
     * @param subsidyApplication 补贴申请
     * @return 结果
     */
    @Override
    public int insertSubsidyApplication(SubsidyApplication subsidyApplication)
    {
        return subsidyApplicationMapper.insertSubsidyApplication(subsidyApplication);
    }

    /**
     * 修改补贴申请
     *
     * @param subsidyApplication 补贴申请
     * @return 结果
     */
    @Override
    public int updateSubsidyApplication(SubsidyApplication subsidyApplication)
    {
        return subsidyApplicationMapper.updateSubsidyApplication(subsidyApplication);
    }

    /**
     * 批量删除补贴申请
     *
     * @param applicationIds 需要删除的补贴申请主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyApplicationByApplicationIds(Long[] applicationIds)
    {
        return subsidyApplicationMapper.deleteSubsidyApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除补贴申请信息
     *
     * @param applicationId 补贴申请主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyApplicationByApplicationId(Long applicationId)
    {
        return subsidyApplicationMapper.deleteSubsidyApplicationByApplicationId(applicationId);
    }
}
