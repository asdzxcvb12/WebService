package com.service.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.model.SendEmail;
import com.service.model.ConfirmEmailCode;
import com.service.model.En_De_criptionModulues;
import com.service.model.IPaddress;
import com.service.database.BasicBoard;
import com.service.database.BoardDAOService;
import com.service.database.BoardPage;
import com.service.database.Comment;
import com.service.database.CommentSender;
import com.service.database.Members;
import com.service.database.MembersDAOService;
import com.service.database.MembersLog;

@Controller 	
public class BasicController {
	
	@Autowired private MembersDAOService membersDAOService;
	@Autowired private BoardDAOService boardDAOService;
	
	private En_De_criptionModulues en_de_criptionModulues;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String main(Model model, HttpServletRequest request) {
		model.addAttribute("pageSplit", true);
		
		String returnPage = null;

		String cate = (String) request.getAttribute("cate");
		String boardName = (String) request.getAttribute("boardName");
		
		//board--
		//if search-----
			String searchOption = (String) request.getParameter("searchOption");
			String search = (String) request.getParameter("search");
			
		if(searchOption == null || searchOption.equals("")) searchOption = "null";
		if(search == null || search.equals("")) search = "null";
		
		if(cate.equals("LANGUAGE")) {
			returnPage = "index";
		} else if(cate.equals("GALLARY")) {
			returnPage = "index";
		} else if(cate.equals("BOARD")) {
			basicBoard(request, model, boardName, searchOption, search);
			
			returnPage = "include/content_right/basic_board";
		} else if(cate.equals("NOTICE")) {
			returnPage = "index";
		} else {
			returnPage = "index";
		}
		return returnPage;
	}
	
	@RequestMapping(value="index/membership/signInUp", method=RequestMethod.GET)
	public String signInUp(HttpServletRequest request, Model model) {
		model.addAttribute("pageSplit", true);
		
		en_de_criptionModulues = new En_De_criptionModulues("signInUp");
		en_de_criptionModulues.initRSAkey(request);
		
		return "include/membership/signInUp";
	}

	@RequestMapping(value="index/signIn/result", method=RequestMethod.POST)
	public String signInRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		HttpSession session = request.getSession();
		
		String logId = (String) request.getParameter("logEncriptId");
		String logPassword = (String) request.getParameter("logEncriptPw");
		String getId = null;
		String getNick = null;
		if(logId != null && logPassword != null) {
			en_de_criptionModulues = new En_De_criptionModulues("signInUp");
			boolean flag = false;
			System.out.println("logId : "+logId+"logPassword : "+logPassword);
			String ID_PW[] = en_de_criptionModulues.decrypt(request, logId, logPassword);
			logId = ID_PW[0];
			logPassword = ID_PW[1];
			List<Members> members = membersDAOService.getMembersLog();
			for(Members searchIdPw : members){
				if(searchIdPw.getId().equals(logId) && searchIdPw.getPw().equals(logPassword)) {
					getId = searchIdPw.getId();
					getNick = searchIdPw.getNick();
					flag = true;
					break;
				}
			}
			
			System.out.println(logId+","+logPassword);
			if(flag) {
				System.out.println("yesyes");
				IPaddress ipAddress = new IPaddress(request);
				System.out.println("log id : " + logId);
				MembersLog membersLog = new MembersLog();
				membersLog.setId(logId);
				membersLog.setLog_address(ipAddress.getAddress());
				membersDAOService.insertLog(membersLog);
				session.setAttribute("signId", getId);
				session.setAttribute("signNick", getNick);
				model.addAttribute("resultParam", "logYes");
			} else {
				System.out.println("npnp");
				model.addAttribute("resultParam", "logNo");
			}
		}
		
		return "result";
	}
	
	@RequestMapping(value="index/signOut/result", method=RequestMethod.POST)
	public String signOutResult(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("signId");
		session.removeAttribute("signNick");
		
		return "result";
	}
	
	@RequestMapping(value="index/membership/term", method=RequestMethod.GET)
	public String membershipTerm() {
		
		return "include/membership/term";
	}
	
	@RequestMapping(value="index/membership/info", method=RequestMethod.POST)
	public String membershipInfo(HttpServletRequest request, Model model) {
		
		String info = (String) request.getParameter("infoEmail");
		if(info != null) {
			en_de_criptionModulues = new En_De_criptionModulues("resist");
			en_de_criptionModulues.initRSAkey(request);
			model.addAttribute("membership", info);
		}
		
		return "include/membership/info";
	}
	
	@RequestMapping(value="index/membership/info/result", method=RequestMethod.POST)
	public String membershipResult(HttpServletRequest request, Model model) throws Exception {
		String id = (String) request.getParameter("membership_ID");
		String pw = (String) request.getParameter("membership_PW");
		String nick = (String) request.getParameter("membership_NICK");
		String email = (String) request.getParameter("membership_EMAIL");
		String postcode = (String) request.getParameter("membership_POSTCODE");
		String roadAddress = (String) request.getParameter("membership_ROADADDRESS");
		String jibunAddress = (String) request.getParameter("membership_JIBUNADDRESS");
		String detailAddress = (String) request.getParameter("membership_DETAILADDRESS");
		String languageList = (String) request.getParameter("languageList");
		
		
		if(id != null && pw != null) {
			en_de_criptionModulues = new En_De_criptionModulues("resist");
			String[] ID_PW = en_de_criptionModulues.decrypt(request, id, pw);
			id = ID_PW[0];
			pw = ID_PW[1];
			
			Members members = new Members();
			members.setId(id);
			members.setPw(pw);
			members.setNick(nick);
			members.setMail(email);
			members.setPreference(languageList.substring(0, languageList.length()-2));
			members.setAddress(postcode+","+roadAddress+","+jibunAddress+","+detailAddress);
			System.out.println(id+"\n"+pw+"\n"+nick+"\n"+postcode+"\n"+languageList);
			membersDAOService.insertMembers(members);
			model.addAttribute("resultParam", "membershipOk");
			System.out.println("success!!");
		}
		
		return "result";
	}
	
	@RequestMapping(value="index/board/content", method=RequestMethod.GET)
	public String boardContent(HttpServletRequest request, Model model) {
		model.addAttribute("pageSplit", true);
		
		String getContentCate = (String) request.getAttribute("cate");
		String getContentSubCate = (String) request.getAttribute("subCate");
		String boardName = (String) request.getAttribute("boardName");
		
		String idx = (String) request.getParameter("idx");
		if(idx != null && getContentCate != null && getContentSubCate != null) {
			
			BoardPage boardPage = new BoardPage();
			CommentSender commentSender = new CommentSender();
			
			boardPage.setBoardName(boardName);
			boardPage.setStart(Integer.parseInt(idx)-1);
			boardPage.setEnd(Integer.parseInt(idx)+1);
			
			commentSender.setIdx(idx);
			commentSender.setBoard_name(boardName);
			
			List<BasicBoard> contentBoard = new ArrayList<BasicBoard>();
			List<BasicBoard> basicBoard = boardDAOService.getBasicBoardContent(boardPage);
			System.out.println("getBasicBoardContent : "+ basicBoard.size());
			if(basicBoard.size() == 2) {
				if(idx.equals("1")) {
					contentBoard.add(null);
					contentBoard.add(basicBoard.get(0));
					contentBoard.add(basicBoard.get(1));
				} else {
					contentBoard.add(basicBoard.get(0));
					contentBoard.add(basicBoard.get(1));
					contentBoard.add(null);
				}
			} else {
				contentBoard = basicBoard;
			}
			
			List<Comment> comment = boardDAOService.getComment(commentSender);
			System.out.println("getComment : "+ comment.size());
			model.addAttribute("contentBoard", contentBoard);
			model.addAttribute("comment", comment);
		}
		
		return "include/content_right/board_content";
	}
	
	@RequestMapping(value="index/board/write", method=RequestMethod.POST)
	public String boardWrite(HttpServletRequest request, Model model) {
		model.addAttribute("pageSplit", true);
		
		return "include/content_right/board_write";
	}
	@RequestMapping(value="index/board/write/result", method=RequestMethod.POST)
	public String boardWriteResult(HttpServletRequest request, Model model) {
		String titleTextBox = (String) request.getParameter("titleTextBox"); // title
		String resultContent = (String) request.getParameter("resultContent"); // content
		String getBoardCate = (String) request.getParameter("cate");
		String getBoardSubCate = (String) request.getParameter("subCate");
		String boardName = (String) request.getParameter("boardName");
		System.out.println(titleTextBox+"\n"+resultContent+"\n"+getBoardCate+"\n"+getBoardSubCate+"\n"+boardName);
		if(titleTextBox != null && getBoardSubCate != null && resultContent != null && getBoardCate != null){
			if(getBoardCate.equals("BOARD")) {
				HttpSession session = request.getSession();
				BoardPage basicBoard = new BoardPage();
				basicBoard.setBoardName(boardName);
				basicBoard.setTitle(titleTextBox);
				basicBoard.setWriter(String.valueOf(session.getAttribute("signNick"))); // fix
				basicBoard.setContent(resultContent);
				boardDAOService.insertBasicBoard(basicBoard);
			}
		} 
		model.addAttribute("resultParam", "writeResult");
		return "result";
	}
	//show basic board
	public void basicBoard(HttpServletRequest request, Model model, String boardName, String searchOption, String search) {
		BoardPage boardPage = new BoardPage();
		List<BasicBoard> basicSearch = null;
		boardPage.setBoardName(boardName);
		int cnt = 0;
		if(searchOption.equals("null") && search.equals("null")) {
			HashMap<String, String> basic = boardDAOService.getBasicBoardList(boardName);
			cnt = Integer.parseInt(String.valueOf(basic.get("cnt")));
		}else {
			boardPage.setSearchOption(searchOption);
			boardPage.setSearch(search);
			basicSearch = boardDAOService.getBasicBoardSearchCount(boardPage);
			model.addAttribute("searchOption", searchOption);
			model.addAttribute("search", search);
		}
		
		List<BasicBoard> pageBasic = null;
		String pageNum = (String) request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		int pageNumInt = Integer.parseInt(pageNum);
		
		int endCnt = 0;
		
		if(pageNumInt == 1) {
			if(searchOption.equals("null") && search.equals("null")) {
				if(cnt % 10 == 0) endCnt = cnt / 10;
				else endCnt = cnt / 10 + 1;
				if(endCnt == 1) boardPage.setStart(1);
				else boardPage.setStart(cnt-9);
				boardPage.setEnd(cnt);
				pageBasic = boardDAOService.getBasicBoardPage(boardPage);
			} else {
				if(basicSearch.size() != 0) {
					if(basicSearch.size() % 10 == 0) endCnt = basicSearch.size() / 10;
					else endCnt = basicSearch.size() / 10 + 1;
					if(endCnt == 1) boardPage.setStart(1);
					else boardPage.setStart(Integer.parseInt(basicSearch.get(9).getIdx()));
					boardPage.setEnd(Integer.parseInt(basicSearch.get(0).getIdx()));
					pageBasic = boardDAOService.getBasicBoardSearch(boardPage);
				}
			}
			
			model.addAttribute("board", pageBasic);
		} else {
			
			if(searchOption.equals("null") && search.equals("null")) {
				if(cnt % 10 == 0) endCnt = cnt / 10;
				else endCnt = cnt / 10 + 1;
				boardPage.setEnd(cnt - ((pageNumInt-1)*10));
				if(cnt - ((pageNumInt-1)*10) - 9 < 1) boardPage.setStart(1);
				else boardPage.setStart(cnt - ((pageNumInt-1)*10) - 9);
				pageBasic = boardDAOService.getBasicBoardPage(boardPage);
			} else {
				if(basicSearch.size() != 0) {
					if(basicSearch.size() % 10 == 0) endCnt = basicSearch.size() / 10;
					else endCnt = basicSearch.size() / 10 + 1;
					boardPage.setEnd(Integer.parseInt(basicSearch.get((pageNumInt-1)*10).getIdx()));
					if((pageNumInt-1)*10 + 9 >= (basicSearch.size()-1)) boardPage.setStart(Integer.parseInt(basicSearch.get(basicSearch.size()-1).getIdx()));
					else boardPage.setStart(Integer.parseInt(basicSearch.get((pageNumInt-1)*10 + 9).getIdx()));
					pageBasic = boardDAOService.getBasicBoardSearch(boardPage);
				}
			}
			
			model.addAttribute("board", pageBasic);
		}
		model.addAttribute("pageNumInt", pageNumInt);
		model.addAttribute("entirePage", endCnt);
	}
	
	//send email
	@RequestMapping(value="/SendMail", method= RequestMethod.POST)
	public void SendMail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = true;
	
		String email = (String) request.getParameter("email");
		List<Members> membersEmail = membersDAOService.getMembersEmail();
				
		for(Members checkEmail : membersEmail) {
			if(checkEmail.getMail().equals(email)) {
				flag = false;
				break;
			}
		}
		
		String result = "null";
		String setValues = null;
		String code = "null";
		
		if(flag) {
			ConfirmEmailCode confirmEmailCode = new ConfirmEmailCode();
			SendEmail sendEmail = new SendEmail();
			
			code = confirmEmailCode.getEmailCode();
			result = sendEmail.send(email, code);
		}
		
		if(result.equals("fail")) code = "null";
		
		System.out.println("code : " + code);
		setValues = "{\"email\":\""+email+"\",\"code\":\""+code+"\",\"result\":\""+result+"\"}";
		
		response.getWriter().print(setValues);
	}
	
	//id check
	@RequestMapping(value="/checkId", method = RequestMethod.POST)
	public void checkId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String getId = (String) request.getParameter("id");
		String getData = null;
		Boolean flag = true;
		
		List<Members> MembersId = membersDAOService.getMembersId();
		for(Members checkId : MembersId) {
			if(checkId.getId().equals(getId)) {
				flag = false;
				getData = "{\"id\":\"false\"}";
				break;
			}
		}
		
		if(flag) {
			getData = "{\"id\":\"true\"}";
		}
		
		response.getWriter().print(getData);
	}
	// nickname check
	@RequestMapping(value="/checkNickName", method = RequestMethod.POST)
	public void checkNickName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String getNickName = (String) request.getParameter("nickname");
		String getData = null;
		Boolean flag = true;
		
		List<Members> MembersNickName = membersDAOService.getMembersNickName();
		for(Members checkNickName : MembersNickName) {
			if(checkNickName.getNick().equals(getNickName)) {
				flag = false;
				getData = "{\"nickname\":\"false\"}";
				break;
			}
		}
		
		if(flag) getData = "{\"nickname\":\"true\"}";
		
		response.getWriter().print(getData);
	}
}


