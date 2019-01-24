package com.dy.AutoTest.AcquiringOperationPlatform.PageTest.MachineInfoManagement;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.web.api.SuperTest;
import com.dy.AutoTest.AcquiringOperationPlatform.PageObject.MachineInfoManagement.TypeBrowsePage;
import com.dy.AutoTest.AcquiringOperationPlatform.POJO.MachineInfoManagement_TypeBrowseBean;
import com.dy.AutoTest.web.business.DataBusiness;

public class TypeBrowsePageTest extends SuperTest{
	TypeBrowsePage TypeBrowsePage;
	String URL;

	@BeforeClass
	public void init() {
		/******** instant objectPage *********/
		TypeBrowsePage=new TypeBrowsePage(driver);
		//TypeBrowsePage.setWaitTime(800);

		/******** set URL *********/
		URL=host.toString()+DataBusiness.getData_URL("aop_MachineInfoManagement_TypeBrowse");

		/******** instant Interface *********/
		iQuery=TypeBrowsePage;
//		iClickButton=TypeBrowsePage;
//		iClickRadio=TypeBrowsePage;
//		iSearchMerchantByNOorName=TypeBrowsePage;
	}

	@DataProvider(name="MachineInfoManagement_TypeBrowse")
	protected static Object[][] parametersPool(){
		data.loadDataBeanList("AOP_Data_MachineInfoManagement_TypeBrowse",MachineInfoManagement_TypeBrowseBean.class);
		return data.getDataBeanArray();
	}

	@DataProvider(name="MachineInfoManagement_TypeBrowseByCaseNO")
	protected static Object[][] parametersPool(Method method){
		data.loadDataBeanList("AOP_Data_MachineInfoManagement_TypeBrowse",method.getName(),MachineInfoManagement_TypeBrowseBean.class);
		return data.getDataBeanArray();
	}

	@Test(dataProvider="MachineInfoManagement_TypeBrowseByCaseNO")
	public void testQuery(MachineInfoManagement_TypeBrowseBean bean) {
		TypeBrowsePage.navigateTo(URL);
		wait.waitFor(500);

	}
	@Test(dataProvider="MachineInfoManagement_TypeBrowseByCaseNO")
	public void testCheck(MachineInfoManagement_TypeBrowseBean bean) {
		TypeBrowsePage.navigateTo(URL);
		wait.waitFor(500);
		
		TypeBrowsePage.setManufactureNO(bean.getManufactureName());
		TypeBrowsePage.setTypeNO(bean.getTypeNO());
		
		doQueryForClickButton(bean);
		TypeBrowsePage.clickCheck();
		wait.waitFor(2000);
		TypeBrowsePage.clickCheck_Close();
	}
	@Test(dataProvider="MachineInfoManagement_TypeBrowseByCaseNO")
	public void testDelete(MachineInfoManagement_TypeBrowseBean bean) {
		TypeBrowsePage.navigateTo(URL);
		wait.waitFor(500);
		doQueryForClickButton(bean);
		TypeBrowsePage.clickDelete();
		wait.waitFor(1000);
//		TypeBrowsePage.clickDelete_Confirm();
//		System.out.println(TypeBrowsePage.getNotice());
//		Reporter.log(TypeBrowsePage.getNotice());
		TypeBrowsePage.clickDelete_Close();
	}
	@Test(dataProvider="MachineInfoManagement_TypeBrowseByCaseNO")
	public void testUpdate(MachineInfoManagement_TypeBrowseBean bean) {
		TypeBrowsePage.navigateTo(URL);
		wait.waitFor(500);
		doQueryForClickButton(bean);
		TypeBrowsePage.clickUpdate();
		wait.waitFor(1000);
//		判断update字段是否为空

		wait.waitFor(1000);
//		TypeBrowsePage.clickUpdate_Submit();
//		System.out.println(TypeBrowsePage.getNotice());
//		Reporter.log(TypeBrowsePage.getNotice());
		TypeBrowsePage.clickUpdate_Close();
	}
	@Test(dataProvider="MachineInfoManagement_TypeBrowseByCaseNO")
	public void testAdd(MachineInfoManagement_TypeBrowseBean bean) {
		TypeBrowsePage.navigateTo(URL);
		wait.waitFor(500);
//		add需要先判断必输项的测试数据是否为空

//			System.out.println("验证方式字段为必输项，不能为空");
//			Reporter.log("验证方式字段为必输项，不能为空");
//			assertTrue(false);

		TypeBrowsePage.clickAdd();
		wait.waitFor(1000);

//		TypeBrowsePage.clickAdd_Submit();
//		System.out.println(TypeBrowsePage.getNotice());
//		Reporter.log(TypeBrowsePage.getNotice());
		TypeBrowsePage.clickAdd_Close();
	}


	public void doQueryForClickButton(MachineInfoManagement_TypeBrowseBean bean) {

		TypeBrowsePage.clickQuery();
		wait.waitFor(500);
		TypeBrowsePage.clickRadio(bean.getRadio());
		wait.waitFor(500);
	}
}