package com.dy.AutoTest.OperationPlatform.POJO;

import java.io.Serializable;

public class AccountManageOfflineInternalAccountPaymentQueryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3536984916234671969L;

	private int ID;
	private String CaseNo;
	private String InnerAccountNO;
	private String DateBegin;
	private String DateEnd;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCaseNo() {
		return CaseNo;
	}

	public void setCaseNo(String caseNo) {
		CaseNo = caseNo;
	}

	public String getInnerAccountNO() {
		return InnerAccountNO;
	}

	public void setInnerAccountNO(String innerAccountNO) {
		InnerAccountNO = innerAccountNO;
	}

	public String getDateBegin() {
		return DateBegin;
	}

	public void setDateBegin(String dateBegin) {
		DateBegin = dateBegin;
	}

	public String getDateEnd() {
		return DateEnd;
	}

	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}

}
