<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<!-- login or out or resist -->
	<div align="right">
		<nav id="log">
			<ul>
				<li><a href="#" class="signin">Sign In</a></li>
				<li> or </li>
				<li><a href="?membership=membership" class="signup">Sign Up</a></li>
			</ul>
		</nav>
	</div>
	
	<!-- header image -->
	<img alt="sample" src="resources/img/header.jpg" width="100%" height="200px"/>

	<!-- menu bar -->
	<p id="MenuBar">
		<strong class="title">Code Storage</strong> 
		<a href="#" class="menu">one</a>
		<a href="#" class="menu">two</a>
		<a href="#" class="menu">three</a>
	 	<a href="#" class="menu">four</a>
	 	<a href="#" class="menu">five</a>
	</p>
	 
</body>
</html>

