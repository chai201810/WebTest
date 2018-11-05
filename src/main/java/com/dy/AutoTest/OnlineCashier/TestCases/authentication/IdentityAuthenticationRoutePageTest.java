package com.dy.AutoTest.OnlineCashier.TestCases.authentication;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OnlineCashier.POJO.IdentityAuthenticationRouteBean;
import com.dy.AutoTest.OnlineCashier.PageObject.authentication.IdentityAuthenticationRoutePage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.business.DataBusiness;

public class IdentityAuthenticationRoutePageTest extends SuperTest {

	private IdentityAuthenticationRoutePage identityAuthenticationRoutePage;

	private String URL = "";

	@BeforeClass
	public void init() {
		identityAuthenticationRoutePage = new IdentityAuthenticationRoutePage(driver);
		URL = host.toString() + DataBusiness.getData_URL("pop_IdentityAuthenticationRoute");
	}

	@DataProvider(name = "identityAuthenticationRoute")
	protected static Object[][] parametersPool() {
		data.loadDataBeanList("POP_Data_IdentityAuthenticationRoute");
		return data.getDataBeanArray();
	}

	@Test(dataProvider = "identityAuthenticationRoute")
	public void testIdentityAuthenticationRoute(IdentityAuthenticationRouteBean identityAuthenticationRouteBean) {

		identityAuthenticationRoutePage.navigateTo(URL);
		
		identityAuthenticationRoutePage.setFocusOnCertificateType();
		identityAuthenticationRoutePage.queryOnCertificateType(identityAuthenticationRouteBean.getCertificateType());
		
		identityAuthenticationRoutePage.setFocusOnServiceType();
		identityAuthenticationRoutePage.queryOnServiceType(identityAuthenticationRouteBean.getServiceType());
		
		identityAuthenticationRoutePage.setFocusOnRouteChannelCode();
		identityAuthenticationRoutePage.queryOnRouteChannelCode(identityAuthenticationRouteBean.getRouteChannelCode());
		
		identityAuthenticationRoutePage.clickQuery();
		
		wait.waitFor(1000);
		
		identityAuthenticationRoutePage.selectFirstRecord();
		identityAuthenticationRoutePage.clickModifyButton();
		
		identityAuthenticationRoutePage.submitModify();
	}

}
