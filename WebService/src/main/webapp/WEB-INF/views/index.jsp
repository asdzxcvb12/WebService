<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- meta -->
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charest=utf-8">
	
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister">
	<link rel="stylesheet" type="text/css" href="resources/css/common.css?ver=3">
	<link rel="stylesheet" type="text/css" href="resources/css/header.css?ver=40">
	<link rel="stylesheet" type="text/css" href="resources/css/content.css?ver=1">
	<link rel="stylesheet" type="text/css" href="resources/css/footer.css?ver=1">
	<link rel="stylesheet" type="text/css" href="resources/css/membership.css?ver=5">
	
	<!-- jquery -->
	<script type="text/javascript" src="resources/js/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="resources/js/membership.js?ver=5"></script>
</head>
<body id="common_style">
<div class="common_container">
	<!-- header -->
	<div id="header">
		<%@ include file="./include/header.jsp" %>
	</div>
	
	<!-- content -->
	<div id="content">
		<%@ include file="./include/content.jsp" %>
	</div>
	
	<!-- footer -->
	<div id="footer">
		<%@ include file="./include/footer.jsp" %>
	</div>
</div>
</body>
</html>
