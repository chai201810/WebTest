package com.dy.AutoTest.scanner.impl;

import java.net.URL;

import com.dy.AutoTest.scanner.util.ScannerUtil;

public class ScannerImpl {

	public static void main(String[] args) throws Exception {
		
		URL path = new ScannerImpl().getClass().getClassLoader().getResource("");
		System.out.println(path);

		String packageName = "com.dy.AutoTest";
		String packagePath = packageName.replaceAll("\\.", "/");

		System.out.println(packagePath);

		new ScannerUtil().getTests(path + "/" + packagePath, packageName);
		
		// To Do: Get DTO from Service
		
		// To Do: Connect DB and configure data
		
		// To Do: Insert into table values
		
	}

}
