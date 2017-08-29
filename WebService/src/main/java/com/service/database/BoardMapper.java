package com.service.database;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardMapper {
	public HashMap<String, String> getBasicBoardCount(String boardName);
	public ArrayList<BasicBoard> getBasicBoardPage(BoardPage boardPage);
	public ArrayList<BasicBoard> getBasicBoardSearchCount(BoardPage boardPage);
	public ArrayList<BasicBoard> getBasicBoardSearch(BoardPage boardPage);
}
