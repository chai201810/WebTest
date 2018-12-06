package com.dy.AutoTest.scanner.dao;

import com.dy.AutoTest.scanner.bean.ClassScan;

public class ClassScanDao extends BaseAbstractDao {

	private final static String INSERT = "ClassScan.addClassScan";

	public long insert(ClassScan cScan) {
		super.insert(INSERT, cScan);
		return cScan.getIdDyClass();
	}

}
