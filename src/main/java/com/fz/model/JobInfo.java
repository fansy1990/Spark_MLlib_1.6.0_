/**
 * 
 */
package com.fz.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Spark任务监控简要信息类
 * @author fansy
 * @date 2017-1-2
 */
@Entity
@Table(name="jobInfo")
public class JobInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
	private String jobId;
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


    public JobInfo(){}

    /**
     * 任务初始化
     * @param jobId
     */
    public JobInfo(String jobId){
        this.jobId = jobId;
        this.startTime = new Date(System.currentTimeMillis());
        this.runState= JobState.SUBMITTED;
        this.finished = false;
    }


	@Override
	public String toString(){
		return "jobID:"+this.jobId+",state:"+this.runState;
	}
}
