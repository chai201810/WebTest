package com.dy.AutoTest.OnlineCashier.TestCases.cooperatingagent.agentinfo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OnlineCashier.POJO.CooperatingAgentInfoBean;
import com.dy.AutoTest.OnlineCashier.PageObject.cooperatingagent.agentinfo.CooperatingAgentInfoPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.business.DataBusiness;

public class CooperatingAgentInfoPageTest extends SuperTest {

	private CooperatingAgentInfoPage cooperatingAgentInfoPage;

	private String URL = "";

	@BeforeClass
	public void init() {
		cooperatingAgentInfoPage = new CooperatingAgentInfoPage(driver);
		URL = host.toString() + DataBusiness.getData_URL("pop_CooperatingAgencyInfo");
	}

	@DataProvider(name = "cooperatingAgencyInfo")
	protected static Object[][] parametersPool() {
		data.loadDataBeanList("POP_Data_CooperatingAgencyInfo");
		return data.getDataBeanArray();
	}

	@Test(dataProvider = "cooperatingAgencyInfo")
	public void testCooperatingAgencyInfo(CooperatingAgentInfoBean cooperatingAgentInfoBean) {

		cooperatingAgentInfoPage.navigateTo(URL);
		
		cooperatingAgentInfoPage.setFocusOnSearch();
		cooperatingAgentInfoPage.queryOnSearch("HBCB");
		
		wait.waitFor(1000);
		
		cooperatingAgentInfoPage.selectFirstRecord();
		cooperatingAgentInfoPage.clickModifyButton();
		
		cooperatingAgentInfoPage.setFocusOnContactName();
		cooperatingAgentInfoPage.inputContactName("1");
		
		cooperatingAgentInfoPage.setFocusOnContactTelephone();
		cooperatingAgentInfoPage.inputContactTelephone("2");
		
		cooperatingAgentInfoPage.setFocusOnCustomerManager();
		cooperatingAgentInfoPage.inputCustomerManager("3");
		
		cooperatingAgentInfoPage.submitModify();
		
		wait.waitFor(1000);
		
		cooperatingAgentInfoPage.selectFirstRecord();
		cooperatingAgentInfoPage.clickModifyButton();
		
		cooperatingAgentInfoPage.setFocusOnContactName();
		cooperatingAgentInfoPage.inputContactName("");
		
		cooperatingAgentInfoPage.setFocusOnContactTelephone();
		cooperatingAgentInfoPage.inputContactTelephone("");
		
		cooperatingAgentInfoPage.setFocusOnCustomerManager();
		cooperatingAgentInfoPage.inputCustomerManager("");
		
		cooperatingAgentInfoPage.submitModify();
	}

}
