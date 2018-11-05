package com.dy.AutoTest.OnlineCashier.TestCases.cooperatingagent.agentinfo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OnlineCashier.POJO.CooperatingServiceChannelBean;
import com.dy.AutoTest.OnlineCashier.PageObject.cooperatingagent.agentinfo.CooperatingServiceChannelPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.business.DataBusiness;

public class CooperatingServiceChannelPageTest extends SuperTest {
	
	private CooperatingServiceChannelPage cooperatingServiceChannelPage;

	private String URL = "";

	@BeforeClass
	public void init() {
		cooperatingServiceChannelPage = new CooperatingServiceChannelPage(driver);
		URL = host.toString() + DataBusiness.getData_URL("pop_CooperatingServiceChannel");
	}

	@DataProvider(name = "cooperatingServiceChannel")
	protected static Object[][] parametersPool() {
		data.loadDataBeanList("POP_Data_CooperatingServiceChannel");
		return data.getDataBeanArray();
	}

	@Test(dataProvider = "cooperatingServiceChannel")
	public void testCooperatingServiceChannel(CooperatingServiceChannelBean cooperatingServiceChannelBean) {

		cooperatingServiceChannelPage.navigateTo(URL);
		
		cooperatingServiceChannelPage.setFocusOnSearch();
		cooperatingServiceChannelPage.queryOnSearch(cooperatingServiceChannelBean.getSearch());
		
		wait.waitFor(1000);
		
		cooperatingServiceChannelPage.selectFirstRecord();
		cooperatingServiceChannelPage.clickModifyButton();
		
		cooperatingServiceChannelPage.submitModify();
	}
	
}
