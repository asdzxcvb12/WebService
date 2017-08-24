<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<c:choose>
		<c:when test="${membership eq 'null'}">
			<div class="content_left">
				<%@ include file="./content_left.jsp" %>
			</div>

			<div class="content_right">
				<%@ include file="./content_right/content_right_main.jsp" %>
			</div>
		</c:when>
		<c:when test="${membership eq 'term'}">
			<%@ include file="./membership/term.jsp" %>
		</c:when>
		<c:otherwise>
			<%@ include file="./membership/info.jsp" %>		
		</c:otherwise>
	</c:choose>
</body>
</html>
