package com.service.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.service.database.Tabs;
import com.service.database.TabsDAOService;
import com.service.model.BoardManage;
import com.service.model.DistributeTabs;

public class Commons extends HandlerInterceptorAdapter{
	
	@Autowired private TabsDAOService tabsDAOService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("commmmon");
		List<Tabs> tabs = tabsDAOService.getTabs();
		
		DistributeTabs distributeTabs = new DistributeTabs();
		List<String> top = distributeTabs.topMenu(tabs);
		List<Map<String, String>> side = distributeTabs.sideMenu(tabs);
		List<Map<String, Object>> sub = distributeTabs.subMenu(tabs, top);
		
		request.setAttribute("zeroTop", top.get(0));
		request.setAttribute("top", top);
		request.setAttribute("side", side);
		request.setAttribute("sub", sub);
		
		String cate = (String) request.getParameter("cate");
		if(cate == null || cate.equals("")) cate = "null";
		
		request.setAttribute("cate", cate);
		 
		String subCate = (String) request.getParameter("subCate");
		if(subCate == null || subCate.equals("")) {
			if(cate.equals("HOME")) subCate = "Home";
			else if(cate.equals("LANGUAGE")) subCate = "java";
			else if(cate.equals("GALLARY")) subCate = "Picture";
			else if(cate.equals("BOARD")) subCate = "PublicBoard";
			else if(cate.equals("NOTICE")) subCate = "MyPage";
			else subCate = "null";
		}

		request.setAttribute("subCate", subCate);
		
		
		BoardManage boardManage = new BoardManage();
		String boardName = boardManage.boardManage(cate, subCate);

		request.setAttribute("boardName", boardName);

		return super.preHandle(request, response, handler);
	}
	

}
