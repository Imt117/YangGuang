package com.yangguang.subsidy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yangguang.subsidy.mapper.SubsidyApplicationStatusMapper;
import com.yangguang.subsidy.domain.SubsidyApplicationStatus;
import com.yangguang.subsidy.service.ISubsidyApplicationStatusService;

/**
 * 补贴申请状态Service业务层处理
 * 
 * @author liwen
 * @date 2024-05-16
 */
@Service
public class SubsidyApplicationStatusServiceImpl implements ISubsidyApplicationStatusService 
{
    @Autowired
    private SubsidyApplicationStatusMapper subsidyApplicationStatusMapper;

    /**
     * 查询补贴申请状态
     * 
     * @param statusId 补贴申请状态主键
     * @return 补贴申请状态
     */
    @Override
    public SubsidyApplicationStatus selectSubsidyApplicationStatusByStatusId(Long statusId)
    {
        return subsidyApplicationStatusMapper.selectSubsidyApplicationStatusByStatusId(statusId);
    }

    /**
     * 查询补贴申请状态列表
     * 
     * @param subsidyApplicationStatus 补贴申请状态
     * @return 补贴申请状态
     */
    @Override
    public List<SubsidyApplicationStatus> selectSubsidyApplicationStatusList(SubsidyApplicationStatus subsidyApplicationStatus)
    {
        return subsidyApplicationStatusMapper.selectSubsidyApplicationStatusList(subsidyApplicationStatus);
    }

    /**
     * 新增补贴申请状态
     * 
     * @param subsidyApplicationStatus 补贴申请状态
     * @return 结果
     */
    @Override
    public int insertSubsidyApplicationStatus(SubsidyApplicationStatus subsidyApplicationStatus)
    {
        return subsidyApplicationStatusMapper.insertSubsidyApplicationStatus(subsidyApplicationStatus);
    }

    /**
     * 修改补贴申请状态
     * 
     * @param subsidyApplicationStatus 补贴申请状态
     * @return 结果
     */
    @Override
    public int updateSubsidyApplicationStatus(SubsidyApplicationStatus subsidyApplicationStatus)
    {
        return subsidyApplicationStatusMapper.updateSubsidyApplicationStatus(subsidyApplicationStatus);
    }

    /**
     * 批量删除补贴申请状态
     * 
     * @param statusIds 需要删除的补贴申请状态主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyApplicationStatusByStatusIds(Long[] statusIds)
    {
        return subsidyApplicationStatusMapper.deleteSubsidyApplicationStatusByStatusIds(statusIds);
    }

    /**
     * 删除补贴申请状态信息
     * 
     * @param statusId 补贴申请状态主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyApplicationStatusByStatusId(Long statusId)
    {
        return subsidyApplicationStatusMapper.deleteSubsidyApplicationStatusByStatusId(statusId);
    }
}
