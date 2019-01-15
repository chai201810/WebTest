package com.dy.AutoTest.scanner.dao;

import java.util.List;

import com.dy.AutoTest.scanner.bean.ClassScan;

public class ClassScanDao extends BaseAbstractDao {

	private final static String INSERT = "ClassScan.addClassScan";
	private final static String SELECT = "ClassScan.getClassId";

	public Long insert(ClassScan cScan) {
		super.insert(INSERT, cScan);
		return cScan.getIdSvnClass();
	}

	@SuppressWarnings("unchecked")
	public Long getClassId(ClassScan cScan) {
		List<Long> resultList = (List<Long>) super.select(SELECT, cScan);
		return resultList.get(0);
	}
}
