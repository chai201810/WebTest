package com.dy.AutoTest.OperationPlatform.POJO;

import java.io.Serializable;

public class CooperatingPaymentChannelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4925311906480217537L;

	private int ID;
	private String Search;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getSearch() {
		return Search;
	}
	
	public void setSearch(String search) {
		Search = search;
	}

}
