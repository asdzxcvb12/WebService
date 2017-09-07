<%@ page language="java" contentType="text/html; charset=utf-8;" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<div align="center" style="width: 100%">
		<table style="width: auto">
			<tr align="center" style="margin-bottom: 10px; border-bottom: 3px dotted #444444; ">
				<td colspan="3"><Strong style="font-size: 20px; margin-bottom: 20px;">-&nbsp;${subCate}&nbsp;-</Strong></td>
			</tr>
			
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="center">Number</td>
				<td>::</td>
				<td align="right"><span id="getIDX">${contentBoard.get(1).getIdx()}</span></td>
			</tr>
			<tr>
				<td align="center">LookUp</td>
				<td>::</td>
				<td align="right">${contentBoard.get(1).getLookup()}</td>
			</tr>
			<tr>
				<td align="center">Recommended</td>
				<td>::</td>
				<td align="right">${contentBoard.get(1).getRecommended()}</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
				<a class="commonAtag" onclick="recommendedBtn('up', '${contentBoard.get(1).getIdx()}', '${boardName}')">&lt; Up &gt;</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="commonAtag" onclick="recommendedBtn('down', '${contentBoard.get(1).getIdx()}', '${boardName}')">&lt; Down &gt;</a>
				</td>
			</tr>
			<tr><td colspan="3"><br></td></tr>
			<tr>
				<td align="center">Title</td>
				<td>::</td>
				<td align="center"><Strong>${contentBoard.get(1).getTitle()}</Strong></td>
			</tr>
			<tr>
				<td align="center">Writer</td>
				<td>::</td>
				<td align="center">
					${contentBoard.get(1).getWriter()}
				</td>
			</tr>
			<tr>
				<td align="center">Create Date</td>
				<td>::</td>
				<td align="right">
					${contentBoard.get(1).getCreate_date()}
				</td>
			</tr>
			<tr>
				<td align="center">Fix Date</td>
				<td>::</td>
				<td align="right">
					${contentBoard.get(1).getFix_date()}
				</td>
			</tr>
			<tr><td colspan="3"><hr></td></tr>
			<tr>
				<td align="center">Content</td>
				<td>::</td>
				<td>
					${contentBoard.get(1).getContent()}
				</td>
			</tr>
			<tr><td colspan="3"><hr></td></tr>
			<tr>
				<td>Next</td>
				<td>::</td>
				<td>
					<c:choose>
						<c:when test="${contentBoard.get(2) == null}">
							none
						</c:when>
						<c:otherwise>
							<a class="commonAtag" style="text-decoration: underline;" onClick="basicContent('${cate}', '${subCate}', ${contentBoard.get(2).getIdx()})">
								${contentBoard.get(2).getIdx()}.&nbsp;
								${contentBoard.get(2).getTitle()}
							</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>Prev</td>
				<td>::</td>
				<td>
					<c:choose>
						<c:when test="${contentBoard.get(0) == null}">
							none
						</c:when>
						<c:otherwise>
							<a class="commonAtag" style="text-decoration: underline;" onClick="basicContent('${cate}', '${subCate}', ${contentBoard.get(0).getIdx()})">
								${contentBoard.get(0).getIdx()}.&nbsp;
								${contentBoard.get(0).getTitle()}
							</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			
			<tr><td colspan="3"><hr></td></tr>
			
			<tr>
				<td>Comment</td>
				<td>::</td>
				<td><input type="text" id="commentText" size="50px">&nbsp;&nbsp;
				<a class="commonAtag" id="commentInsert">submit</a></td>
			</tr>
			<tr><td colspan="3"><br></td></tr>
			<c:choose>
				<c:when test="${comment.size() == 0}">
					<tr>
						<td colspan="3" align="center">No Comment</td>					
					</tr>
				</c:when>
				<c:when test="${comment != null}">
					<c:forEach items="${comment}" var="comment" varStatus="commentStatus">
						<tr>
							<td>${commentStatus.count}.&nbsp;&nbsp;${comment.getNickname()}</td>
							<td>::</td>
							<td>${comment.getCon_comment()}</td>
						</tr>
						<c:if test="${sessionScope.signId == comment.getId()}">
						<tr align="right">
								<td colspan="3" style="font-size: 10px;">
								<a class="commonAtag" onclick="commentDelete('${comment.getInx()}', '${comment.getBoard_name()}')">| delete |</a></td>
						</tr>
						</c:if>
					</c:forEach>
				</c:when>
			</c:choose>
			<tr><td colspan="3"><hr></td></tr>
			<tr>	
				<td colspan="3" id="fixContent" style="display: none;">
				<a class="commonAtag">Fix Content</a></td>
			</tr>
			<tr> 	
				<td colspan="3" id="deleteContent" style="display: none;">
				<form id="deleteForm" action="/project/deleteBoardContent.do" method="post">
					<input type="hidden" id="getBoardCate" name="cate" value="${cate}">
					<input type="hidden" id="getBoardSubCate" name="subCate" value="${subCate}">
					<input type="hidden" id="getBoName" name="getBoName" value="${boardName}">
					<input type="hidden" id="idxDel" name="idxDel" value="${contentBoard.get(1).getIdx()}">
					<a class="commonAtag" id="deleteCon">Delete Content</a>
				</form>
				</td>
			</tr>
			<tr align="right">
				<td colspan="3">
					<a id="boardWriteCancle" class="commonAtag" style="margin-right: 20px;">Back</a>
					<input type="hidden" id="resultContent" name="resultContent">
					<input type="hidden" id="sessionNickget" value="${sessionScope.signNick}">
					<input type="hidden" id="sessionIdget" value="${sessionScope.signId}">
					<c:choose>
						<c:when test="${sessionScope.signNick == contentBoard.get(1).getWriter()}">
							<input type="hidden" id="showItems" value="yes">
						</c:when>
						<c:otherwise>
							<input type="hidden" id="showItems" value="no">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>