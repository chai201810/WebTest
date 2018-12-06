package com.dy.AutoTest.scanner.impl;

import java.io.Reader;
import java.net.URL;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dy.AutoTest.scanner.bean.ClassScanDto;
import com.dy.AutoTest.scanner.bean.ProjectScan;
import com.dy.AutoTest.scanner.util.ScannerUtil;

public class ScannerImpl {

	private final static long ID_TESTPROJECT = 1L;
	private final static String GIT_URL = "https://github.com/DyAutoTest/WebAutoTest.git";
	private final static String JOB_NAME = "WEB_TEST";
	private final static String NODE_NAME = "WIN_WEB_AUTO";

	private final static String PACKAGE_NAME = "com.dy.AutoTest.OnlineCashier.TestCases";

	public static void main(String[] args) throws Exception {

		URL path = new ScannerImpl().getClass().getClassLoader().getResource("");

		String packagePath = PACKAGE_NAME.replaceAll("\\.", "/");

		// Get DTO from Service
		List<ClassScanDto> scanList = new ScannerUtil().getTests(path + "/" + packagePath, PACKAGE_NAME);
		System.out.println(scanList.size());

		// Project Scan Data to DB
		ProjectScan pScan = new ProjectScan();
		pScan.setIdTestproject(ID_TESTPROJECT);
		pScan.setDyGiturl(GIT_URL);
		pScan.setJobName(JOB_NAME);
		pScan.setNodeName(NODE_NAME);

		SqlSession session = null;
		try {
			String resource = "config/mybatis.xml";
	        Reader reader = Resources.getResourceAsReader(resource);
	        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	        SqlSessionFactory factory = builder.build(reader);
	        session = factory.openSession();
			
			session.insert("ProjectScan.addProjectScan", pScan);
			session.commit();
			
			System.out.println(pScan.getIdDyProject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		// To Do: Class Data to DB

		// To Do: Method Data to DB

	}

}
