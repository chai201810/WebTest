package com.dy.AutoTest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dy.AutoTest.web.actions.SingletonSet;
import com.dy.AutoTest.web.beans.LocatorBean;
import com.dy.AutoTest.web.business.LocatorBusiness;
import com.dy.AutoTest.web.util.FileUtil;
import com.dy.AutoTest.web.util.GenerateStringUtil;


public class AutoGenerateTest {
	private static LocatorBusiness locator=new LocatorBusiness();
	private StringBuffer pageObjectString=new StringBuffer();
	private String path;
	//com.dy.AutoTest.MerchantPortal.PageObject.base
	private static String directory="src\\main\\java\\com\\dy\\AutoTest\\MerchantPortal\\PageObject\\";
	private static String packageName="com.dy.AutoTest.MerchantPortal.PageObject";
	private static String className="SCUpdatePaymentPasswordPage";
	private static String locatorName="MP_Loc_SCUpdatePaymentPassword";
	
	@DataProvider(name="locator")
	protected static Object[][] parametersPoolForSqlite(){
		locator.loadLocatorBeanList(locatorName);
		return locator.getLocatorBeanArray();
	}
	
	
	
	@BeforeClass
	public void init() {
		
		path=directory+className+".java";
		
		pageObjectString.append(GenerateStringUtil.generatePackgaeMethod(packageName)
				+GenerateStringUtil.generateImportMethod()
				+GenerateStringUtil.generateClassIdentify(className,locatorName));
	}
	
	
	/*
	@Parameters({ "packageName","className","directory","locatorName"})
	@BeforeClass
	public void init(String packageName,String className,String directory,String locatorName) {
		
		path=directory+className+".java";
		
		
		pageObjectString.append(GenerateStringUtil.generatePackgaeMethod(packageName)
				+GenerateStringUtil.generateImportMethod()+GenerateStringUtil.generateImportMethod()
				+GenerateStringUtil.generateClassIdentify(className,locatorName));
	}
	*/
	@AfterClass
	public void end() {
		pageObjectString.append(GenerateStringUtil.classIdentifyEnd);
		FileUtil.loadFile(path);
		FileUtil.writeFileByByte(pageObjectString.toString());
		
		System.out.println(pageObjectString);
		SingletonSet.jdbcUtil_sqlite.releaseConn();
		SingletonSet.jdbcUtil_oracle.releaseConn();
	}
	
	@Test(dataProvider="locator")
	public void testAutoGenerate(LocatorBean LocatorBean) {
		if(LocatorBean.getElementName().equals("")) {
			System.out.println("ID为"+LocatorBean.getID()+"的ElementName是空");
			assertTrue(false);
		}
		if(LocatorBean.getType().equals("")) {
			System.out.println("ID为"+LocatorBean.getID()+"的Type是空");
			assertTrue(false);
		}
		pageObjectString.append(GenerateStringUtil.generateComment(LocatorBean.getComment()));
		
		pageObjectString.append(GenerateStringUtil.generator(LocatorBean));

		
	}
	
	
}
