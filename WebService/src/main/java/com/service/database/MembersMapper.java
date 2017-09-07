package com.service.database;

import java.util.ArrayList;

public interface MembersMapper {
	ArrayList<Members> getMembersAttr();
	ArrayList<Members> getMembersEmail();
	ArrayList<Members> getMembersId();
	ArrayList<Members> getMembersNickName();
	ArrayList<Members> getMembersLog();
	void insertMembers(Members members);
	void insertMembersLog(MembersLog membersLog);
	public String getMembersAuthority(String id);
}
