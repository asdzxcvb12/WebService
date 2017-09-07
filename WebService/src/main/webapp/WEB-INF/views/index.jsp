<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div align="center" style="width: 50%;float: left;">
	<Strong style="font-size: 20px;">-&nbsp;조회 Rank&nbsp;-</Strong>
		<table id="common_board" style="width: 100%">
			<tr align="center" class="common_board_tr">
				<td style="width: 20%">게시판</td>
				<td style="width: 10%">번호</td>
				<td style="width: 50%">제목</td>
				<td style="width: 20%">조회수</td>
			</tr>
			<c:forEach items="${lookUpRank}" var="lookRank">
				<tr align="center" class="common_board_td">
					<td style="width: 20%;	 white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${lookRank.board_name}</td>
					<td style="width: 10%">${lookRank.idx}</td>
					<td style="width: 50%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${lookRank.title}</td>
					<td style="width: 20%">${lookRank.lookup}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
	</div>
	
	<div align="center" style="width: 50%; float: left;">
	<Strong style="font-size: 20px;">-&nbsp;추천 Rank&nbsp;-</Strong>
		<table id="common_board" style="width: 100%">
			<tr align="center" class="common_board_tr">
				<td style="width: 20%">게시판</td>
				<td style="width: 10%">번호</td>
				<td style="width: 50%">제목</td>
				<td style="width: 20%">추천</td>
			</tr>
			<c:forEach items="${recommendedRank}" var="recommendedRank">
				<tr align="center" class="common_board_td">
					<td style="width: 20%;	 white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${recommendedRank.board_name}</td>
					<td style="width: 10%">${recommendedRank.idx}</td>
					<td style="width: 50%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${recommendedRank.title}</td>
					<td style="width: 20%">${recommendedRank.recommended}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
	</div>
	
	<hr>
	<div align="center" style="width: 50%; float: left;">
	<br>
		<Strong style="font-size: 20px;">-&nbsp;글작성 Rank&nbsp;-</Strong>
		<table id="common_board" style="width: 100%">
			<tr align="center" class="common_board_tr">
				<td>등수</td>
				<td>작성자</td>
				<td>작성갯수</td>
			</tr>
			<c:forEach items="${writerRank}" var="writerRank" varStatus="writerRankStatus">
				<tr align="center" class="common_board_td">
					<td style="white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${writerRankStatus.count}</td>
					<td>${writerRank.writer}</td>
					<td style="; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${writerRank.count}</td>
				</tr>
			</c:forEach>
		</table>
	<br>
	<br>
	</div>
	
	<div align="center" style="width: 50%; float: left;">
	<br>
		<Strong style="font-size: 20px;">-&nbsp;최신 Rank&nbsp;-</Strong>
		<table id="common_board" style="width: 100%">
			<tr align="center" class="common_board_tr">
				<td style="width: 20%">게시판</td>
				<td style="width: 10%">번호</td>
				<td style="width: 40%">제목</td>
				<td style="width: 30%">등록일자</td>
			</tr>
			<c:forEach items="${createDateRank}" var="createDateRank">
				<tr align="center" class="common_board_td">
					<td style="width: 20%;	 white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${createDateRank.board_name}</td>
					<td style="width: 10%">${createDateRank.idx}</td>
					<td style="width: 40%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${createDateRank.title}</td>
					<td style="width: 30%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${createDateRank.create_date}</td>
				</tr>
			</c:forEach>
		</table>
	<br>
	<br>
	</div>
	<hr>
</body>
</html>
