package com.dy.AutoTest.OnlineCashier.PageObject.cooperatingagent.agentinfo;

import org.openqa.selenium.WebDriver;

import com.dy.AutoTest.OperationPlatform.PageObject.SuperPage;
import com.dy.AutoTest.web.actions.DoPlus;

public class CooperatingPaymentChannelPage extends SuperPage {

	public CooperatingPaymentChannelPage(WebDriver driver) {
		super(driver);
		du.loadLocator("POP_Loc_CooperatingPaymentChannel");
	}

	@Override
	public void setWaitTime(long waitTime) {
		du=new DoPlus(driver);
		du.waitTime=waitTime;
		du.loadLocator("POP_Loc_CooperatingPaymentChannel");
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
	
	
	
	public void setFocusOnBankCode() {
		du.what("BankCode").click();
	}
	
	public void inputBankCode(String value) {
		du.what("BankCode").clear();
		du.what("BankCode").sendKeys(value);
	}
	
	public void setFocusOnCashAccount() {
		du.what("CashAccount").click();
	}
	
	public void inputCashAccount(String value) {
		du.what("CashAccount").clear();
		du.what("CashAccount").sendKeys(value);
	}
	
	public void setFocusOnSettleBankCode() {
		du.what("SettleBankCode").click();
	}
	
	public void inputSettleBankCode(String value) {
		du.what("SettleBankCode").clear();
		du.what("SettleBankCode").sendKeys(value);
	}
	
	public void setFocusOnSettleAccountName() {
		du.what("SettleAccountName").click();
	}
	
	public void inputSettleAccountName(String value) {
		du.what("SettleAccountName").clear();
		du.what("SettleAccountName").sendKeys(value);
	}
	
	public void setFocusOnSettleAccount() {
		du.what("SettleAccount").click();
	}
	
	public void inputSettleAccount(String value) {
		du.what("SettleAccount").clear();
		du.what("SettleAccount").sendKeys(value);
	}
	
	public void setFocusOnMerchantNumber() {
		du.what("MerchantNumber").click();
	}
	
	public void inputMerchantNumber(String value) {
		du.what("MerchantNumber").clear();
		du.what("MerchantNumber").sendKeys(value);
	}
	
	
	
	public void setFocusOnContactName() {
		du.what("ContactName").click();
	}
	
	public void inputContactName(String contactName) {
		du.what("ContactName").clear();
		du.what("ContactName").sendKeys(contactName);
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
