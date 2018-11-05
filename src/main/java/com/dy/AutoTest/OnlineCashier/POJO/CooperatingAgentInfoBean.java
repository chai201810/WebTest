package com.dy.AutoTest.OnlineCashier.POJO;

import java.io.Serializable;

public class CooperatingAgentInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1862458995135514766L;

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
