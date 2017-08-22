<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
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
	
	<!-- header image -->
	<img alt="sample" src="resources/img/header.jpg" width="100%" height="200px"/>

	<!-- menu bar -->
	<p id="MenuBar">
		<strong class="title">Code Storage</strong> 
		<a href="#" class="menu">one</a>
		<a href="#" class="menu">two</a>
		<a href="#" class="menu">three</a>
	 	<a href="#" class="menu">four</a>
	 	<a href="#" class="menu">five</a>
	</p>
	 
</body>
</html>

