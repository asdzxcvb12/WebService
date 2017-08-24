package com.service.database;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TabsDAOService implements TabsDAO{
	
	@Autowired 
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Tabs> getTabs() {
		// TODO Auto-generated method stub
		ArrayList<Tabs> result = new ArrayList<Tabs>();
		TabsMapper tabsMapper = sqlSession.getMapper(TabsMapper.class);
		result = tabsMapper.getTabs();
		return result;
	}

}
