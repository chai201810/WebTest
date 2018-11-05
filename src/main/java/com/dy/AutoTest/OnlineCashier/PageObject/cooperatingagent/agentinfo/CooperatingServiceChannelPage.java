package com.dy.AutoTest.OnlineCashier.PageObject.cooperatingagent.agentinfo;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;

public class CooperatingServiceChannelPage extends SuperPage {

	public CooperatingServiceChannelPage(WebDriver driver) {
		super(driver);
		du.loadLocator("POP_Loc_CooperatingServiceChannel");
	}

	@Override
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_CooperatingServiceChannel");
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
	
	public void submitModify() {
		du.what("ModifySubmit").click();
	}
	
}
