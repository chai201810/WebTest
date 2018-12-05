package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;

public class ScanDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 463392800431848929L;

	private String className;
	private String methodName;
	private String memo;
	private String depends;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDepends() {
		return depends;
	}

	public void setDepends(String depends) {
		this.depends = depends;
	}

}
