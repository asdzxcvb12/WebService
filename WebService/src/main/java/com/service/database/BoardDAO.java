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
}
