/**
 *
 */
package com.fz.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Spark任务监控简要信息类
 * @2017-1-23 添加输入路径／算法类别
 *
 * @author fansy
 * @date 2017-1-2
 */
@Entity
@Table(name = "jobInfo")
public class JobInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String jobId;

    public String getAlgoArgs() {
        return algoArgs;
    }

    public void setAlgoArgs(String algoArgs) {
        this.algoArgs = algoArgs;
    }

    @Enumerated(EnumType.STRING)
    public AlgoType getAlgoType() {
        return algoType;
    }

    public void setAlgoType(AlgoType algoType) {
        this.algoType = algoType;
    }

    private String algoArgs ;
    private AlgoType algoType;
    // 添加两个 属性
    private String jobName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    private String errorInfo;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Enumerated(EnumType.STRING)
    public JobState getRunState() {
        return runState;
    }

    public void setRunState(JobState runState) {
        this.runState = runState;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    private JobState runState;
    private Date startTime;
    private Date modifiedTime;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean isFinished) {
        this.finished = isFinished;
    }

    private boolean finished;


    public JobInfo() {
    }

    /**
     * 任务初始化
     *
     * @param jobId
     */
//    public JobInfo(String jobId, String jobName) {
//        this.jobId = jobId;
//        this.jobName = jobName;
//        this.errorInfo = "";// 设置此参数为空字符串，否则出现 NA
//        this.startTime = new Date(System.currentTimeMillis());
//        this.runState = JobState.SUBMITTED;
//        this.finished = false;
//    }
    /**
     * 任务初始化
     *
     * @param jobId
     * @param  jobName
     * @param algoArgs
     * @param algoType
     */
    public JobInfo(String jobId, String jobName,String algoArgs , AlgoType algoType) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.errorInfo = "";// 设置此参数为空字符串，否则出现 NA
        this.startTime = new Date(System.currentTimeMillis());
        this.runState = JobState.SUBMITTED;
        this.finished = false;
        this.algoType = algoType;
        this.algoArgs = algoArgs;
    }

    @Override
    public String toString() {
        return "jobID:" + this.jobId + ",state:" + this.runState;
    }
}
