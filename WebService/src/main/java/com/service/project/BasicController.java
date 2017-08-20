package com.service.project;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.database.Test;
import com.service.database.TestDAOService;
import com.service.model.IPaddress;

@Controller
public class BasicController {
	
	@Autowired TestDAOService testDAOService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main_page(Model model, HttpServletRequest request) throws Exception {
		
		IPaddress ipAddress = new IPaddress(request);
		
		model.addAttribute("ip", ipAddress.getAddress());
		
		List<Test> test = testDAOService.getTestVal();
		
		String cate = test.get(0).getCate();
		String value = test.get(0).getValue();
		String sub = test.get(0).getSub();
		
		model.addAttribute("cate", cate);
		model.addAttribute("value", value);
		model.addAttribute("sub", sub);
		
		return "index";
	}
}
