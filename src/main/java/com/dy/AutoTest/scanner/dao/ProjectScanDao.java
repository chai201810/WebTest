package com.dy.AutoTest.scanner.dao;

import java.util.List;

import com.dy.AutoTest.scanner.bean.ProjectScan;

public class ProjectScanDao extends BaseAbstractDao {

	private final static String INSERT = "ProjectScan.addProjectScan";
	private final static String SELECT = "ProjectScan.getProjectId";

	public Long insert(ProjectScan pScan) {
		super.insert(INSERT, pScan);
		return pScan.getIdTaProject();
	}

	@SuppressWarnings("unchecked")
	public Long getProjectId(ProjectScan pScan) {
		List<Long> resultList = (List<Long>) super.select(SELECT, pScan);
		return resultList.get(0);
	}

}
