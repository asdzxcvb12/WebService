package com.service.database;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOService implements BoardDAO {
	
	@Autowired SqlSession sqlSession;

	@Override
	public ArrayList<BasicBoard> getBasicBoardList(String boardName) {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getBasicBoardList(boardName);
		return result;
	}

}
