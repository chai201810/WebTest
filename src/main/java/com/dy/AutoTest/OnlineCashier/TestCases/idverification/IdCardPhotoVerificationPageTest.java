package com.dy.AutoTest.OnlineCashier.TestCases.idverification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.OnlineCashier.POJO.IdCardPhotoVerificationBean;
import com.dy.AutoTest.OnlineCashier.PageObject.idverification.IdCardPhotoVerificationPage;
import com.dy.AutoTest.OperationPlatform.TestCases.SuperTest;
import com.dy.AutoTest.web.business.DataBusiness;

public class IdCardPhotoVerificationPageTest extends SuperTest {
	
	private IdCardPhotoVerificationPage idCardPhotoVerificationPage;

	private String URL = "";

	@BeforeClass
	public void init() {
		idCardPhotoVerificationPage = new IdCardPhotoVerificationPage(driver);
		URL = host.toString() + DataBusiness.getData_URL("pop_IdCardPhotoVerification");
	}

	@DataProvider(name = "idCardPhotoVerification")
	protected static Object[][] parametersPool() {
		data.loadDataBeanList("POP_Data_IdCardPhotoVerification");
		return data.getDataBeanArray();
	}

	@Test(dataProvider = "idCardPhotoVerification")
	public void testIdCardPhotoVerification(IdCardPhotoVerificationBean idCardPhotoVerificationBean) {

		idCardPhotoVerificationPage.navigateTo(URL);
		
		idCardPhotoVerificationPage.setFocusOnUserMobile();
		idCardPhotoVerificationPage.queryOnUserMobile(idCardPhotoVerificationBean.getUserMobile());
		
		idCardPhotoVerificationPage.clickReset();
		idCardPhotoVerificationPage.clickQuery();
		
		wait.waitFor(1000);
		
		idCardPhotoVerificationPage.selectFirstRecord();
		idCardPhotoVerificationPage.clickVerifyButton();
		
		wait.waitFor(1000);
		
		idCardPhotoVerificationPage.clickCloseButton();
	}
	
}
