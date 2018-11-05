package com.dy.AutoTest.OnlineCashier.TestCases.authentication;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OnlineCashier.POJO.IdentityAuthenticationChannelBean;
import com.dy.AutoTest.OnlineCashier.PageObject.authentication.IdentityAuthenticationChannelPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.business.DataBusiness;

public class IdentityAuthenticationChannelPageTest extends SuperTest {

	private IdentityAuthenticationChannelPage identityAuthenticationChannelPage;

	private String URL = "";

	@BeforeClass
	public void init() {
		identityAuthenticationChannelPage = new IdentityAuthenticationChannelPage(driver);
		URL = host.toString() + DataBusiness.getData_URL("pop_IdentityAuthenticationChannel");
	}

	@DataProvider(name = "identityAuthenticationChannel")
	protected static Object[][] parametersPool() {
		data.loadDataBeanList("POP_Data_IdentityAuthenticationChannel");
		return data.getDataBeanArray();
	}

	@Test(dataProvider = "identityAuthenticationChannel")
	public void testIdentityAuthenticationChannel(IdentityAuthenticationChannelBean identityAuthenticationChannelBean) {

		identityAuthenticationChannelPage.navigateTo(URL);
		
		identityAuthenticationChannelPage.setFocusOnChannelCode();
		identityAuthenticationChannelPage.queryOnChannelCode(identityAuthenticationChannelBean.getChannelCode());
		
		identityAuthenticationChannelPage.setFocusOnChannelName();
		identityAuthenticationChannelPage.queryOnChannelName(identityAuthenticationChannelBean.getChannelName());
		
		identityAuthenticationChannelPage.setFocusOnChannelCategory();
		identityAuthenticationChannelPage.queryOnChannelCategory(identityAuthenticationChannelBean.getChannelCategory());
		
		identityAuthenticationChannelPage.setFocusOnChannelLevel();
		identityAuthenticationChannelPage.queryOnChannelLevel(identityAuthenticationChannelBean.getChannelLevel());
		
		identityAuthenticationChannelPage.clickQuery();
		
		wait.waitFor(1000);
		
		identityAuthenticationChannelPage.selectFirstRecord();
		identityAuthenticationChannelPage.clickModifyButton();
		
		identityAuthenticationChannelPage.setFocusOnContactName();
		identityAuthenticationChannelPage.inputContactName("1");
		
		identityAuthenticationChannelPage.setFocusOnContactTelephone();
		identityAuthenticationChannelPage.inputContactTelephone("2");
		
		identityAuthenticationChannelPage.submitModify();
		
		wait.waitFor(1000);
		
		identityAuthenticationChannelPage.selectFirstRecord();
		identityAuthenticationChannelPage.clickModifyButton();
		
		identityAuthenticationChannelPage.setFocusOnContactName();
		identityAuthenticationChannelPage.inputContactName("");
		
		identityAuthenticationChannelPage.setFocusOnContactTelephone();
		identityAuthenticationChannelPage.inputContactTelephone("");
		
		identityAuthenticationChannelPage.submitModify();
	}
	
}
