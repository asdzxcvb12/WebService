package com.service.database;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardDAO {
	public HashMap<String, String> getBasicBoardList(String boardName);
	public ArrayList<BasicBoard> getBasicBoardPage(BoardPage boardPage);
}
