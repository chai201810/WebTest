package com.dy.AutoTest.scanner.impl;

import java.net.URL;
import java.util.List;

import com.dy.AutoTest.scanner.bean.ScanDto;
import com.dy.AutoTest.scanner.util.ScannerUtil;

public class ScannerImpl {

	private final static String PACKAGE_NAME = "com.dy.AutoTest";
	
	public static void main(String[] args) throws Exception {
		
		URL path = new ScannerImpl().getClass().getClassLoader().getResource("");

		String packagePath = PACKAGE_NAME.replaceAll("\\.", "/");

		// Get DTO from Service
		List<ScanDto> scanList = new ScannerUtil().getTests(path + "/" + packagePath, PACKAGE_NAME);
		System.out.println(scanList.size());
		
		// To Do: Connect DB and configure data
		
		// To Do: Insert into table values
		
	}

}
