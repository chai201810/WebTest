package com.dy.AutoTest.OperationPlatform.TestCases.cooperatingagent.agentinfo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OperationPlatform.POJO.CooperatingPaymentChannelBean;
import com.dy.AutoTest.OperationPlatform.PageObject.cooperatingagent.agentinfo.CooperatingPaymentChannelPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.business.DataBusiness;

public class CooperatingPaymentChannelPageTest extends SuperTest {

	private CooperatingPaymentChannelPage cooperatingPaymentChannelPage;

	private String URL = "";

	@BeforeClass
	public void init() {
		cooperatingPaymentChannelPage = new CooperatingPaymentChannelPage(driver);
		URL = host.toString() + DataBusiness.getData_URL("pop_CooperatingPaymentChannel");
	}

	@DataProvider(name = "cooperatingAgencyInfo")
	protected static Object[][] parametersPool() {
		data.loadDataBeanList("POP_Data_CooperatingPaymentChannel");
		return data.getDataBeanArray();
	}

	@Test(dataProvider = "cooperatingAgencyInfo")
	public void testCooperatingPaymentChannel(CooperatingPaymentChannelBean cooperatingPaymentChannelBean) {

		cooperatingPaymentChannelPage.navigateTo(URL);
		
		cooperatingPaymentChannelPage.setFocusOnSearch();
		cooperatingPaymentChannelPage.queryOnSearch(cooperatingPaymentChannelBean.getSearch());
		
		wait.waitFor(1000);
		
		cooperatingPaymentChannelPage.selectFirstRecord();
		cooperatingPaymentChannelPage.clickModifyButton();
		
		cooperatingPaymentChannelPage.setFocusOnBankCode();
		cooperatingPaymentChannelPage.inputBankCode("1");
		
		cooperatingPaymentChannelPage.setFocusOnCashAccount();
		cooperatingPaymentChannelPage.inputCashAccount("2");
		
		cooperatingPaymentChannelPage.setFocusOnSettleBankCode();
		cooperatingPaymentChannelPage.inputSettleBankCode("3");
		
		cooperatingPaymentChannelPage.setFocusOnSettleAccountName();
		cooperatingPaymentChannelPage.inputSettleAccountName("4");
		
		cooperatingPaymentChannelPage.setFocusOnSettleAccount();
		cooperatingPaymentChannelPage.inputSettleAccount("5");
		
		cooperatingPaymentChannelPage.setFocusOnMerchantNumber();
		cooperatingPaymentChannelPage.inputMerchantNumber("6");
		
		cooperatingPaymentChannelPage.setFocusOnContactName();
		cooperatingPaymentChannelPage.inputContactName("7");
		
		cooperatingPaymentChannelPage.setFocusOnCustomerManager();
		cooperatingPaymentChannelPage.inputCustomerManager("8");
		
		cooperatingPaymentChannelPage.submitModify();
		
		wait.waitFor(1000);
		
		cooperatingPaymentChannelPage.selectFirstRecord();
		cooperatingPaymentChannelPage.clickModifyButton();
		
		cooperatingPaymentChannelPage.setFocusOnBankCode();
		cooperatingPaymentChannelPage.inputBankCode("");
		
		cooperatingPaymentChannelPage.setFocusOnCashAccount();
		cooperatingPaymentChannelPage.inputCashAccount("");
		
		cooperatingPaymentChannelPage.setFocusOnSettleBankCode();
		cooperatingPaymentChannelPage.inputSettleBankCode("");
		
		cooperatingPaymentChannelPage.setFocusOnSettleAccountName();
		cooperatingPaymentChannelPage.inputSettleAccountName("");
		
		cooperatingPaymentChannelPage.setFocusOnSettleAccount();
		cooperatingPaymentChannelPage.inputSettleAccount("");
		
		cooperatingPaymentChannelPage.setFocusOnMerchantNumber();
		cooperatingPaymentChannelPage.inputMerchantNumber("");
		
		cooperatingPaymentChannelPage.setFocusOnContactName();
		cooperatingPaymentChannelPage.inputContactName("");
		
		cooperatingPaymentChannelPage.setFocusOnCustomerManager();
		cooperatingPaymentChannelPage.inputCustomerManager("");
		
		cooperatingPaymentChannelPage.submitModify();
	}
	
	
	
	
	
	
}