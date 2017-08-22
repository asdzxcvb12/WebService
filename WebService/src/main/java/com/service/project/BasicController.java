package com.service.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.model.ConfirmEmailCode;
import com.service.model.SendEmail;
import com.service.model.En_De_criptionModulues;
import com.service.database.Members;
import com.service.database.MembersDAOService;
import com.service.model.IPaddress;

@Controller
public class BasicController {
	
	@Autowired 
	private MembersDAOService membersDAOService;
	private En_De_criptionModulues en_de_criptionModulues;
	@RequestMapping(value="/")
	public String main_page(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		//SignUP
		String logId = (String) request.getParameter("logEncriptId");
		String logPassword = (String) request.getParameter("logEncriptPw");
		
		if(logId != null && logPassword != null) {
			en_de_criptionModulues = new En_De_criptionModulues("log");
			boolean flag = false;
			System.out.println("logId : "+logId+"logPassword : "+logPassword);
			String ID_PW[] = en_de_criptionModulues.decrypt(request, logId, logPassword);
			logId = ID_PW[0];
			logPassword = ID_PW[1];
			List<Members> members = membersDAOService.getMembersLog();
			for(Members searchIdPw : members){
				System.out.println(searchIdPw.getId()+","+searchIdPw.getPw()+","+searchIdPw.getNick());
				if(searchIdPw.getId().equals(logId) && searchIdPw.getPw().equals(logPassword)) {
					flag = true;
					break;
				}
			}
			System.out.println(logId+","+logPassword);
			if(flag) {
				System.out.println("yesyes");
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
		
		IPaddress ipAddress = new IPaddress(request);
		model.addAttribute("ip", ipAddress.getAddress());
		
		return "index";
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
		
		if(flag) {
			getData = "{\"nickname\":\"true\"}";
		}
		
		response.getWriter().print(getData);
	}
	
	//create RSA public key init
	@RequestMapping(value="/createRSAkey", method = RequestMethod.POST)
	public void createRSAkey(HttpServletRequest request, HttpServletResponse response) throws Exception{
		en_de_criptionModulues = new En_De_criptionModulues("log");
		String[] test = en_de_criptionModulues.test(request);
		String getData = "{\"a\":\""+test[0]+"\",\"b\":\""+test[1]+"\"}";
		response.getWriter().print(getData);
	}
}
