<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- commonTitle -->
	<title><decorator:title default="CodeStorage" /></title>
	
	<!-- meta -->
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charest=utf-8">
	
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister">
	<link rel="stylesheet" type="text/css" href="/project/resources/css/common.css?ver=3">
	<link rel="stylesheet" type="text/css" href="/project/resources/css/header.css?ver=52">
	<link rel="stylesheet" type="text/css" href="/project/resources/css/content.css?ver=11">
	<link rel="stylesheet" type="text/css" href="/project/resources/css/content_left.css?ver=12">
	<link rel="stylesheet" type="text/css" href="/project/resources/css/content_right.css?ver=24">
	<link rel="stylesheet" type="text/css" href="/project/resources/css/footer.css?ver=3">
	<link rel="stylesheet" type="text/css" href="/project/resources/css/membership.css?ver=13">
	
	<!-- rsa -->
	<script type="text/javascript" src="/project/resources/js/rsa/jsbn.js"></script>
	<script type="text/javascript" src="/project/resources/js/rsa/prng4.js"></script>
	<script type="text/javascript" src="/project/resources/js/rsa/rng.js"></script>
	<script type="text/javascript" src="/project/resources/js/rsa/rsa.js"></script>
	
	<!-- jquery -->
	<script type="text/javascript" src="/project/resources/js/jquery/jquery-3.2.1.min.js"></script>
	
	<!-- naverAPI -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="/project/resources/naverEditer/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	
	<!-- script -->
	<script type="text/javascript" src="/project/resources/js/header.js?ver=14"></script>
	<script type="text/javascript" src="/project/resources/js/content_left.js?ver=54"></script>
	<script type="text/javascript" src="/project/resources/js/membership_term.js?ver=14"></script>
	<script type="text/javascript" src="/project/resources/js/membership_info.js?ver=28"></script>
	<script type="text/javascript" src="/project/resources/js/basic_board.js?ver=24"></script>
	<script type="text/javascript" src="/project/resources/js/board_write.js?ver=12"></script>
</head>
<body id="common_style" onload="go_time()">
<div class="common_container">

	<!-- header -->
	<div id="header">
		<%@ include file="./decoInclude/header.jsp" %>
	</div>
	
	<!-- content -->
	<div id="content">
	<c:choose>
		<c:when test="${pageSplit}">
			<div class="content_left">
				<%@ include file="./decoInclude/content_left.jsp" %>
			</div>
			<div class="content_right">
				<decorator:body></decorator:body>	
			</div>
		</c:when>
		<c:otherwise>
			<decorator:body></decorator:body>
		</c:otherwise>
	</c:choose>
	</div>
	
	<!-- footer -->
	<div id="footer">
		<%@ include file="./decoInclude/footer.jsp" %>
	</div>
	
</div>
</body>