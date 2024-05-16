package com.yangguang.subsidy.mapper;

import java.util.List;
import com.yangguang.subsidy.domain.SubsidyApplicationStatus;

/**
 * 补贴申请状态Mapper接口
 * 
 * @author liwen
 * @date 2024-05-16
 */
public interface SubsidyApplicationStatusMapper 
{
    /**
     * 查询补贴申请状态
     * 
     * @param statusId 补贴申请状态主键
     * @return 补贴申请状态
     */
    public SubsidyApplicationStatus selectSubsidyApplicationStatusByStatusId(Long statusId);

    /**
     * 查询补贴申请状态列表
     * 
     * @param subsidyApplicationStatus 补贴申请状态
     * @return 补贴申请状态集合
     */
    public List<SubsidyApplicationStatus> selectSubsidyApplicationStatusList(SubsidyApplicationStatus subsidyApplicationStatus);

    /**
     * 新增补贴申请状态
     * 
     * @param subsidyApplicationStatus 补贴申请状态
     * @return 结果
     */
    public int insertSubsidyApplicationStatus(SubsidyApplicationStatus subsidyApplicationStatus);

    /**
     * 修改补贴申请状态
     * 
     * @param subsidyApplicationStatus 补贴申请状态
     * @return 结果
     */
    public int updateSubsidyApplicationStatus(SubsidyApplicationStatus subsidyApplicationStatus);

    /**
     * 删除补贴申请状态
     * 
     * @param statusId 补贴申请状态主键
     * @return 结果
     */
    public int deleteSubsidyApplicationStatusByStatusId(Long statusId);

    /**
     * 批量删除补贴申请状态
     * 
     * @param statusIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubsidyApplicationStatusByStatusIds(Long[] statusIds);
}
