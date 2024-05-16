package com.yangguang.subsidy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yangguang.subsidy.mapper.SubsidyProjectProcessMapper;
import com.yangguang.subsidy.domain.SubsidyProjectProcess;
import com.yangguang.subsidy.service.ISubsidyProjectProcessService;

/**
 * 项目流程配置Service业务层处理
 * 
 * @author liwen
 * @date 2024-05-16
 */
@Service
public class SubsidyProjectProcessServiceImpl implements ISubsidyProjectProcessService 
{
    @Autowired
    private SubsidyProjectProcessMapper subsidyProjectProcessMapper;

    /**
     * 查询项目流程配置
     * 
     * @param processId 项目流程配置主键
     * @return 项目流程配置
     */
    @Override
    public SubsidyProjectProcess selectSubsidyProjectProcessByProcessId(Long processId)
    {
        return subsidyProjectProcessMapper.selectSubsidyProjectProcessByProcessId(processId);
    }

    /**
     * 查询项目流程配置列表
     * 
     * @param subsidyProjectProcess 项目流程配置
     * @return 项目流程配置
     */
    @Override
    public List<SubsidyProjectProcess> selectSubsidyProjectProcessList(SubsidyProjectProcess subsidyProjectProcess)
    {
        return subsidyProjectProcessMapper.selectSubsidyProjectProcessList(subsidyProjectProcess);
    }

    /**
     * 新增项目流程配置
     * 
     * @param subsidyProjectProcess 项目流程配置
     * @return 结果
     */
    @Override
    public int insertSubsidyProjectProcess(SubsidyProjectProcess subsidyProjectProcess)
    {
        return subsidyProjectProcessMapper.insertSubsidyProjectProcess(subsidyProjectProcess);
    }

    /**
     * 修改项目流程配置
     * 
     * @param subsidyProjectProcess 项目流程配置
     * @return 结果
     */
    @Override
    public int updateSubsidyProjectProcess(SubsidyProjectProcess subsidyProjectProcess)
    {
        return subsidyProjectProcessMapper.updateSubsidyProjectProcess(subsidyProjectProcess);
    }

    /**
     * 批量删除项目流程配置
     * 
     * @param processIds 需要删除的项目流程配置主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyProjectProcessByProcessIds(Long[] processIds)
    {
        return subsidyProjectProcessMapper.deleteSubsidyProjectProcessByProcessIds(processIds);
    }

    /**
     * 删除项目流程配置信息
     * 
     * @param processId 项目流程配置主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyProjectProcessByProcessId(Long processId)
    {
        return subsidyProjectProcessMapper.deleteSubsidyProjectProcessByProcessId(processId);
    }
}
