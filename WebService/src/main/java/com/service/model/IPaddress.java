package com.service.model;

/*
 	1. HttpServletRequest 의 getRemoteAddr() 를 호출하면 되므로  RequestContextHolder 를 통해 HttpServletRequest 획득
	2. WAS 는 보통 2차 방화벽 안에 있고 Web Server 를 통해 client 에서 호출되거나 cluster로 구성되어 load balancer 에서 호출되는데 이럴 경우에서 getRemoteAddr() 을 호출하면 웹서버나 load balancer의 IP 가 나옴
	3. 위와 같은 문제를 해결하기 위해 사용되는 HTTP Header 인 X-Forwarded-For 값을 확인해서 있으면 이걸 사용하고 없으면 getRemoteAddr() 사용
	
	! WebLogic 의 web server 연계 모듈인 weblogic connector 는 위 헤더를 사용하지 않고 Proxy-Client-IP 나 WL-Proxy-Client-IP 를 사용하므로 weblogic 에서 도는 application 작성시 수정이 필요함
	Proxy(프락시) 환경에서 client IP 를 얻기 위한 X-Forwarded-For(XFF) http header 참조
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
