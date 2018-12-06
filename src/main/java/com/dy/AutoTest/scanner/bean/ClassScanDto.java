package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;
import java.util.List;

public class ClassScanDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 463392800431848929L;

	private String filePath;
	private String packageName;
	private String className;
	private List<MethodScanDto> methodList;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public List<MethodScanDto> getMethodList() {
		return methodList;
	}

	public void setMethodList(List<MethodScanDto> methodList) {
		this.methodList = methodList;
	}

}
