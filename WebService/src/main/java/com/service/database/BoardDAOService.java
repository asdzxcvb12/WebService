package com.service.database;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOService implements BoardDAO {
	
	@Autowired SqlSession sqlSession;

	@Override
	public HashMap<String, String> getBasicBoardList(String boardName) {
		// TODO Auto-generated method stub
		HashMap<String, String> result = new HashMap<String, String>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getBasicBoardCount(boardName);
		return result;
	}

	@Override
	public ArrayList<BasicBoard> getBasicBoardPage(BoardPage boardPage) {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> boardResult = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardResult = boardMapper.getBasicBoardPage(boardPage);
		return boardResult;
	}

}
