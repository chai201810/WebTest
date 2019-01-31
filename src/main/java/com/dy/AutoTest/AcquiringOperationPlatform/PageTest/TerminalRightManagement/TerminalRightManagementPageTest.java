package com.dy.AutoTest.AcquiringOperationPlatform.PageTest.TerminalRightManagement;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.web.api.SuperTest;
import com.dy.AutoTest.AcquiringOperationPlatform.PageObject.TerminalRightManagement.TerminalRightManagementPage;
import com.dy.AutoTest.AcquiringOperationPlatform.POJO.TerminalRightManagement_TerminalRightManagementBean;
import com.dy.AutoTest.web.business.DataBusiness;

public class TerminalRightManagementPageTest extends SuperTest{
	TerminalRightManagementPage TerminalRightManagementPage;
	String URL;

	@BeforeClass
	public void init() {
		/******** instant objectPage *********/
		TerminalRightManagementPage=new TerminalRightManagementPage(driver);
		//TerminalRightManagementPage.setWaitTime(800);

		/******** set URL *********/
		URL=host.toString()+DataBusiness.getData_URL("aop_TerminalRightManagement_TerminalRightManagement");

		/******** instant Interface *********/
		iQuery=TerminalRightManagementPage;
//		iClickButton=TerminalRightManagementPage;
//		iClickRadio=TerminalRightManagementPage;
//		iSearchMerchantByNOorName=TerminalRightManagementPage;
	}

	@DataProvider(name="TerminalRightManagement_TerminalRightManagement")
	protected static Object[][] parametersPool(){
		data.loadDataBeanList("AOP_Data_TerminalRightManagement_TerminalRightManagement",TerminalRightManagement_TerminalRightManagementBean.class);
		return data.getDataBeanArray();
	}

	@DataProvider(name="TerminalRightManagement_TerminalRightManagementByCaseNO")
	protected static Object[][] parametersPool(Method method){
		data.loadDataBeanList("AOP_Data_TerminalRightManagement_TerminalRightManagement",method.getName(),TerminalRightManagement_TerminalRightManagementBean.class);
		return data.getDataBeanArray();
	}

	@Test(dataProvider="TerminalRightManagement_TerminalRightManagementByCaseNO")
	public void testQuery(TerminalRightManagement_TerminalRightManagementBean bean) {
		TerminalRightManagementPage.navigateTo(URL);
		wait.waitFor(500);

	}
	@Test(dataProvider="TerminalRightManagement_TerminalRightManagementByCaseNO")
	public void testCheck(TerminalRightManagement_TerminalRightManagementBean bean) {
		TerminalRightManagementPage.navigateTo(URL);
		
		TerminalRightManagementPage.setMerchantNO(bean.getMerchantNO());
		TerminalRightManagementPage.setTerminalNO(bean.getTerminalNO());
		
		wait.waitFor(500);
		doQueryForClickButton(bean);
		
		TerminalRightManagementPage.clickCheckRight();
		
		wait.waitFor(2000);
		TerminalRightManagementPage.clickCheckRight_Close();
	}
	@Test(dataProvider="TerminalRightManagement_TerminalRightManagementByCaseNO")
	public void testDelete(TerminalRightManagement_TerminalRightManagementBean bean) {
		TerminalRightManagementPage.navigateTo(URL);
		wait.waitFor(500);
		doQueryForClickButton(bean);
		TerminalRightManagementPage.clickDelete();
		wait.waitFor(1000);
//		TerminalRightManagementPage.clickDelete_Confirm();
//		System.out.println(TerminalRightManagementPage.getNotice());
//		Reporter.log(TerminalRightManagementPage.getNotice());
		TerminalRightManagementPage.clickDelete_Close();
	}
	@Test(dataProvider="TerminalRightManagement_TerminalRightManagementByCaseNO")
	public void testUpdate(TerminalRightManagement_TerminalRightManagementBean bean) {
		TerminalRightManagementPage.navigateTo(URL);
		wait.waitFor(500);
		doQueryForClickButton(bean);
		TerminalRightManagementPage.clickUpdate();
		wait.waitFor(1000);
//		判断update字段是否为空

		wait.waitFor(1000);
//		TerminalRightManagementPage.clickUpdate_Submit();
//		System.out.println(TerminalRightManagementPage.getNotice());
//		Reporter.log(TerminalRightManagementPage.getNotice());
		TerminalRightManagementPage.clickUpdate_Close();
	}
	@Test(dataProvider="TerminalRightManagement_TerminalRightManagementByCaseNO")
	public void testAdd(TerminalRightManagement_TerminalRightManagementBean bean) {
		TerminalRightManagementPage.navigateTo(URL);
		wait.waitFor(500);
//		add需要先判断必输项的测试数据是否为空

//			System.out.println("验证方式字段为必输项，不能为空");
//			Reporter.log("验证方式字段为必输项，不能为空");
//			assertTrue(false);

		TerminalRightManagementPage.clickAdd();
		wait.waitFor(1000);

//		TerminalRightManagementPage.clickAdd_Submit();
//		System.out.println(TerminalRightManagementPage.getNotice());
//		Reporter.log(TerminalRightManagementPage.getNotice());
		TerminalRightManagementPage.clickAdd_Close();
	}


	public void doQueryForClickButton(TerminalRightManagement_TerminalRightManagementBean bean) {

		TerminalRightManagementPage.clickQuery();
		wait.waitFor(500);
		TerminalRightManagementPage.clickTerminalRadio(bean.getTerminalRadio());
		wait.waitFor(500);
	}
}