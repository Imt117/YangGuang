package com.yangguang.subsidy.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yangguang.common.annotation.Excel;
import com.yangguang.common.core.domain.BaseEntity;

/**
 * 补贴审批对象 subsidy_approval
 * 
 * @author liwen
 * @date 2024-05-16
 */
public class SubsidyApproval extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审批ID */
    private Long approvalId;

    /** 申请ID */
    @Excel(name = "申请ID")
    private Long applicationId;

    /** 审批人员ID */
    @Excel(name = "审批人员ID")
    private Long approverUserId;

    /** 审批状态（待审批、通过、拒绝） */
    @Excel(name = "审批状态", readConverterExp = "待=审批、通过、拒绝")
    private String approvalStatus;

    /** 审批意见 */
    @Excel(name = "审批意见")
    private String approvalComments;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approvalDate;

    public void setApprovalId(Long approvalId) 
    {
        this.approvalId = approvalId;
    }

    public Long getApprovalId() 
    {
        return approvalId;
    }
    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setApproverUserId(Long approverUserId) 
    {
        this.approverUserId = approverUserId;
    }

    public Long getApproverUserId() 
    {
        return approverUserId;
    }
    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
    }
    public void setApprovalComments(String approvalComments) 
    {
        this.approvalComments = approvalComments;
    }

    public String getApprovalComments() 
    {
        return approvalComments;
    }
    public void setApprovalDate(Date approvalDate) 
    {
        this.approvalDate = approvalDate;
    }

    public Date getApprovalDate() 
    {
        return approvalDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("approvalId", getApprovalId())
            .append("applicationId", getApplicationId())
            .append("approverUserId", getApproverUserId())
            .append("approvalStatus", getApprovalStatus())
            .append("approvalComments", getApprovalComments())
            .append("approvalDate", getApprovalDate())
            .toString();
    }
}
