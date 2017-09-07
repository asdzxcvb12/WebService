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

	@Override
	public void contentLookUp(BoardPage boardPage) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.contentLookUp(boardPage);
	}

	@Override
	public void insertComment(CommentSender commentSender) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.insertComment(commentSender);
	}

	@Override
	public void deleteComment(CommentSender commentSender) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.deleteComment(commentSender);
	}

	@Override
	public String getRecommendedAttr(RecommendedSender recommendedSender) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		String result = boardMapper.getRecommendedAttr(recommendedSender);
		return result;
	}

	@Override
	public void insertRecommended(RecommendedSender recommendedSender) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.insertRecommended(recommendedSender);
	}

	@Override
	public void plusRecommended(RecommendedSender recommendedSender) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.plusRecommended(recommendedSender);
	}

	@Override
	public void minusRecommended(RecommendedSender recommendedSender) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.minusRecommended(recommendedSender);
	}

	@Override
	public void deleteBoardContent(BoardPage boardPage) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.deleteBoardContent(boardPage);
	}

	@Override
	public ArrayList<BasicBoard> getLookupRank() {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getLookupRank();
		return result;
	}

	@Override
	public ArrayList<BasicBoard> getRecommendedRank() {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getRecommendedRank();
		return result;
	}

	@Override
	public ArrayList<BasicBoard> getWriterRank() {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getWriterRank();
		return result;
	}

	@Override
	public ArrayList<BasicBoard> getCreateDateRank() {
		// TODO Auto-generated method stub
		ArrayList<BasicBoard> result = new ArrayList<BasicBoard>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getCreateDateRank();
		return result;
	}

	@Override
	public ArrayList<Img> getImg() {
		// TODO Auto-generated method stub
		ArrayList<Img> result = new ArrayList<Img>();
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result = boardMapper.getImg();
		return result;
	}

	@Override
	public void insertImg(ImgSender imgSender) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.insertImg(imgSender);
	}

}
