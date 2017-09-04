<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="text/html; charser=utf-8">
</head>
<body>
<form id="writeForm">
	<div align="center" style="width: 100%">
		<table style="width: auto">
			<tr align="center" style="margin-bottom: 10px; border-bottom: 3px dotted #444444; ">
				<td colspan="3"><Strong style="font-size: 20px; margin-bottom: 20px;">-&nbsp;Board Write&nbsp;-</Strong></td>
			</tr>
			
			<tr><td colspan="3">&nbsp;</td></tr>
			
			<tr>
				<td align="center">Title</td>
				<td>::</td>
				<td><input id="titleTextBox" name="titleTextBox" type="text" size="98px"></td>
			</tr>
			<tr>
				<td align="center">writer</td>
				<td>::</td>
				<td>
					${sessionScope.signNick}
				</td>
			</tr>
			<tr>
				<td align="center">content</td>
				<td>::</td>
				<td style="background-color: white;">
					<textarea name="ir1" id="ir1" rows="15" cols="100"></textarea>
					<script type="text/javascript" charset="">
						var oEditors = [];
						nhn.husky.EZCreator.createInIFrame({
    					oAppRef: oEditors,
    					elPlaceHolder: "ir1",
    					sSkinURI: "/project/resources/naverEditer/se2.jsp",
    					fCreator: "createSEditor2"
					});
					</script>
				</td>
			</tr>
			
			<tr><td colspan="3">&nbsp;</td></tr>
			
			<tr align="center">
				<td colspan="3">
					<a id="boardWriteCancle" class="commonAtag" style="margin-right: 20px;">Cancle</a>
					<a class="commonAtag" style="margin-left: 20px;" onclick="showHTML()">Submit</a>
					<input type="hidden" id="getBoardCate" name="cate" value="${cate}">
					<input type="hidden" id="getBoardSubCate" name="subCate" value="${subCate}">
					<input type="hidden" id="getBoardName" name="boardName" value="${boardName}">
					<input type="hidden" id="resultContent" name="resultContent">
				</td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>