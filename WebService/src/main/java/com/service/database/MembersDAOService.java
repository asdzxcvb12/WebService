package com.service.database;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersDAOService implements MembersDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Members> getMembersAttr() {
		// TODO Auto-generated method stub
		ArrayList<Members> result = new ArrayList<Members>();
		MembersMapper membersMapper = sqlSession.getMapper(MembersMapper.class);
		result = membersMapper.getMembersAttr();
		return result;
	}

	@Override
	public ArrayList<Members> getMembersEmail() {
		// TODO Auto-generated method stub
		ArrayList<Members> result = new ArrayList<Members>();
		MembersMapper membersMapper = sqlSession.getMapper(MembersMapper.class);
		result = membersMapper.getMembersEmail();
		return result;
	}

	@Override
	public ArrayList<Members> getMembersId() {
		// TODO Auto-generated method stub
		ArrayList<Members> result = new ArrayList<Members>();
		MembersMapper membersMapper = sqlSession.getMapper(MembersMapper.class);
		result = membersMapper.getMembersId();
		return result;
	}

	@Override
	public ArrayList<Members> getMembersNickName() {
		// TODO Auto-generated method stub
		ArrayList<Members> result = new ArrayList<Members>();
		MembersMapper membersMapper = sqlSession.getMapper(MembersMapper.class);
		result = membersMapper.getMembersNickName();
		return result;
	}

	@Override
	public void insertMembers(Members members) {
		// TODO Auto-generated method stub
		MembersMapper membersMapper = sqlSession.getMapper(MembersMapper.class);
		membersMapper.insertMembers(members);
	}

	@Override
	public ArrayList<Members> getMembersLog() {
		// TODO Auto-generated method stub
		
		ArrayList<Members> result = new ArrayList<Members>();
		MembersMapper membersMapper = sqlSession.getMapper(MembersMapper.class);
		result = membersMapper.getMembersLog();
		return result;
	}

	
	/* LOG INSERT */
	@Override
	public void insertLog(MembersLog membersLog) {
		// TODO Auto-generated method stub
		MembersMapper membersMapper = sqlSession.getMapper(MembersMapper.class);
		membersMapper.insertMembersLog(membersLog);
	}

}
