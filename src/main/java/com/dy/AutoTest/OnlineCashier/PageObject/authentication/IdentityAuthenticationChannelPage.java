package com.dy.AutoTest.OnlineCashier.PageObject.authentication;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;

public class IdentityAuthenticationChannelPage extends SuperPage {

	public IdentityAuthenticationChannelPage(WebDriver driver) {
		super(driver);
		du.loadLocator("POP_Loc_IdentityAutherticationChannel");
	}

	@Override
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_IdentityAutherticationChannel");
	}
	
	public void setFocusOnChannelCode() {
		du.what("ChannelCode").click();
	}
	
	public void queryOnChannelCode(String value) {
		du.what("ChannelCode").sendKeys(value);
	}
	
	public void setFocusOnChannelName() {
		du.what("ChannelName").click();
	}
	
	public void queryOnChannelName(String value) {
		du.what("ChannelName").sendKeys(value);
	}
	
	public void setFocusOnChannelCategory() {
		du.what("ChannelCategory").click();
	}
	
	public void queryOnChannelCategory(String value) {
		du.whatSelect("ChannelCategory").selectByValue(value);
	}
	
	public void setFocusOnChannelLevel() {
		du.what("ChannelLevel").click();
	}
	
	public void queryOnChannelLevel(String value) {
		du.whatSelect("ChannelLevel").selectByValue(value);
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
	
	public void submitModify() {
		du.what("ModifySubmit").click();
	}
	
	
}
