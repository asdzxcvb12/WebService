package com.service.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.model.BoardManage;
import com.service.model.ConfirmEmailCode;
import com.service.model.DistributeTabs;
import com.service.model.SendEmail;
import com.service.model.En_De_criptionModulues;
import com.service.database.BasicBoard;
import com.service.database.BoardDAOService;
import com.service.database.BoardPage;
import com.service.database.Members;
import com.service.database.MembersDAOService;
import com.service.database.MembersLog;
import com.service.database.Tabs;
import com.service.database.TabsDAOService;
import com.service.model.IPaddress;

@Controller 	
public class BasicController {
	
	@Autowired private MembersDAOService membersDAOService;
	@Autowired private TabsDAOService tabsDAOService;
	@Autowired private BoardDAOService boardDAOService;
	
	private En_De_criptionModulues en_de_criptionModulues;
	private DistributeTabs distributeTabs;
	private BoardManage boardManage;
	
	@RequestMapping(value="/")
	public String main_page(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession httpSession = request.getSession();
		
		// tabs
		String cate = (String) request.getParameter("cate");
		if(cate == null || cate.equals("")) cate = "null";
		model.addAttribute("cate", cate);
		 
		String subCate = (String) request.getParameter("subCate");
		if(subCate == null || subCate.equals("")) {
			if(cate.equals("HOME")) subCate = "Home";
			else if(cate.equals("LANGUAGE")) subCate = "java";
			else if(cate.equals("GALLARY")) subCate = "Picture";
			else if(cate.equals("BOARD")) subCate = "PublicBoard";
			else if(cate.equals("NOTICE")) subCate = "MyPage";
			else subCate = "null";
		}
		model.addAttribute("subCate", subCate);
		//board
		boardManage = new BoardManage();
		Map<String, String> board = boardManage.boardManage(cate, subCate);
		System.out.println("cate : " + cate);
		System.out.println("subCate : " + subCate);
		String kind = String.valueOf(board.get("kind"));
		String boardName = String.valueOf(board.get("name"));

		//basic
		if(kind.equals("basic")) {
			String searchOption = (String) request.getParameter("searchOption");
			String search = (String) request.getParameter("search");
			if(searchOption == null || searchOption.equals("")) searchOption = "null";
			if(search == null || search.equals("")) search = "null";
			basicBoard(request, model, boardName, searchOption, search);
		}
			//linear
			//gride
			
		//top, side, sub menuList
		List<Tabs> tabs = tabsDAOService.getTabs();
			
		distributeTabs = new DistributeTabs();
		List<String> top = distributeTabs.topMenu(tabs);
		List<Map<String, String>> side = distributeTabs.sideMenu(tabs);
		List<Map<String, Object>> sub = distributeTabs.subMenu(tabs, top);
		
		model.addAttribute("zeroTop", top.get(0));
		model.addAttribute("top", top);
		model.addAttribute("side", side);
		model.addAttribute("sub", sub);
		
		//SignUP
		String logId = (String) request.getParameter("logEncriptId");
		String logPassword = (String) request.getParameter("logEncriptPw");
		String getNick = null;
		if(logId != null && logPassword != null) {
			en_de_criptionModulues = new En_De_criptionModulues("log");
			boolean flag = false;
			System.out.println("logId : "+logId+"logPassword : "+logPassword);
			String ID_PW[] = en_de_criptionModulues.decrypt(request, logId, logPassword);
			logId = ID_PW[0];
			logPassword = ID_PW[1];
			List<Members> members = membersDAOService.getMembersLog();
			for(Members searchIdPw : members){
				if(searchIdPw.getId().equals(logId) && searchIdPw.getPw().equals(logPassword)) {
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
				httpSession.setAttribute("signIn", getNick);
				response.getWriter().print("<script>alert('Welcome!! "+logId+"');</script>");
			} else {
				System.out.println("npnp");
				response.getWriter().print("<script>alert('Don`t come!! "+logId+"');</script>");
			}
		}
		
		//membershipResult
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
			
			membersDAOService.insertMembers(members);
			System.out.println("success!!");
		}
		
		//term
		String membership = (String) request.getParameter("membership");
		if(membership != null) membership = "term";  
		else membership = "null";
		
		//info RSA
		String info = (String) request.getParameter("infoEmail");
		if(info != null) {
			en_de_criptionModulues = new En_De_criptionModulues("resist");
			en_de_criptionModulues.initRSAkey(request);
			membership = info;
		}
		
		model.addAttribute("membership", membership);
		
		/* getSession sign out */
		String signout = (String) request.getParameter("signout");
		if(httpSession.getAttribute("signIn") != null && signout != null) {
			httpSession.removeAttribute("signIn");
		}
		
		/* getSession sign in */
		if(httpSession.getAttribute("signIn") != null) {
			System.out.println("log in");
			model.addAttribute("logNick", httpSession.getAttribute("signIn").toString());
		}
	
		return "index";
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
				System.out.println(basicSearch.size());
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
				System.out.println("start : "+Integer.parseInt(basicSearch.get((pageNumInt-1)*10).getIdx()));
				System.out.println("end : "+Integer.parseInt(basicSearch.get(basicSearch.size()-1).getIdx()));
				System.out.println("pageBasic : " + pageBasic.size());
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
	
	//create RSA public key init
	@RequestMapping(value="/createRSAkey", method = RequestMethod.POST)
	public void createRSAkey(HttpServletRequest request, HttpServletResponse response) throws Exception{
		en_de_criptionModulues = new En_De_criptionModulues("log");
		String[] getInitRSAkey = en_de_criptionModulues.initRSAkeyLog(request);
		String getData = "{\"a\":\""+getInitRSAkey[0]+"\",\"b\":\""+getInitRSAkey[1]+"\"}";
		response.getWriter().print(getData);
	}
}