package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;
import java.sql.Date;

public class ProjectScan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7845211197829817282L;

	private Long idDyProject;
	private Long idTestproject;
	private String dyGiturl;
	private String jobName;
	private Date updateDate;
	private Date createDate;
	private String nodeName;
	private String dyType;

	public Long getIdDyProject() {
		return idDyProject;
	}

	public void setIdDyProject(Long idDyProject) {
		this.idDyProject = idDyProject;
	}

	public Long getIdTestproject() {
		return idTestproject;
	}

	public void setIdTestproject(Long idTestproject) {
		this.idTestproject = idTestproject;
	}

	public String getDyGiturl() {
		return dyGiturl;
	}

	public void setDyGiturl(String dyGiturl) {
		this.dyGiturl = dyGiturl;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getDyType() {
		return dyType;
	}

	public void setDyType(String dyType) {
		this.dyType = dyType;
	}

}
