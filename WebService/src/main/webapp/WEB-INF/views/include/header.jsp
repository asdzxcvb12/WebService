<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<c:choose>
	<c:when test="${logNick eq null}">
	<!-- login or out or resist -->
	<div align="right" style="width: 100%">
		<nav id="log">
			<ul>
				<li>
					<div class="setDiv">
    					<a id="signInBtn" class="showMask">Sign In</a>
    					<div class="mask"></div>
    					<div class="window" align="center">
    						<div class="close"></div>
    						<form id="logFormTag" action="." method="post">
    						<table border="1">
								<tr>
									<td>id</td>
									<td>
										<input type="text" id="logId" name="logId">
										<input type="hidden" id="a">
										<input type="hidden" id="logEncriptId" name="logEncriptId">
									</td>
									<td rowspan="2">
										<input type="button" id="logBtn" value="login" style="height: 65px">
									</td>
								</tr>
								<tr>
									<td>password</td>
									<td>
										<input type="password" id="logPassword" name="logPassword">
										<input type="hidden" id="b">
										<input type="hidden" id="logEncriptPw" name="logEncriptPw">
									</td>
								</tr>
								<tr>
									<td colspan="3" align="right">
										<a href="#" class="commonAtag">아이디</a>/
										<a href="#" class="commonAtag">비밀번호</a> 찾기
									</td>
								</tr>
							</table>
							</form>
    					</div>
					</div>
				</li>
				<li> or </li>
				<li><a href="?membership=term" class="signup">Sign Up</a></li>
			</ul>
		</nav>
	</div>
	</c:when>
	<c:otherwise>
		<div align="right" style="width: 100%">
			Welcome to our site <strong style="color: blue; font-size: 20px;">Mr. ${logNick}</strong>
			<form id="signoutForm" action="." method="post">
				<a id="signoutBtn" class="commonAtag">Sign Out</a>
				<input type="hidden" id="signout" name="signout" value="signout">
			</form>
		</div>
	</c:otherwise>
</c:choose>
	
	<!-- header image -->
	<img alt="sample" src="resources/img/header.jpg" width="100%" height="200px"/>

	<!-- menu bar -->
	<p id="MenuBar">
		<Strong class="title">Code Storage</Strong> 
		<c:forEach items="${top}" var="topMenu">
	 		<a href="?cate=${topMenu}" class="menu">${topMenu}</a>
	 	</c:forEach>
	</p>
	 
</body>
</html>

