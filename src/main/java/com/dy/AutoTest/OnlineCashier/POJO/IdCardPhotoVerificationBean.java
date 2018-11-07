package com.dy.AutoTest.OnlineCashier.POJO;

import java.io.Serializable;

public class IdCardPhotoVerificationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8269575876446665460L;

	private int ID;
	private String UserMobile;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserMobile() {
		return UserMobile;
	}

	public void setUserMobile(String userMobile) {
		UserMobile = userMobile;
	}

}
