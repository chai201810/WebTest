package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;

public class MethodScan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2916592648309271327L;

	private Long idSvnMethod;
	private Long idSvnClass;
	private String methodName;
	private String memo;
	private String dependsOnMethods;
	private String owner;

	public Long getIdSvnMethod() {
		return idSvnMethod;
	}

	public void setIdSvnMethod(Long idSvnMethod) {
		this.idSvnMethod = idSvnMethod;
	}

	public Long getIdSvnClass() {
		return idSvnClass;
	}

	public void setIdSvnClass(Long idSvnClass) {
		this.idSvnClass = idSvnClass;
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

	public String getDependsOnMethods() {
		return dependsOnMethods;
	}

	public void setDependsOnMethods(String dependsOnMethods) {
		this.dependsOnMethods = dependsOnMethods;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
