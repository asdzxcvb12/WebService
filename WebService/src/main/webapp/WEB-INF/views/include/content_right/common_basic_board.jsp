<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<form>
	<div align="center" style="width: 100%;">
	<Strong>Sample Board</Strong>
		<table style="width: 100%;" id="common_board">
			<tr align="center" class="common_board_tr">
				<th style="width: 5%" class="common_board_td">번호</th>
				<th style="width: 40%" class="common_board_td">제목</th>
				<th style="width: 10%" class="common_board_td">작성자</th>
				<th style="width: 15%" class="common_board_td">등록일</th>
				<th style="width: 15%" class="common_board_td">수정일</th>
				<th style="width: 7%" class="common_board_td">추천수</th>
				<th style="width: 7%" class="common_board_td">조회수</th>
			</tr>
			<c:forEach items="${board}" var="board" varStatus="statusBoard">
				<c:choose>
				<c:when test="${statusBoard.last}">
					<tr align="center" class="common_board_end">
						<td style="width: 5%" class="common_borad_content_td">${board.idx}</td>
						<td style="width:40%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;" class="common_borad_content_td">
							<a class="commonAtag" href="">
							${board.title}
							</a>
						</td>
						<td style="width: 10%" class="common_borad_content_td">${board.writer}</td>
						<td style="width: 15%" class="common_borad_content_td">${board.create_date}</td>
						<td style="width: 15%" class="common_borad_content_td">${board.fix_date}</td>
						<td style="width: 7%" class="common_borad_content_td">${board.recommended}</td>
						<td style="width: 7%" class="common_borad_content_td">${board.lookup}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr align="center" class="common_board_content_tr">
						<td style="width: 5%" class="common_borad_content_td">${board.idx}</td>
						<td style="width:40%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;" class="common_borad_content_td">
							<a class="commonAtag" href="">
							${board.title}
							</a>
						</td>
						<td style="width: 10%" class="common_borad_content_td">${board.writer}</td>
						<td style="width: 15%" class="common_borad_content_td">${board.create_date}</td>
						<td style="width: 15%" class="common_borad_content_td">${board.fix_date}</td>
						<td style="width: 7%" class="common_borad_content_td">${board.recommended}</td>
						<td style="width: 7%" class="common_borad_content_td">${board.lookup}</td>
					</tr>
				</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<tr>
				<th colspan="7" align="center" class="common_board_td">
				<a href="?cate=${cate}&subCate=${subCate}&pageNum=1" class="commonAtag">&lt;&lt;&lt;&lt;</a>&nbsp;
				<c:forEach begin="1" end="${entirePage}" var="page" step="1">
					&nbsp;
					<c:choose>
					<c:when test="${page eq pageNumInt}">
						<a href="?cate=${cate}&subCate=${subCate}&pageNum=${page}" class="commonAtag" style="color: blue;">${page}</a>
					</c:when>
					<c:otherwise>
						<a href="?cate=${cate}&subCate=${subCate}&pageNum=${page}" class="commonAtag">${page}</a>
					</c:otherwise>
					</c:choose>
					&nbsp;				
				</c:forEach>
				&nbsp;<a href="?cate=${cate}&subCate=${subCate}&pageNum=${entirePage}" class="commonAtag">&gt;&gt;&gt;&gt;</a>	
				</th>
			</tr>
		</table>
	</div>
	<div style="height: 30px; vertical-align: center">
		<select>
			<option>번호</option>
			<option>제목</option>
			<option>작성자</option>
		</select>
		<input type="text" size="15px">
		SEARCH
		
		WRITE
	</div>
	
</form>	
</body>
</html>