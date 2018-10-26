package com.dy.AutoTest.OperationPlatform.PageObject.cooperatingagent.agentinfo;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;

public class CooperatingAgentInfoPage extends SuperPage {
	
	public CooperatingAgentInfoPage(WebDriver driver) {
		super(driver);
		du.loadLocator("POP_Loc_CooperatingAgencyInfo");
	}

	@Override
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_CooperatingAgencyInfo");
	}

	public void setFocusOnSearch() {
		du.what("AgentSearch").click();
	}
	
	public void queryOnSearch(String searchValue) {
		du.what("AgentSearch").sendKeys(searchValue);
	}
	
	public void selectFirstRecord() {
		du.what("FirstOrderSelect").click();
	}
	
	public void clickModifyButton() {
		du.what("ModifyAgent").click();
	}
	
	public void setFocusOnContactName() {
		du.what("ContactName").click();
	}
	
	public void inputContactName(String contactName) {
		du.what("ContactName").clear();
		du.what("ContactName").sendKeys(contactName);
	}
	
	public void setFocusOnContactTelephone() {
		du.what("ContactTelephone").click();
	}
	
	public void inputContactTelephone(String contactTelephone) {
		du.what("ContactTelephone").clear();
		du.what("ContactTelephone").sendKeys(contactTelephone);
	}
	
	public void setFocusOnCustomerManager() {
		du.what("CustomerManager").click();
	}
	
	public void inputCustomerManager(String customerManager) {
		du.what("CustomerManager").clear();
		du.what("CustomerManager").sendKeys(customerManager);
	}
	
	public void submitModify() {
		du.what("ModifySubmit").click();
	}
	
}
