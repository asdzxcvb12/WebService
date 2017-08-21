<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8;">
</head>
<body>
	<div align="center">
	<strong style="font-size: 30px;">Membership Info</strong>
		<table style="color: white; padding-top: 20px;">
			<tr>
				<td>ID</td>
				<td>
					<input type="hidden" id="RSAModulus" value="${RSAModulus}">
					<input type="text" id="membershipID" size="20px" onKeyUp="javascript:effectID(this.value)" placeholder="at least 7 charactors" maxlength="20">					<input type="hidden" id="membership_ID" name="membership_ID"> 
					<input type="button" value="Check" id="chk">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><span id="effectID" style="font-size: 10px"></span></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="hidden" id="RSAExponent" value="${RSAExponent}">
					<input type="password" id="membershipPW" size="20px" onkeyup="javascript:effectPW(this.value)" placeholder="at least 8 charactors" maxlength="20">
					<span id="chkingPW" style="font-size: 10px"></span>
					<input type="hidden" id="membership_PW" name="membership_PW">
				</td>
			</tr>
			<tr>
				<td></td>
				<td id="effectPW" style="font-size: 10px"></td>
			</tr>
			<tr>
				<td>Password Check</td>
				<td>
					<input type="password" id="chkMemberPW" size="20px" onkeyup="javascript:chkPW(this.value)" disabled="disabled">
					<span id="chkPW"></span>
				</td>
			</tr>
			<tr>
				<td>NickName</td>
				<td>
					<input type="text" size="20px" id="membership_NickName" name="membership_NickName"> 
					<input type="button" value="Check">
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" id="setEmail" name="setEmail" disabled="disabled" value="${membership}"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<input type="text" id="postcode" placeholder="postcode" disabled="disabled">
					<input type="button" id="address" value="find address">
				</td>
			</tr>
			<tr>
				<td><span id="guide" style="color:#999"></span></td>
				<td>
					<input type="text" id="roadAddress" placeholder="roadAddress" size="30px" disabled="disabled">
					<input type="text" id="jibunAddress" placeholder="jibunAddress" size="24.8px" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td>Detail Address</td>
				<td><input type="text" id="detailAddress" placeholder="DetailAddress" size="60px"></td>
			</tr>
			<tr>
				<td colspan="2">
					<fieldset>
						<legend>Favorite Language</legend>
						<p>Select one</p>
						<div align="center">
							<input type="radio" name="group" checked="checked">Android
							<input type="radio" name="group">WEB
							<input type="radio" name="group">WAS
							<input type="radio" name="group">GIT
							<input type="radio" name="group">Machain Running
						</div>
						<br>
						<p>Detail</p>
						<div align="center">
							<input type="radio">java
							<input type="radio">kotlin
							<input type="radio">http/css
							<input type="radio">javascript
							<input type="radio">jquery
							<input type="radio">jstl
							<br>
							<input type="radio">jsp
							<input type="radio">php
							<input type="radio">asp
							<input type="radio">github
							<input type="radio">R
							<input type="radio">python							
						</div>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="reset" id="membershiptReset" value="reset" style="margin-right: 10px">
					<input type="submit" id="membershipSubmit" value="submit" style="margin-left: 10px">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>