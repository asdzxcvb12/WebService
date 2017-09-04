package com.service.model;

public class BoardManage {
	
	public String boardManage(String cate, String board) {
		
		String[] basicBoard = {"PublicBoard","PrivateBoard","LanguageQnA"};
		String[] linearBoard = {"java", "kotlin", "http/css", "javascript", "jquery", "jstl", "jsp", "php"
				, "asp", "git", "svn", "R", "python", "MachineRunning"};
		String[] grideBoard = {"Picture", "Video"};
		
		String name = null;

		if(cate.equals("BOARD")){
			for(String b : basicBoard) {
				if(board.equals(b)) {
					if(board.equals("PublicBoard")) name = "board_public";
					else if(board.equals("PrivateBoard")) name = "board_private";
					else if(board.equals("LanguageQnA")) name = "board_qa";
					break;
				} else if(board.equals("null")) {
					name = "board_public";
					break;
				}
			}
		} else if(cate.equals("LANGUAGE")) {
			for(String b : linearBoard) {
				if(board.equals(b)) {
					if(board.equals("java")) name = "board_java";
					else if(board.equals("kotlin")) name = "board_kotlin";
					else if(board.equals("http/css")) name = "board_http_css";
					else if(board.equals("javascript")) name = "board_javascript";
					else if(board.equals("jquery")) name = "board_jquery";
					else if(board.equals("jstl")) name = "board_jstl";
					else if(board.equals("jsp")) name = "board_jsp";
					else if(board.equals("php")) name = "board_php";
					else if(board.equals("asp")) name = "board_asp";
					else if(board.equals("git")) name = "board_git";
					else if(board.equals("svn")) name = "board_svn";
					else if(board.equals("R")) name = "board_r";
					else if(board.equals("python")) name = "board_python";
					else if(board.equals("MachineRunning")) name = "board_mr";
					else if(board.equals("null")) name = "board_java";
					break;
				} else if(board.equals("null")) {
					name = "board_java";
					break;
				}
			}
		} else if(cate.equals("GALLARY")) {
			for(String b : grideBoard) {
				if(board.equals(b)) {
					if(board.equals("Picture")) name = "board_picture";
					else if(board.equals("Video")) name = "board_video";
					else if(board.equals("null")) name = "board_picture";
					break;
				} else if(board.equals("null")) {
					name = "board_picture";
					break;
				}
			}
		} else {
			name = "null";
		}
		
		return name;
	}
	
}
