package com.yangguang.subsidy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yangguang.subsidy.mapper.SubsidyApprovalMapper;
import com.yangguang.subsidy.domain.SubsidyApproval;
import com.yangguang.subsidy.service.ISubsidyApprovalService;

/**
 * 补贴审批Service业务层处理
 * 
 * @author liwen
 * @date 2024-05-16
 */
@Service
public class SubsidyApprovalServiceImpl implements ISubsidyApprovalService 
{
    @Autowired
    private SubsidyApprovalMapper subsidyApprovalMapper;

    /**
     * 查询补贴审批
     * 
     * @param approvalId 补贴审批主键
     * @return 补贴审批
     */
    @Override
    public SubsidyApproval selectSubsidyApprovalByApprovalId(Long approvalId)
    {
        return subsidyApprovalMapper.selectSubsidyApprovalByApprovalId(approvalId);
    }

    /**
     * 查询补贴审批列表
     * 
     * @param subsidyApproval 补贴审批
     * @return 补贴审批
     */
    @Override
    public List<SubsidyApproval> selectSubsidyApprovalList(SubsidyApproval subsidyApproval)
    {
        return subsidyApprovalMapper.selectSubsidyApprovalList(subsidyApproval);
    }

    /**
     * 新增补贴审批
     * 
     * @param subsidyApproval 补贴审批
     * @return 结果
     */
    @Override
    public int insertSubsidyApproval(SubsidyApproval subsidyApproval)
    {
        return subsidyApprovalMapper.insertSubsidyApproval(subsidyApproval);
    }

    /**
     * 修改补贴审批
     * 
     * @param subsidyApproval 补贴审批
     * @return 结果
     */
    @Override
    public int updateSubsidyApproval(SubsidyApproval subsidyApproval)
    {
        return subsidyApprovalMapper.updateSubsidyApproval(subsidyApproval);
    }

    /**
     * 批量删除补贴审批
     * 
     * @param approvalIds 需要删除的补贴审批主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyApprovalByApprovalIds(Long[] approvalIds)
    {
        return subsidyApprovalMapper.deleteSubsidyApprovalByApprovalIds(approvalIds);
    }

    /**
     * 删除补贴审批信息
     * 
     * @param approvalId 补贴审批主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyApprovalByApprovalId(Long approvalId)
    {
        return subsidyApprovalMapper.deleteSubsidyApprovalByApprovalId(approvalId);
    }
}
