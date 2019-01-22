package com.dy.AutoTest.AcquiringOperationPlatform.PageTest.MachineInfoManagement;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.web.api.SuperTest;
import com.dy.AutoTest.AcquiringOperationPlatform.PageObject.MachineInfoManagement.ManufacturerInfoBrowsePage;
import com.dy.AutoTest.AcquiringOperationPlatform.POJO.MachineInfoManagement_ManufacturerInfoBrowseBean;
import com.dy.AutoTest.web.business.DataBusiness;

public class ManufacturerInfoBrowsePageTest extends SuperTest{
	ManufacturerInfoBrowsePage ManufacturerInfoBrowsePage;
	String URL;

	@BeforeClass
	public void init() {
		/******** instant objectPage *********/
		ManufacturerInfoBrowsePage=new ManufacturerInfoBrowsePage(driver);

		/******** set URL *********/
		URL=host.toString()+DataBusiness.getData_URL("aop_MachineInfoManagement_ManufacturerInfoBrowse");

		/******** instant Interface *********/
		iQuery=ManufacturerInfoBrowsePage;
	}

	@DataProvider(name="MachineInfoManagement_ManufacturerInfoBrowse")
	protected static Object[][] parametersPool(){
		data.loadDataBeanList("AOP_Data_MachineInfoManagement_ManufacturerInfoBrowse",MachineInfoManagement_ManufacturerInfoBrowseBean.class);
		return data.getDataBeanArray();
	}

	@DataProvider(name="MachineInfoManagement_ManufacturerInfoBrowseByCaseNO")
	protected static Object[][] parametersPool(Method method){
		data.loadDataBeanList("AOP_Data_MachineInfoManagement_ManufacturerInfoBrowse",method.getName(),MachineInfoManagement_ManufacturerInfoBrowseBean.class);
		return data.getDataBeanArray();
	}

//	@Test(dataProvider="MachineInfoManagement_ManufacturerInfoBrowseByCaseNO")
//	public void testQuery(MachineInfoManagement_ManufacturerInfoBrowseBean bean) {
//		ManufacturerInfoBrowsePage.navigateTo(URL);
//		
//		ManufacturerInfoBrowsePage.setManufacturerNO(bean.getManufacturerNO());
//		ManufacturerInfoBrowsePage.setManufacturerName(bean.getManufacturerName());
//		
//		ManufacturerInfoBrowsePage.clickQuery();
//		
//		wait.waitFor(500);
//
//	}
	@Test(dataProvider="MachineInfoManagement_ManufacturerInfoBrowseByCaseNO")
	public void testCheck(MachineInfoManagement_ManufacturerInfoBrowseBean bean) {
		ManufacturerInfoBrowsePage.navigateTo(URL);
		
		ManufacturerInfoBrowsePage.setManufacturerNO(bean.getManufacturerNO());
		ManufacturerInfoBrowsePage.setManufacturerName(bean.getManufacturerName());
		
		doQueryForClickButton(bean);
		ManufacturerInfoBrowsePage.clickCheck();
		wait.waitFor(2000);
		ManufacturerInfoBrowsePage.clickCheck_Close();
	}
	@Test(dataProvider="MachineInfoManagement_ManufacturerInfoBrowseByCaseNO")
	public void testDelete(MachineInfoManagement_ManufacturerInfoBrowseBean bean) {
		ManufacturerInfoBrowsePage.navigateTo(URL);
		wait.waitFor(500);
		doQueryForClickButton(bean);
		ManufacturerInfoBrowsePage.clickDelete();
		wait.waitFor(1000);
//		ManufacturerInfoBrowsePage.clickDelete_Confirm();
//		System.out.println(ManufacturerInfoBrowsePage.getNotice());
//		Reporter.log(ManufacturerInfoBrowsePage.getNotice());
		ManufacturerInfoBrowsePage.clickDelete_Close();
	}
	@Test(dataProvider="MachineInfoManagement_ManufacturerInfoBrowseByCaseNO")
	public void testUpdate(MachineInfoManagement_ManufacturerInfoBrowseBean bean) {
		ManufacturerInfoBrowsePage.navigateTo(URL);
		wait.waitFor(500);
		doQueryForClickButton(bean);
		ManufacturerInfoBrowsePage.clickUpdate();
		wait.waitFor(1000);
//		判断update字段是否为空

		wait.waitFor(1000);
//		ManufacturerInfoBrowsePage.clickUpdate_Submit();
//		System.out.println(ManufacturerInfoBrowsePage.getNotice());
//		Reporter.log(ManufacturerInfoBrowsePage.getNotice());
		ManufacturerInfoBrowsePage.clickUpdate_Close();
	}
	@Test(dataProvider="MachineInfoManagement_ManufacturerInfoBrowseByCaseNO")
	public void testAdd(MachineInfoManagement_ManufacturerInfoBrowseBean bean) {
		ManufacturerInfoBrowsePage.navigateTo(URL);
		wait.waitFor(500);
//		add需要先判断必输项的测试数据是否为空

//			System.out.println("验证方式字段为必输项，不能为空");
//			Reporter.log("验证方式字段为必输项，不能为空");
//			assertTrue(false);

		ManufacturerInfoBrowsePage.clickAdd();
		wait.waitFor(1000);

//		ManufacturerInfoBrowsePage.clickAdd_Submit();
//		System.out.println(ManufacturerInfoBrowsePage.getNotice());
//		Reporter.log(ManufacturerInfoBrowsePage.getNotice());
		ManufacturerInfoBrowsePage.clickAdd_Close();
	}


	public void doQueryForClickButton(MachineInfoManagement_ManufacturerInfoBrowseBean bean) {

		ManufacturerInfoBrowsePage.clickQuery();
		wait.waitFor(500);
		ManufacturerInfoBrowsePage.clickRadio(bean.getRadio());
		wait.waitFor(500);
	}
}