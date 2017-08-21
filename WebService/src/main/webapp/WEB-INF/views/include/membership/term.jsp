<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8;">
	
	<title>Code Storage Membership Term</title>
</head>
<body>
<form id="confirmEmail">
	<div align="center">
		<strong style="font-size: 30px;">Membership Term</strong>
	</div>
	
	<fieldset id="terms">
		<legend align="left" class="title">Term One</legend>
		content<br>
		content<br>
		content<br>
		content<br>
		content<br>
	</fieldset>	
	
	<div id="radioBtn" align="right">
		<input type="checkbox" value="agree" name="chkTermsOne">agree
		<input type="checkbox" value="disagree" name="chkTermsOne" checked="checked">disagree
	</div>
	
	<fieldset id="terms">
		<legend align="left" class="title">Term Two</legend>
		content<br>
		content<br>
		content<br>
		content<br>
		content<br>
	</fieldset>	

	<div id="radioBtn" align="right">
		<input type="checkbox" value="agree" name="chkTermsTwo">agree
		<input type="checkbox" value="disagree" name="chkTermsTwo" checked="checked">disagree
	</div>
	
	<div id="inputEmail" align="center">
		<hr>Confirm the E-Mail
			<table>
				<tr>
					<td>E-mail</td>
					<td>
						<input type="text" id="frontEmail" name="frontEmail"
						size="15px" placeholder="xxxxxx" style="text-align: center">
						@ 
						<input type="text" id="backEmail" name="backEmail" size="10px"
						disabled="disabled" placeholder="xxxxx.xxx"
						style="text-align: center"> 
						
						<select id="emailBack">
							<option id="0" value="">select Email</option>
							<option id="1" value="gmail.com">gmail.com</option>
							<option id="2" value="naver.com">naver.com</option>
							<option id="3" value="daum.net">daum.net</option>
							<option id="4" value="self">self</option>
						</select> 
						
						<input type="button" value="SendE-mail" id="sendE_mail">
					</td>
				</tr>
			
				<tr>
					<td>E-mail Check</td>
					<td>
						<input type="password" id="insertCode" size="20px" disabled="disabled">
						<span id="checkCodeMsg"></span>
						<input type="hidden" id="getCode">
					</td>
				</tr>
			</table>	
	</div>
</form>
<div align="center">
<form id="infoMembership">
	<div id="cancle_next" class="cancle_next">
		<strong id="termCancle" class="cancle">CANCLE...</strong>	
		<strong id="termNext" class="next">NEXT...</strong>
		<input type="hidden" id="infoEmail" name="infoEmail">
	</div>
</form>
</div>
</body>
</html>