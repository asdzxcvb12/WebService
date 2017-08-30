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
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getBasicBoardPage(boardPage);
		return result;
	}

	@Override
	public ArrayList<BasicBoard> getBasicBoardSearchCount(BoardPage boardPage) {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getBasicBoardSearchCount(boardPage);
		return result;
	}

	@Override
	public ArrayList<BasicBoard> getBasicBoardSearch(BoardPage boardPage) {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getBasicBoardSearch(boardPage);
		return result;
	}

	@Override
	public void insertBasicBoard(BoardPage boardPage) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.insertBasicBoard(boardPage);
	}

	@Override
	public ArrayList<Comment> getComment(CommentSender commentSender) {
		// TODO Auto-generated method stub
		ArrayList<Comment> result = new ArrayList<Comment>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getComment(commentSender);
		
		return result;
	}

	@Override
	public ArrayList<BasicBoard> getBasicBoardContent(BoardPage boardPage) {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getBasicBoardContent(boardPage);
		
		return result;
	}

}
