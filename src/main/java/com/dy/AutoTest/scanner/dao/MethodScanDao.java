package com.dy.AutoTest.scanner.dao;

import com.dy.AutoTest.scanner.bean.MethodScan;

public class MethodScanDao extends BaseAbstractDao {

	private final static String INSERT = "MethodScan.addMethodScan";

	public Long insert(MethodScan mScan) {
		super.insert(INSERT, mScan);
		return mScan.getIdSvnMethod();
	}

}
