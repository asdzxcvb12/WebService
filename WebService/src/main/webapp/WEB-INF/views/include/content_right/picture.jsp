<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div style="width: 100%;">
<%-- <c:choose>
	<c:when test="${img == null}">
		<div align="center" style="width: 30%; height: 200px; float: left; padding: 10px;">
				<img alt="noImg" src="" style="width: 100%; height: 100%"/>
				<strong>${img.writer}</strong>
			</div>
	</c:when>
	<c:otherwise>
	<c:forEach items="img" var="imgs">
			<div align="center" style="width: 30%; height: 200px; float: left; padding: 10px;">
				<img alt="sample" src="/project/resources/img/upload/${imgs.img}" style="width: 100%; height: 100%"/>
				<strong>${imgs.writer}</strong>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose> --%>

	<c:forEach items="${img}" var="imgs">
	<div class="setDiv">
    					<div align="center" style="width: 30%; height: 200px; float: left; padding: 10px;">
				<img class="showMask" onclick="clickImg()" alt="sample" src="/project/resources/img/upload/${imgs.img}" style="width: 100%; height: 100%"/>
				<strong>${imgs.writer}</strong>
			</div>
    					<div class="mask"></div>
    					<div class="window" align="center">
    						<div class="close"></div>
			<img class="showMask" alt="sample" src="/project/resources/img/upload/${imgs.img}"/>
			</div>
			</div>
		</c:forEach>
<%-- 	<c:forEach items="${img}" var="imgs">
			<div align="center" style="width: 30%; height: 200px; float: left; padding: 10px;">
				<img alt="sample" src="/project/resources/img/upload/${imgs.img}" style="width: 100%; height: 100%"/>
				<strong>${imgs.writer}</strong>
			</div>
		</c:forEach> --%>
	<div align="center" style="width: 100%; float: left">
	<br><br>
	<a class="commonAtag">&lt;&lt;&lt;&lt;</a>
	&nbsp;
		<c:forEach begin="1" end="${imgMaxPage}" step="1" varStatus="count">
			&nbsp;<a class="commonAtag">${count.count}</a>&nbsp;
		</c:forEach>
	&nbsp;
	<a class="commonAtag">&gt;&gt;&gt;&gt;</a>
	</div>
	<div align="center" style="width: 100%; float: left">
		<br><hr>
		<form id="inserForm" action="/project/fileUpLoad.do" enctype="multipart/form-data" method="POST">
			<input type="hidden" id="imgCate" name="cate" value="${cate}">
			<input type="hidden" id="imgSubCate" name="subCate" value="${subCate}">
			<input type="file" id="uploadFile" name="uploadFile">
			<input type="hidden" id="imgSession" value="${sessionScope.signId}">
			<a id="imgFormSubmit" class="commonAtag">submit</a>
		</form>
	</div>
</div>
</body>
</html>