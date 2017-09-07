<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div align="center" style="height: 540px; vertical-align: middle;">
<div style="padding-top: 20%;">
<form id="logFormTag" action="/project/index/signIn/result.do" method="post">
	<table border="1">
		<tr>
			<td>id</td>
			<td>
				<input type="text" id="logId" name="logId">
				<input type="hidden" id="a" value="${RSAModulus}">
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
				<input type="hidden" id="b" value="${RSAExponent}">
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
</body>
</html>