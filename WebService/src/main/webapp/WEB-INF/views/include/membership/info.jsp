<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8;">
</head>
<body>
<form id="membershipResult" action="." method="post">
	<div align="center">
	<strong style="font-size: 30px;">Membership Info</strong>
		<table style="color: white; padding-top: 20px;">
			<tr>
				<td>ID</td>
				<td>
					<input type="hidden" id="RSAModulus" value="${RSAModulus}">
					<input type="text" id="membershipID" name="membershipID" size="20px" placeholder="at least 7 charactors" maxlength="20">		
					<input type="hidden" id="membership_ID" name="membership_ID"> 
					<input type="button" value="Check" id="idChk">
					<div id="idInvisibility" style="display: none;">
						<input type="button" value="Change" id="idCge">
					</div>
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
					<input type="password" id="membershipPW" name="membershipPW" size="20px" placeholder="at least 8 charactors" maxlength="20">
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
					<input type="password" id="chkMemberPW" size="20px" disabled="disabled">
					<span id="chkPW" style="font-size: 10px"></span>
				</td>
			</tr>
			<tr>
				<td>NickName</td>
				<td>
					<input type="text" size="20px" id="membership_NickName" name="membership_NickName" placeholder="nickname"> 
					<input type="button" value="Check" id="nicknameChk">
					<input type="hidden" id="membership_NICK" name="membership_NICK">
					<div id="nicknameInvisibility" style="display: none;">
						<input type="button" value="Change" id="nicknameCge">
					</div>
				</td>
			</tr>
			<tr>
				<td></td>
				<td id="effectNN" style="font-size: 10px"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<input type="text" id="setEmail" name="setEmail" disabled="disabled" value="${membership}">
					<input type="hidden" id="membership_EMAIL" name="membership_EMAIL">
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<input type="text" id="postcode" name="postcode" placeholder="postcode" disabled="disabled">
					<input type="hidden" id="membership_POSTCODE" name="membership_POSTCODE">
					<input type="button" id="address" name="address" value="find address">
				</td>
			</tr>
			<tr>
				<td><span id="guide" style="color:#999"></span></td>
				<td>
					<input type="text" id="roadAddress" name="roadAddress" placeholder="roadAddress" size="30px" disabled="disabled">
					<input type="hidden" id="membership_ROADADDRESS" name="membership_ROADADDRESS">
					<input type="text" id="jibunAddress" name="jibunAddress" placeholder="jibunAddress" size="24.8px" disabled="disabled">
					<input type="hidden" id="membership_JIBUNADDRESS" name="membership_JIBUNADDRESS">
				</td>
			</tr>
			<tr>
				<td>Detail Address</td>
				<td>
					<input type="text" id="detailAddress" name="detailAddress" placeholder="DetailAddress" size="60px">
					<input type="hidden" id="membership_JIBUNADDRESS" name="membership_DETAILADDRESS">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<fieldset>
						<legend>Favorite Language</legend>
						<p>Select</p>
						<div align="center">
							<input type="checkbox" name="upFavorite" value="Android">Android
							<input type="checkbox" name="upFavorite" value="WEB">WEB
							<input type="checkbox" name="upFavorite" value="WAS">WAS
							<input type="checkbox" name="upFavorite" value="GIT">GIT
							<input type="checkbox" name="upFavorite" value="R">R
						</div>
						<br>
						<p>Detail</p>
						<div align="center">
							<input type="checkbox" name="downFavorite" value="java">java
							<input type="checkbox" name="downFavorite" value="kotlin">kotlin
							<input type="checkbox" name="downFavorite" value="http">http
							<input type="checkbox" name="downFavorite" value="css">css
							<input type="checkbox" name="downFavorite" value="javascript">javascript
							<input type="checkbox" name="downFavorite" value="jquery">jquery
							<input type="checkbox" name="downFavorite" value="jstl">jstl
							<br>
							<input type="checkbox" name="downFavorite" value="jsp">jsp
							<input type="checkbox" name="downFavorite" value="php">php
							<input type="checkbox" name="downFavorite" value="asp">asp
							<input type="checkbox" name="downFavorite" value="github">github
							<input type="checkbox" name="downFavorite" value="Machain Running">Machain Running
							<input type="checkbox" name="downFavorite" value="python">python							
						</div>
					</fieldset>
					<input type="hidden" id="languageList" name="languageList">
				</td>
			</tr>
		</table>
	</div>
	<div align="center">
	<div id="cancle_next" class="info_cancle_next">
		<strong id="infoCancle" class="cancle">CANCLE...</strong>	
		<strong id="infoNext" class="next">NEXT...</strong>
	</div>
	</div>
</form>
</body>
</html>