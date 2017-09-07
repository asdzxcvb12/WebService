<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

	<div align="center" style="width: 100%;">
	<Strong style="font-size: 25px;">-&nbsp;${subCate}&nbsp;-</Strong>
		<table style="width: 100%;" id="common_board">
			<tr align="center" class="common_board_tr">
				<th style="width: 5%" class="common_board_td">번호</th>
				<th style="width: 40%" class="common_board_td">제목</th>
				<th style="width: 20%" class="common_board_td">작성자</th>
				<th style="width: 10%" class="common_board_td">등록일</th>
				<th style="width: 10%" class="common_board_td">수정일</th>
				<th style="width: 7%" class="common_board_td">추천수</th>
				<th style="width: 7%" class="common_board_td">조회수</th>
			</tr>
			<c:forEach items="${board}" var="board" varStatus="statusBoard">
				<c:choose>
				<c:when test="${statusBoard.last}">
					<tr align="center" class="common_board_end">
						<td id="getBasicContentIdx" style="width: 5%" class="common_borad_content_td">${board.idx}</td>
						<td style="width:40%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;" class="common_borad_content_td">
							<a id="getBasicContent" class="commonAtag" onClick="basicContent('${cate}', '${subCate}', ${board.idx})">
							${board.title}
							</a>
						</td>
						<td style="width: 20%" class="common_borad_content_td">${board.writer}</td>
						<td style="width: 10%" class="common_borad_content_td">${board.create_date}</td>
						<td style="width: 10%" class="common_borad_content_td">${board.fix_date}</td>
						<td style="width: 7%" class="common_borad_content_td">${board.recommended}</td>
						<td style="width: 7%" class="common_borad_content_td">${board.lookup}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr align="center" class="common_board_content_tr">
						<td id="getBasicContentIdx" style="width: 5%" class="common_borad_content_td">${board.idx}</td>
						<td style="width:40%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;" class="common_borad_content_td">
							<a id="getBasicContent" class="commonAtag" onClick="basicContent('${cate}', '${subCate}', ${board.idx})">
							${board.title}
							</a>
						</td>
						<td style="width: 20%" class="common_borad_content_td">${board.writer}</td>
						<td style="width: 10%" class="common_borad_content_td">${board.create_date}</td>
						<td style="width: 10%" class="common_borad_content_td">${board.fix_date}</td>
						<td style="width: 7%" class="common_borad_content_td">${board.recommended}</td>
						<td style="width: 7%" class="common_borad_content_td">${board.lookup}</td>
					</tr>
				</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<tr>
				<th colspan="7" align="center" class="common_board_td">
				<c:choose>
					<c:when test="${searchOption ne null}">
						<a href="?cate=${cate}&subCate=${subCate}&pageNum=1&searchOption=${searchOption}&search=${search}" class="commonAtag">&lt;&lt;&lt;&lt;</a>
					</c:when>
					<c:otherwise>
						<a href="?cate=${cate}&subCate=${subCate}&pageNum=1" class="commonAtag">&lt;&lt;&lt;&lt;</a>
					</c:otherwise>
				</c:choose>
					&nbsp;
				<c:forEach begin="1" end="${entirePage}" var="page" step="1">
					&nbsp;
					<c:choose>
					<c:when test="${page eq pageNumInt}">
						<c:choose>
							<c:when test="${searchOption ne null}">
								<a href="?cate=${cate}&subCate=${subCate}&pageNum=${page}&searchOption=${searchOption}&search=${search}" class="commonAtag" style="color: blue;">${page}</a>
							</c:when>
							<c:otherwise>
								<a href="?cate=${cate}&subCate=${subCate}&pageNum=${page}" class="commonAtag" style="color: blue;">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${searchOption ne null}">
								<a href="?cate=${cate}&subCate=${subCate}&pageNum=${page}&searchOption=${searchOption}&search=${search}" class="commonAtag">${page}</a>
							</c:when>
							<c:otherwise>
								<a href="?cate=${cate}&subCate=${subCate}&pageNum=${page}" class="commonAtag">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
					</c:choose>
					&nbsp;				
				</c:forEach>
				&nbsp;
				<c:choose>
					<c:when test="${searchOption ne null}">
						<a href="?cate=${cate}&subCate=${subCate}&pageNum=${entirePage}&searchOption=${searchOption}&search=${search}" class="commonAtag">&gt;&gt;&gt;&gt;</a>
					</c:when>
					<c:otherwise>
						<a href="?cate=${cate}&subCate=${subCate}&pageNum=${entirePage}" class="commonAtag">&gt;&gt;&gt;&gt;</a>
					</c:otherwise>
				</c:choose>
				
				</th>
			</tr>
		</table>
	</div>
<form id="boardWriteForm" action="index/board/write.do" method="post">
	<div style="height: 30px; vertical-align: center" align="right">
		<select id="selectOption">
			<option>제목</option>
			<option>작성자</option>
		</select>
		<input id="searchContent"type="text" size="15px">
			<a id="basicBoardSearch" class="commonAtag" style="margin-right:20px;">SEARCH</a>
			<a id="basicBoardWrite" class="commonAtag" style="margin-right:5px;">WRITE</a>
			<input type="hidden" id="basicBoardName" name="subCate" value="${subCate}">
			<input type="hidden" id="cateName" name="cate" value="${cate}">
	</div>
</form>	
</body>
</html>