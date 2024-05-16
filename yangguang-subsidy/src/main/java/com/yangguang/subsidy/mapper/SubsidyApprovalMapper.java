package com.yangguang.subsidy.mapper;

import java.util.List;
import com.yangguang.subsidy.domain.SubsidyApproval;

/**
 * 补贴审批Mapper接口
 * 
 * @author liwen
 * @date 2024-05-16
 */
public interface SubsidyApprovalMapper 
{
    /**
     * 查询补贴审批
     * 
     * @param approvalId 补贴审批主键
     * @return 补贴审批
     */
    public SubsidyApproval selectSubsidyApprovalByApprovalId(Long approvalId);

    /**
     * 查询补贴审批列表
     * 
     * @param subsidyApproval 补贴审批
     * @return 补贴审批集合
     */
    public List<SubsidyApproval> selectSubsidyApprovalList(SubsidyApproval subsidyApproval);

    /**
     * 新增补贴审批
     * 
     * @param subsidyApproval 补贴审批
     * @return 结果
     */
    public int insertSubsidyApproval(SubsidyApproval subsidyApproval);

    /**
     * 修改补贴审批
     * 
     * @param subsidyApproval 补贴审批
     * @return 结果
     */
    public int updateSubsidyApproval(SubsidyApproval subsidyApproval);

    /**
     * 删除补贴审批
     * 
     * @param approvalId 补贴审批主键
     * @return 结果
     */
    public int deleteSubsidyApprovalByApprovalId(Long approvalId);

    /**
     * 批量删除补贴审批
     * 
     * @param approvalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubsidyApprovalByApprovalIds(Long[] approvalIds);
}
