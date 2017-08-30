<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<div align="center" style="width: 100%">
		<table style="width: auto">
			<tr align="center" style="margin-bottom: 10px; border-bottom: 3px dotted #444444; ">
				<td colspan="3"><Strong style="font-size: 20px; margin-bottom: 20px;">-&nbsp;Board ${boardKind}&nbsp;-</Strong></td>
			</tr>
			
			<tr><td colspan="3">&nbsp;</td></tr>
			
			<tr>
				<td align="center">Title</td>
				<td>::</td>
				<td><Strong>${contentBoard.get(1).getTitle()}</Strong></td>
			</tr>
			<tr>
				<td align="center">writer</td>
				<td>::</td>
				<td>
					${contentBoard.get(1).getWriter()}
				</td>
			</tr>
			<tr>
				<td align="center">content</td>
				<td>::</td>
				<td style="background-color: white;">
					${contentBoard.get(1).getContent()}
				</td>
			</tr>
			
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td>Prev</td>
				<td colspan="2">
					<c:choose>
						<c:when test="${contentBoard.get(0) == null}">
							none
						</c:when>
						<c:otherwise>
							${contentBoard.get(0).getContent()}
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>Next</td>
				<td colspan="2">
					<c:choose>
						<c:when test="${contentBoard.get(2) == null}">
							none
						</c:when>
						<c:otherwise>
							${contentBoard.get(2).getContent()}
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>commentWrite</td>
				<td>content</td>
				<td>submit</td>
			</tr>
			<tr>
			<c:forEach items="${comment}" var="comment" varStatus="commentStatus">
				<td>${comment.getNickname()}</td>
				<td colspan="2">${comment.getCon_comment()}</td>
			</c:forEach>
			</tr>
			<tr align="center">
				<td colspan="3">
					<a id="boardWriteCancle" class="commonAtag" style="margin-right: 20px;">Back</a>
					<input type="hidden" id="getBoardCate" name="getBoardCate" value="${cate}">
					<input type="hidden" id="getBoardSubCate" name="getBoardSubCate" value="${subCate}">
					<input type="hidden" id="resultContent" name="resultContent">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>