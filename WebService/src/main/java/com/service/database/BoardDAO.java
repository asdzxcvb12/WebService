package com.service.database;

import java.util.ArrayList;

public interface BoardDAO {
	public ArrayList<BasicBoard> getBasicBoardList(String boardName);
}
