package com.yangguang.subsidy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yangguang.subsidy.mapper.SubsidyProjectMapper;
import com.yangguang.subsidy.domain.SubsidyProject;
import com.yangguang.subsidy.service.ISubsidyProjectService;

/**
 * 补贴项目Service业务层处理
 * 
 * @author liwen
 * @date 2024-05-16
 */
@Service
public class SubsidyProjectServiceImpl implements ISubsidyProjectService 
{
    @Autowired
    private SubsidyProjectMapper subsidyProjectMapper;

    /**
     * 查询补贴项目
     * 
     * @param projectId 补贴项目主键
     * @return 补贴项目
     */
    @Override
    public SubsidyProject selectSubsidyProjectByProjectId(Long projectId)
    {
        return subsidyProjectMapper.selectSubsidyProjectByProjectId(projectId);
    }

    /**
     * 查询补贴项目列表
     * 
     * @param subsidyProject 补贴项目
     * @return 补贴项目
     */
    @Override
    public List<SubsidyProject> selectSubsidyProjectList(SubsidyProject subsidyProject)
    {
        return subsidyProjectMapper.selectSubsidyProjectList(subsidyProject);
    }

    /**
     * 新增补贴项目
     * 
     * @param subsidyProject 补贴项目
     * @return 结果
     */
    @Override
    public int insertSubsidyProject(SubsidyProject subsidyProject)
    {
        return subsidyProjectMapper.insertSubsidyProject(subsidyProject);
    }

    /**
     * 修改补贴项目
     * 
     * @param subsidyProject 补贴项目
     * @return 结果
     */
    @Override
    public int updateSubsidyProject(SubsidyProject subsidyProject)
    {
        return subsidyProjectMapper.updateSubsidyProject(subsidyProject);
    }

    /**
     * 批量删除补贴项目
     * 
     * @param projectIds 需要删除的补贴项目主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyProjectByProjectIds(Long[] projectIds)
    {
        return subsidyProjectMapper.deleteSubsidyProjectByProjectIds(projectIds);
    }

    /**
     * 删除补贴项目信息
     * 
     * @param projectId 补贴项目主键
     * @return 结果
     */
    @Override
    public int deleteSubsidyProjectByProjectId(Long projectId)
    {
        return subsidyProjectMapper.deleteSubsidyProjectByProjectId(projectId);
    }
}
