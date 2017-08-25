package com.service.database;

import java.util.ArrayList;

public interface BoardMapper {
	public ArrayList<BasicBoard> getBasicBoardList(String boardName);
}
