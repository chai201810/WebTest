package com.dy.AutoTest.OperationPlatform.TestCases.cooperatingagent.routeinfo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OperationPlatform.POJO.CooperatingRouteInfoBean;
import com.dy.AutoTest.OperationPlatform.PageObject.cooperatingagent.routeinfo.CooperatingRouteInfoPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.business.DataBusiness;

public class CooperatingRouteInfoPageTest extends SuperTest {

	private CooperatingRouteInfoPage cooperatingRouteInfoPage;

	private String URL = "";

	@BeforeClass
	public void init() {
		cooperatingRouteInfoPage = new CooperatingRouteInfoPage(driver);
		URL = host.toString() + DataBusiness.getData_URL("pop_CooperatingRouteInfo");
	}

	@DataProvider(name = "cooperatingRouteInfo")
	protected static Object[][] parametersPool() {
		data.loadDataBeanList("POP_Data_CooperatingRouteInfo");
		return data.getDataBeanArray();
	}

	@Test(dataProvider = "cooperatingRouteInfo")
	public void testCooperatingRouteInfo(CooperatingRouteInfoBean cooperatingRouteInfoBean) {

		cooperatingRouteInfoPage.navigateTo(URL);
		
		cooperatingRouteInfoPage.setFocusOnSearch();
		cooperatingRouteInfoPage.queryOnSearch(cooperatingRouteInfoBean.getSearch());
		
		wait.waitFor(1000);
		
		cooperatingRouteInfoPage.selectFirstRecord();
		cooperatingRouteInfoPage.clickModifyButton();
		
		cooperatingRouteInfoPage.submitModify();
	}
	
}
