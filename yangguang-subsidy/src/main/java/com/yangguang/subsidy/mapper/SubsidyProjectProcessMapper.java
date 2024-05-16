package com.yangguang.subsidy.mapper;

import java.util.List;
import com.yangguang.subsidy.domain.SubsidyProjectProcess;

/**
 * 项目流程配置Mapper接口
 * 
 * @author liwen
 * @date 2024-05-16
 */
public interface SubsidyProjectProcessMapper 
{
    /**
     * 查询项目流程配置
     * 
     * @param processId 项目流程配置主键
     * @return 项目流程配置
     */
    public SubsidyProjectProcess selectSubsidyProjectProcessByProcessId(Long processId);

    /**
     * 查询项目流程配置列表
     * 
     * @param subsidyProjectProcess 项目流程配置
     * @return 项目流程配置集合
     */
    public List<SubsidyProjectProcess> selectSubsidyProjectProcessList(SubsidyProjectProcess subsidyProjectProcess);

    /**
     * 新增项目流程配置
     * 
     * @param subsidyProjectProcess 项目流程配置
     * @return 结果
     */
    public int insertSubsidyProjectProcess(SubsidyProjectProcess subsidyProjectProcess);

    /**
     * 修改项目流程配置
     * 
     * @param subsidyProjectProcess 项目流程配置
     * @return 结果
     */
    public int updateSubsidyProjectProcess(SubsidyProjectProcess subsidyProjectProcess);

    /**
     * 删除项目流程配置
     * 
     * @param processId 项目流程配置主键
     * @return 结果
     */
    public int deleteSubsidyProjectProcessByProcessId(Long processId);

    /**
     * 批量删除项目流程配置
     * 
     * @param processIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubsidyProjectProcessByProcessIds(Long[] processIds);
}
