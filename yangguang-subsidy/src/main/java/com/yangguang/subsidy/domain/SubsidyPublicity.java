package com.yangguang.subsidy.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yangguang.common.annotation.Excel;
import com.yangguang.common.core.domain.BaseEntity;

/**
 * 补贴公示对象 subsidy_publicity
 * 
 * @author liwen
 * @date 2024-05-16
 */
public class SubsidyPublicity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公示ID */
    private Long publicityId;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 公示开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "公示开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 公示结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "公示结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 公示期间上传文件 */
    @Excel(name = "公示期间上传文件")
    private String uploadedFiles;

    public void setPublicityId(Long publicityId) 
    {
        this.publicityId = publicityId;
    }

    public Long getPublicityId() 
    {
        return publicityId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
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
    public void setUploadedFiles(String uploadedFiles) 
    {
        this.uploadedFiles = uploadedFiles;
    }

    public String getUploadedFiles() 
    {
        return uploadedFiles;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("publicityId", getPublicityId())
            .append("projectId", getProjectId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("uploadedFiles", getUploadedFiles())
            .toString();
    }
}
