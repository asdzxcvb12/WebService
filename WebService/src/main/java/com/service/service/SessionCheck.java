package com.service.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionCheck extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String nick = (String) session.getAttribute("signNick");
		String id = (String) session.getAttribute("signId");
		if(nick == null && id == null) {
			response.getWriter().print("<script>alert('you need signIn');history.back();</script>");
			return false;
		} else {
			return super.preHandle(request, response, handler);
		}
		
	}

}
