package com.yangguang.subsidy.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yangguang.common.annotation.Excel;
import com.yangguang.common.core.domain.BaseEntity;

/**
 * 补贴申请状态对象 subsidy_application_status
 * 
 * @author liwen
 * @date 2024-05-16
 */
public class SubsidyApplicationStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 状态ID */
    private Long statusId;

    /** 申请ID */
    @Excel(name = "申请ID")
    private Long applicationId;

    /** 流程ID */
    @Excel(name = "流程ID")
    private Long processId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setStatusId(Long statusId) 
    {
        this.statusId = statusId;
    }

    public Long getStatusId() 
    {
        return statusId;
    }
    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setProcessId(Long processId) 
    {
        this.processId = processId;
    }

    public Long getProcessId() 
    {
        return processId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("statusId", getStatusId())
            .append("applicationId", getApplicationId())
            .append("processId", getProcessId())
            .append("status", getStatus())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
