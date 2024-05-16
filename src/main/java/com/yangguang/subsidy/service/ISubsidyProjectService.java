package com.yangguang.subsidy.service;

import java.util.List;
import com.yangguang.subsidy.domain.SubsidyProject;

/**
 * 补贴项目Service接口
 * 
 * @author liwen
 * @date 2024-05-16
 */
public interface ISubsidyProjectService 
{
    /**
     * 查询补贴项目
     * 
     * @param projectId 补贴项目主键
     * @return 补贴项目
     */
    public SubsidyProject selectSubsidyProjectByProjectId(Long projectId);

    /**
     * 查询补贴项目列表
     * 
     * @param subsidyProject 补贴项目
     * @return 补贴项目集合
     */
    public List<SubsidyProject> selectSubsidyProjectList(SubsidyProject subsidyProject);

    /**
     * 新增补贴项目
     * 
     * @param subsidyProject 补贴项目
     * @return 结果
     */
    public int insertSubsidyProject(SubsidyProject subsidyProject);

    /**
     * 修改补贴项目
     * 
     * @param subsidyProject 补贴项目
     * @return 结果
     */
    public int updateSubsidyProject(SubsidyProject subsidyProject);

    /**
     * 批量删除补贴项目
     * 
     * @param projectIds 需要删除的补贴项目主键集合
     * @return 结果
     */
    public int deleteSubsidyProjectByProjectIds(Long[] projectIds);

    /**
     * 删除补贴项目信息
     * 
     * @param projectId 补贴项目主键
     * @return 结果
     */
    public int deleteSubsidyProjectByProjectId(Long projectId);
}
