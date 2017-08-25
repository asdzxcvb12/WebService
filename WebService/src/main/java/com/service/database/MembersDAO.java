package com.service.database;

import java.util.ArrayList;

public interface MembersDAO {
	public ArrayList<Members> getMembersAttr();
	public ArrayList<Members> getMembersEmail();
	public ArrayList<Members> getMembersId();
	public ArrayList<Members> getMembersNickName();
	public ArrayList<Members> getMembersLog();
	public void insertMembers(Members members);
	public void insertLog(MembersLog membersLog);
}
