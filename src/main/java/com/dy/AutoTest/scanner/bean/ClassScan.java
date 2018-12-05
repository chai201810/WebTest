package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;

public class ClassScan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1382421213485322285L;

	private Long idDyClass;
	private Long idDyProject;
	private String packageName;
	private String className;
	private String filePath;
	private String memo;

	public Long getIdDyClass() {
		return idDyClass;
	}

	public void setIdDyClass(Long idDyClass) {
		this.idDyClass = idDyClass;
	}

	public Long getIdDyProject() {
		return idDyProject;
	}

	public void setIdDyProject(Long idDyProject) {
		this.idDyProject = idDyProject;
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
