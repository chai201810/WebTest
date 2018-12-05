package com.dy.AutoTest.scanner.bean;

import java.io.Serializable;

public class MethodScan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2916592648309271327L;

	private Long idDyMethod;
	private Long idDyClass;
	private String methodName;
	private String memo;
	private String dependsOnMethods;
	private String owner;

	public Long getIdDyMethod() {
		return idDyMethod;
	}

	public void setIdDyMethod(Long idDyMethod) {
		this.idDyMethod = idDyMethod;
	}

	public Long getIdDyClass() {
		return idDyClass;
	}

	public void setIdDyClass(Long idDyClass) {
		this.idDyClass = idDyClass;
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
