package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;

public class ClassScan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1382421213485322285L;

	private Long idSvnClass;
	private Long idTaProject;
	private String packageName;
	private String className;
	private String filePath;
	private String memo;

	public Long getIdSvnClass() {
		return idSvnClass;
	}

	public void setIdSvnClass(Long idSvnClass) {
		this.idSvnClass = idSvnClass;
	}

	public Long getIdTaProject() {
		return idTaProject;
	}

	public void setIdTaProject(Long idTaProject) {
		this.idTaProject = idTaProject;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
