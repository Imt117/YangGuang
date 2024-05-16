package com.yangguang.subsidy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yangguang.common.annotation.Excel;
import com.yangguang.common.core.domain.BaseEntity;

/**
 * 项目流程配置对象 subsidy_project_process
 * 
 * @author liwen
 * @date 2024-05-16
 */
public class SubsidyProjectProcess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程ID */
    private Long processId;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 流程步骤名称 */
    @Excel(name = "流程步骤名称")
    private String stepName;

    /** 流程步骤顺序 */
    @Excel(name = "流程步骤顺序")
    private Long stepOrder;

    public void setProcessId(Long processId) 
    {
        this.processId = processId;
    }

    public Long getProcessId() 
    {
        return processId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setStepName(String stepName) 
    {
        this.stepName = stepName;
    }

    public String getStepName() 
    {
        return stepName;
    }
    public void setStepOrder(Long stepOrder) 
    {
        this.stepOrder = stepOrder;
    }

    public Long getStepOrder() 
    {
        return stepOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("processId", getProcessId())
            .append("projectId", getProjectId())
            .append("stepName", getStepName())
            .append("stepOrder", getStepOrder())
            .toString();
    }
}
