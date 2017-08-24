package com.service.model;

import java.util.List;
import java.util.Map;

import com.service.database.Tabs;

public interface TabItem {
	public List<String> topMenu(List<Tabs> Tabs);
	public List<Map<String, String>> sideMenu(List<Tabs> Tabs);
	public List<Map<String, Object>> subMenu(List<Tabs> Tabs, List<String> topMenu);
}
