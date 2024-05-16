package com.yangguang.subsidy.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yangguang.common.annotation.Excel;
import com.yangguang.common.core.domain.BaseEntity;

/**
 * 补贴申请对象 subsidy_application
 *
 * @author liwen
 * @date 2024-05-16
 */
public class SubsidyApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请ID */
    private Long applicationId;

    /** 申请人员ID */
    @Excel(name = "申请人员ID")
    private Long applicantUserId;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String applicationStatus;

    /** 申请人姓名 */
    @Excel(name = "申请人姓名")
    private String applicantName;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String applicantIdNo;

    /** 性别（0男 1女 2未知） */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String applicantGender;

    /** 人员类别 */
    @Excel(name = "人员类别")
    private String applicantType;

    /** 上传材料 */
    @Excel(name = "上传材料")
    private String uploadedFiles;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationDate;

    public void setApplicationId(Long applicationId)
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId()
    {
        return applicationId;
    }
    public void setApplicantUserId(Long applicantUserId)
    {
        this.applicantUserId = applicantUserId;
    }

    public Long getApplicantUserId()
    {
        return applicantUserId;
    }
    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }
    public void setApplicationStatus(String applicationStatus)
    {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationStatus()
    {
        return applicationStatus;
    }
    public void setApplicantName(String applicantName)
    {
        this.applicantName = applicantName;
    }

    public String getApplicantName()
    {
        return applicantName;
    }
    public void setApplicantIdNo(String applicantIdNo)
    {
        this.applicantIdNo = applicantIdNo;
    }

    public String getApplicantIdNo()
    {
        return applicantIdNo;
    }
    public void setApplicantGender(String applicantGender)
    {
        this.applicantGender = applicantGender;
    }

    public String getApplicantGender()
    {
        return applicantGender;
    }
    public void setApplicantType(String applicantType)
    {
        this.applicantType = applicantType;
    }

    public String getApplicantType()
    {
        return applicantType;
    }
    public void setUploadedFiles(String uploadedFiles)
    {
        this.uploadedFiles = uploadedFiles;
    }

    public String getUploadedFiles()
    {
        return uploadedFiles;
    }
    public void setApplicationDate(Date applicationDate)
    {
        this.applicationDate = applicationDate;
    }

    public Date getApplicationDate()
    {
        return applicationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("applicationId", getApplicationId())
                .append("applicantUserId", getApplicantUserId())
                .append("projectId", getProjectId())
                .append("applicationStatus", getApplicationStatus())
                .append("applicantName", getApplicantName())
                .append("applicantIdNo", getApplicantIdNo())
                .append("applicantGender", getApplicantGender())
                .append("applicantType", getApplicantType())
                .append("uploadedFiles", getUploadedFiles())
                .append("applicationDate", getApplicationDate())
                .toString();
    }
}
