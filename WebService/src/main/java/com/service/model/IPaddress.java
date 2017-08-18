package com.service.model;

/*
 	1. HttpServletRequest �� getRemoteAddr() �� ȣ���ϸ� �ǹǷ�  RequestContextHolder �� ���� HttpServletRequest ȹ��
	2. WAS �� ���� 2�� ��ȭ�� �ȿ� �ְ� Web Server �� ���� client ���� ȣ��ǰų� cluster�� �����Ǿ� load balancer ���� ȣ��Ǵµ� �̷� ��쿡�� getRemoteAddr() �� ȣ���ϸ� �������� load balancer�� IP �� ����
	3. ���� ���� ������ �ذ��ϱ� ���� ���Ǵ� HTTP Header �� X-Forwarded-For ���� Ȯ���ؼ� ������ �̰� ����ϰ� ������ getRemoteAddr() ���
	
	! WebLogic �� web server ���� ����� weblogic connector �� �� ����� ������� �ʰ� Proxy-Client-IP �� WL-Proxy-Client-IP �� ����ϹǷ� weblogic ���� ���� application �ۼ��� ������ �ʿ���
	Proxy(������) ȯ�濡�� client IP �� ��� ���� X-Forwarded-For(XFF) http header ����
 */

import javax.servlet.http.HttpServletRequest;

public class IPaddress {
	HttpServletRequest request;
	
	public IPaddress(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getAddress() {
		
			String ip = request.getHeader("X-FORWARDED-FOR");
			if(ip == null) ip = request.getRemoteAddr();
				
		return ip;
	}
	
}
