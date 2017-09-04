<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8"> 
	<script type="text/javascript">
		function result(param) {
			if(param == 'logYes') {
				alert('Welcome');
				location.href = "/project/index.do";
			} else if(param == 'logNo') {
				alert('check your id and pw');
				location.href = "/project/index/membership/signInUp.do";
			} else if(param == 'membershipOk') {
				alert('Welcome to join us');
				location.href = "/project/index.do";
			} else if(param == 'writeResult') {
				var cate = document.getElementById('cate').value;
				var subCate = document.getElementById('subCate');
				alert('resist!!');
				location.href = "/project/index.do?cate="+cate+"&subCate="+subCate;
			}
			else location.href = "/project/index.do";		
		}	
	</script>
</head>
<body onload="result('${resultParam}')">
<input type="hidden" id="cate" value="${cate}">
<input type="hidden" id="subCate" value="${subCate}">
</body>
</html>