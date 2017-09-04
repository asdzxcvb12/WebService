<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.signNick eq null}">
	<!-- login or out or resist -->
	<div align="right" style="width: 100%">
		<nav id="log">
			<ul>
				<li>
    				<a href="/project/index/membership/signInUp.do" id="signInBtn" class="commonAtag">Sign In</a>
				</li>
				<li> or </li>
				<li><a href="/project/index/membership/term.do" class="signup">Sign Up</a></li>
			</ul>
		</nav>
	</div>
	</c:when>
	<c:otherwise>
		<div align="right" style="width: 100%">
			Welcome to our site <strong style="color: blue; font-size: 20px;">Mr. ${sessionScope.signNick}</strong>
			<form id="signoutForm" action="/project/index/signOut/result.do" method="post">
				<a id="signoutBtn" class="commonAtag">Sign Out</a>
				<input type="hidden" id="signout" name="signout" value="signout">
			</form>
		</div>
	</c:otherwise>
</c:choose>
	
	<!-- header image -->
	<img alt="sample" src="/project/resources/img/header.jpg" width="100%" height="200px"/>

	<!-- menu bar -->
	<p id="MenuBar">
		<Strong class="title">Code Storage</Strong> 
		<c:forEach items="${top}" var="topMenu" varStatus="topStatus">
			<c:choose>
				<c:when test="${topStatus.first}">
					<a href="/project/index.do" class="menu">${topMenu}</a>
				</c:when>
				<c:otherwise>
					<a href="/project/index.do?cate=${topMenu}" class="menu">${topMenu}</a>
				</c:otherwise>
			</c:choose>
	 	</c:forEach>
	</p>
</body>
</html>