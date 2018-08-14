package com.javatpoint.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatpoint.beans.Emp;

@Repository
public class EmployeeDao {

	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession session) {
		this.sqlSession = session;
	}
	
	
	public List<Emp> getAllEmployees() {
		List<Emp> result = sqlSession.selectList("data-mapper.selectAllEmp");
		return result;
	}

}
