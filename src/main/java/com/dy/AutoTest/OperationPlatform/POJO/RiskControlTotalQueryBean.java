package com.dy.AutoTest.OperationPlatform.POJO;

import java.io.Serializable;

public class RiskControlTotalQueryBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private int ID;
	private String CaseNO;
	private String UserName;
	private String AccumulateWay;
	private String QueryDate;
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getCaseNO() {
		return CaseNO;
	}
	public void setCaseNO(String CaseNO) {
		this.CaseNO = CaseNO;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getAccumulateWay() {
		return AccumulateWay;
	}
	public void setAccumulateWay(String AccumulateWay) {
		this.AccumulateWay = AccumulateWay;
	}
	public String getQueryDate() {
		return QueryDate;
	}
	public void setQueryDate(String QueryDate) {
		this.QueryDate = QueryDate;
	}

}