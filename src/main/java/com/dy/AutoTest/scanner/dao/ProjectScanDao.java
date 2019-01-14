package com.dy.AutoTest.scanner.dao;

import com.dy.AutoTest.scanner.bean.ProjectScan;

public class ProjectScanDao extends BaseAbstractDao {

	private final static String INSERT = "ProjectScan.addProjectScan";

	public long insert(ProjectScan pScan) {
		super.insert(INSERT, pScan);
		return pScan.getIdTaProject();
	}

}
