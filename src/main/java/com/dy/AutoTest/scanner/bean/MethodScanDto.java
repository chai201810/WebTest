package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;

public class MethodScanDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1090648375840349834L;

	private String methodName;
	private String memo;
	private String depends;

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
