package com.service.database;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardDAO {
	public HashMap<String, String> getBasicBoardList(String boardName);
	public ArrayList<BasicBoard> getBasicBoardPage(BoardPage boardPage);
	public ArrayList<BasicBoard> getBasicBoardSearchCount(BoardPage boardPage);
	public ArrayList<BasicBoard> getBasicBoardSearch(BoardPage boardPage);
	public void insertBasicBoard(BoardPage boardPage);
	public ArrayList<BasicBoard> getBasicBoardContent(BoardPage boardPage);
	public ArrayList<Comment> getComment(CommentSender commentSender);
	public void contentLookUp(BoardPage boardPage);
	public void insertComment(CommentSender commentSender);
	public void deleteComment(CommentSender commentSender);
	public String getRecommendedAttr(RecommendedSender recommendedSender);
	public void insertRecommended(RecommendedSender recommendedSender);
	public void plusRecommended(RecommendedSender recommendedSender);
	public void minusRecommended(RecommendedSender recommendedSender);
	public void deleteBoardContent(BoardPage boardPage);
	public ArrayList<BasicBoard> getLookupRank();
	public ArrayList<BasicBoard> getRecommendedRank();
	public ArrayList<BasicBoard> getWriterRank();
	public ArrayList<BasicBoard> getCreateDateRank();
	public ArrayList<Img> getImg();
	public void insertImg(ImgSender imgSender);
}
