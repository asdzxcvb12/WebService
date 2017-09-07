<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8;">
</head>
<body>
<!-- search tables -->
	<fieldset class="basicField">
		<legend>Board Search</legend>
		<div align="center">
			<input type="text" size="20px"><input type="button" value="go">
		</div>
	</fieldset>
	
<br><!-- time -->
	<fieldset class="basicField">
		<legend>TimeStamp</legend>
		<div align="center">
			<table>
				<tr>
					<td><span id="ymd"></span></td>
				</tr>
				<tr>
					<td><span id="time"></span></td>
				</tr>
			</table>
		</div>
	</fieldset>
	
<br><!-- menu -->
<div align="left">
		<fieldset class="basicField">
			<c:if test="${cate == 'null'}"><c:set var="cate" value="${zeroTop}" /></c:if>
				<legend align="top" style="font-size: 20px; font-style: bold; text-align: center"><b>${cate}</b></legend>

				<c:forEach items="${side}" var="sideMenu" varStatus="sideStatus">
					<c:if test="${sideMenu.get(cate) != null}">
						<span style="text-align: center">${sideMenu.get(cate)}</span>
					</c:if>
					<nav>
					<c:forEach items="${sub}" var="subMenu">
						<c:choose>
							<c:when
								test="${subMenu.get(cate).getClass().getSimpleName() eq 'HashMap'}">
								<c:set value="${subMenu.get(cate)}" var="sideSubMenu" />
								<c:if test="${sideSubMenu.get(sideMenu.get(cate)) != null}">
									<c:choose>
										<c:when test="${sideSubMenu.get(sideMenu.get(cate)) == 'PrivateBoard'}">
											<li style="margin-left: 30px"><a class="sideMenuAtag" onclick="privateTag('${cate}', '${sideSubMenu.get(sideMenu.get(cate))}')">
											${sideSubMenu.get(sideMenu.get(cate))}</a></li>
										</c:when>
										<c:otherwise>
											<li style="margin-left: 30px"><a href="/project/index.do?cate=${cate}&subCate=${sideSubMenu.get(sideMenu.get(cate))}" class="sideMenuAtag">
											${sideSubMenu.get(sideMenu.get(cate))}</a></li>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:when>

							<c:when
								test="${subMenu.get(cate).getClass().getSimpleName() ne 'HashMap'}">
								<c:if test="${sideStatus.first}">
									<c:if test="${subMenu.get(cate) != null}">
										<li>
										<c:choose>
											<c:when test="${subMenu.get(cate) == 'PrivateBoard'}">
												<a style="text-align: center" class="sideMenuAtag" onclick="privateTag('${cate}', '${sideSubMenu.get(sideMenu.get(cate))}')">${subMenu.get(cate)}</a>
											</c:when>
											<c:otherwise>
												<a style="text-align: center" class="sideMenuAtag" 
												href="/project/index.do?cate=${menu}&subCate=${subMenu.get(cate)}">${subMenu.get(cate)}</a>
											</c:otherwise>
										</c:choose>
										</li>
									</c:if>
								</c:if>
							</c:when>
						</c:choose>
					</c:forEach>
					</nav>
				</c:forEach>
	</fieldset>
</div>

<br><!-- calendar -->
	<fieldset class="basicField">
	<input type="hidden" id="calCount">
	<input type="hidden" id="calCountYear">
		<legend>Calendar</legend>
		<div align="center">
			<table id="Calendar"></table>
		</div>
	</fieldset>
</body>
</html>