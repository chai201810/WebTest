package com.dy.AutoTest.scanner.impl;

import java.net.URL;
import java.util.List;

import com.dy.AutoTest.scanner.bean.ClassScan;
import com.dy.AutoTest.scanner.bean.ClassScanDto;
import com.dy.AutoTest.scanner.bean.MethodScan;
import com.dy.AutoTest.scanner.bean.MethodScanDto;
import com.dy.AutoTest.scanner.bean.ProjectScan;
import com.dy.AutoTest.scanner.dao.ClassScanDao;
import com.dy.AutoTest.scanner.dao.MethodScanDao;
import com.dy.AutoTest.scanner.dao.ProjectScanDao;
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
		System.out.println("CNO: " + scanList.size());

		// Project Scan Data to DB
		ProjectScan pScan = new ProjectScan();
		pScan.setIdTestproject(ID_TESTPROJECT);
		pScan.setDyGiturl(GIT_URL);
		pScan.setJobName(JOB_NAME);
		pScan.setNodeName(NODE_NAME);

		ProjectScanDao pScanDao = new ProjectScanDao();
		long projectId = pScanDao.insert(pScan);
		System.out.println("PID: " + projectId);

		// Class Data And Method Data to DB
		ClassScanDao cScanDao = new ClassScanDao();
		MethodScanDao mScanDao = new MethodScanDao();

		for (ClassScanDto cDto : scanList) {
			ClassScan cScan = new ClassScan();
			cScan.setIdDyProject(projectId);
			cScan.setPackageName(cDto.getPackageName());
			cScan.setClassName(cDto.getClassName());
			cScan.setFilePath(cDto.getFilePath());
			cScan.setMemo("");

			long classId = cScanDao.insert(cScan);
			System.out.println("CID: " + classId);

			for (MethodScanDto mDto : cDto.getMethodList()) {
				MethodScan mScan = new MethodScan();
				mScan.setIdDyClass(classId);
				mScan.setMethodName(mDto.getMethodName());
				mScan.setMemo(mDto.getMemo());
				mScan.setDependsOnMethods(mDto.getDepends());
				mScan.setOwner("");

				long methodId = mScanDao.insert(mScan);
				System.out.println("MID: " + methodId);
			}

		}

	}

}
