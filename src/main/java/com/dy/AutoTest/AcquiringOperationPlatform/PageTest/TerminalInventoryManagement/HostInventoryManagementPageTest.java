package com.dy.AutoTest.AcquiringOperationPlatform.PageTest.TerminalInventoryManagement;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.web.api.SuperTest;
import com.dy.AutoTest.AcquiringOperationPlatform.PageObject.TerminalInventoryManagement.HostInventoryManagementPage;
import com.dy.AutoTest.AcquiringOperationPlatform.POJO.TerminalInventoryManagement_HostInventoryManagementBean;
import com.dy.AutoTest.web.business.DataBusiness;

public class HostInventoryManagementPageTest extends SuperTest{
	HostInventoryManagementPage HostInventoryManagementPage;
	String URL;

	@BeforeClass
	public void init() {
		/******** instant objectPage *********/
		HostInventoryManagementPage=new HostInventoryManagementPage(driver);
		//HostInventoryManagementPage.setWaitTime(800);

		/******** set URL *********/
		URL=host.toString()+DataBusiness.getData_URL("aop_TerminalInventoryManagement_HostInventoryManagement");

		/******** instant Interface *********/
		iQuery=HostInventoryManagementPage;
//		iClickButton=HostInventoryManagementPage;
//		iClickRadio=HostInventoryManagementPage;
//		iSearchMerchantByNOorName=HostInventoryManagementPage;
	}

	@DataProvider(name="TerminalInventoryManagement_HostInventoryManagement")
	protected static Object[][] parametersPool(){
		data.loadDataBeanList("AOP_Data_TerminalInventoryManagement_HostInventoryManagement",TerminalInventoryManagement_HostInventoryManagementBean.class);
		return data.getDataBeanArray();
	}

	@DataProvider(name="TerminalInventoryManagement_HostInventoryManagementByCaseNO")
	protected static Object[][] parametersPool(Method method){
		data.loadDataBeanList("AOP_Data_TerminalInventoryManagement_HostInventoryManagement",method.getName(),TerminalInventoryManagement_HostInventoryManagementBean.class);
		return data.getDataBeanArray();
	}

	@Test(dataProvider="TerminalInventoryManagement_HostInventoryManagementByCaseNO")
	public void testQuery(TerminalInventoryManagement_HostInventoryManagementBean bean) {
		HostInventoryManagementPage.navigateTo(URL);
		wait.waitFor(500);

	}
	@Test(dataProvider="TerminalInventoryManagement_HostInventoryManagementByCaseNO")
	public void testCheck(TerminalInventoryManagement_HostInventoryManagementBean bean) {
		HostInventoryManagementPage.navigateTo(URL);
		
		HostInventoryManagementPage.setTerminalSerialNO(bean.getTerminalSerialNO());
		HostInventoryManagementPage.setTermianlNO(bean.getTermianlNO());
		HostInventoryManagementPage.selectUseStatus(bean.getUseStatus());
		HostInventoryManagementPage.selectManufactureName(bean.getManufactureName());
		HostInventoryManagementPage.selectTerminalType(bean.getTerminalType());
		HostInventoryManagementPage.selectBelongOrgnizine(bean.getBelongOrgnizine());
		HostInventoryManagementPage.setMerchantNO(bean.getMerchantNO());
		HostInventoryManagementPage.setMerchantName(bean.getMerchantName());
		
		wait.waitFor(500);
		doQueryForClickButton(bean);
		HostInventoryManagementPage.clickCheck();
		wait.waitFor(2000);
		HostInventoryManagementPage.clickCheck_Close();
	}
	@Test(dataProvider="TerminalInventoryManagement_HostInventoryManagementByCaseNO")
	public void testDelete(TerminalInventoryManagement_HostInventoryManagementBean bean) {
		HostInventoryManagementPage.navigateTo(URL);
		wait.waitFor(500);
		doQueryForClickButton(bean);
//		HostInventoryManagementPage.clickDelete();
		wait.waitFor(1000);
//		HostInventoryManagementPage.clickDelete_Confirm();
//		System.out.println(HostInventoryManagementPage.getNotice());
//		Reporter.log(HostInventoryManagementPage.getNotice());
//		HostInventoryManagementPage.clickDelete_Close();
	}
	@Test(dataProvider="TerminalInventoryManagement_HostInventoryManagementByCaseNO")
	public void testUpdate(TerminalInventoryManagement_HostInventoryManagementBean bean) {
		HostInventoryManagementPage.navigateTo(URL);
		wait.waitFor(500);
		doQueryForClickButton(bean);
//		HostInventoryManagementPage.clickUpdate();
		wait.waitFor(1000);
//		判断update字段是否为空

		wait.waitFor(1000);
//		HostInventoryManagementPage.clickUpdate_Submit();
//		System.out.println(HostInventoryManagementPage.getNotice());
//		Reporter.log(HostInventoryManagementPage.getNotice());
//		HostInventoryManagementPage.clickUpdate_Close();
	}
	@Test(dataProvider="TerminalInventoryManagement_HostInventoryManagementByCaseNO")
	public void testAdd(TerminalInventoryManagement_HostInventoryManagementBean bean) {
		HostInventoryManagementPage.navigateTo(URL);
		wait.waitFor(500);
//		add需要先判断必输项的测试数据是否为空

//			System.out.println("验证方式字段为必输项，不能为空");
//			Reporter.log("验证方式字段为必输项，不能为空");
//			assertTrue(false);

//		HostInventoryManagementPage.clickAdd();
		wait.waitFor(1000);

//		HostInventoryManagementPage.clickAdd_Submit();
//		System.out.println(HostInventoryManagementPage.getNotice());
//		Reporter.log(HostInventoryManagementPage.getNotice());
//		HostInventoryManagementPage.clickAdd_Close();
	}


	public void doQueryForClickButton(TerminalInventoryManagement_HostInventoryManagementBean bean) {

		HostInventoryManagementPage.clickQuery();
		wait.waitFor(500);
		HostInventoryManagementPage.clickRadio(bean.getRadio());
		wait.waitFor(500);
	}
}