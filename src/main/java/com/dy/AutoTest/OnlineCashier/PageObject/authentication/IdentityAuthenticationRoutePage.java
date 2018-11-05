package com.dy.AutoTest.OnlineCashier.PageObject.authentication;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;

public class IdentityAuthenticationRoutePage extends SuperPage {

	public IdentityAuthenticationRoutePage(WebDriver driver) {
		super(driver);
		du.loadLocator("POP_Loc_IdentityAuthenticationRoute");
	}

	@Override
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_IdentityAuthenticationRoute");
	}

}
