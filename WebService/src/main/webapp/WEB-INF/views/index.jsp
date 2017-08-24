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
	<link rel="stylesheet" type="text/css" href="resources/css/header.css?ver=52">
	<link rel="stylesheet" type="text/css" href="resources/css/content.css?ver=10">
	<link rel="stylesheet" type="text/css" href="resources/css/content_left.css?ver=11">
	<link rel="stylesheet" type="text/css" href="resources/css/footer.css?ver=3">
	<link rel="stylesheet" type="text/css" href="resources/css/membership.css?ver=13">
	
	<!-- rsa -->
	<script type="text/javascript" src="resources/js/rsa/jsbn.js"></script>
	<script type="text/javascript" src="resources/js/rsa/prng4.js"></script>
	<script type="text/javascript" src="resources/js/rsa/rng.js"></script>
	<script type="text/javascript" src="resources/js/rsa/rsa.js"></script>
	
	<!-- jquery -->
	<script type="text/javascript" src="resources/js/jquery/jquery-3.2.1.min.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="resources/js/header.js?ver=7"></script>
	<script type="text/javascript" src="resources/js/content_left.js?ver=52"></script>
	<script type="text/javascript" src="resources/js/membership_term.js?ver=10"></script>
	<script type="text/javascript" src="resources/js/membership_info.js?ver=26"></script>
</head>
<body id="common_style" onload="javascript:go_time()">
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
