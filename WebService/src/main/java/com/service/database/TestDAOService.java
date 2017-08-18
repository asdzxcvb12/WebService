package com.service.database;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOService implements TestDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Test> getTestVal() {
	
		ArrayList<Test> result = new ArrayList<Test>();
		TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
		result = testMapper.getTestVal();
		
		return result;
		
	}
}
