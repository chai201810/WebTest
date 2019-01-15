package com.dy.AutoTest.scanner.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseAbstractDao {

	protected SqlSession session = null;

	private void connectDB() throws IOException {
		String resource = "config/mybatis.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);
		session = factory.openSession();
	}

	private void commitDB() {
		if (session != null) {
			session.commit();
		}
	}

	private void closeDB() {
		if (session != null) {
			session.close();
		}
	}
	
	protected void insert(String statement, Object obj) {
		try {
			connectDB();
			insertSQL(statement, obj);
			commitDB();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	protected Object select(String statement, Object obj) {
		Object result = null;
		try {
			connectDB();
			result = selectSQL(statement, obj);
			commitDB();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	}
	
	private void insertSQL(String statement, Object obj) {
		session.insert(statement, obj);
	}

	private Object selectSQL(String statement, Object obj) {
		return session.selectList(statement, obj);
	}
	
}
