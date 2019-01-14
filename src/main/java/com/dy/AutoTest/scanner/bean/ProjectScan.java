package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;
import java.sql.Date;

public class ProjectScan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7845211197829817282L;

	private Long idTaProject;
	private Long idTestproject;
	private String taSvnurl;
	private String jobName;
	private Date updateDate;
	private Date createDate;
	private String nodeName;
	private String taType;

	public Long getIdTaProject() {
		return idTaProject;
	}

	public void setIdTaProject(Long idTaProject) {
		this.idTaProject = idTaProject;
	}

	public Long getIdTestproject() {
		return idTestproject;
	}

	public void setIdTestproject(Long idTestproject) {
		this.idTestproject = idTestproject;
	}

	public String getTaSvnurl() {
		return taSvnurl;
	}

	public void setTaSvnurl(String taSvnurl) {
		this.taSvnurl = taSvnurl;
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

	public String getTaType() {
		return taType;
	}

	public void setTaType(String taType) {
		this.taType = taType;
	}

}
