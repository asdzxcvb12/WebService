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
import com.service.database.Members;
import com.service.database.MembersDAOService;
import com.service.model.IPaddress;

@Controller
public class BasicController {
	
	@Autowired MembersDAOService membersDAOService;
	
	@RequestMapping(value="/")
	public String main_page(Model model, HttpServletRequest request) throws Exception {
		//term
		String membership = (String) request.getParameter("membership");
		if(membership != null) membership = "term";
		else membership = "null";
		//info
		String info = (String) request.getParameter("infoEmail");
		if(info != null) membership = info;
		
		model.addAttribute("membership", membership);
		
		IPaddress ipAddress = new IPaddress(request);
		model.addAttribute("ip", ipAddress.getAddress());
		
		return "index";
	}
	
	@RequestMapping(value="/SendMail", method= RequestMethod.POST)
	public void SendMail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = true;
	
		String email = (String) request.getParameter("email");
		List<Members> membersEmail= membersDAOService.getMembersEmail();
				
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
}
