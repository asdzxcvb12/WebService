
function changeOptionName(getName) {
	var get = getName;
	var trans;
	if(getName == '제목') trans = 'title';
	else if(getName == '작성자') trans = 'writer';
	return trans;
}

function basicContent(getIdx) {
	var cateName = $('#cateName').val();
	var basicBoardName = $('#basicBoardName').val();
	
	location.href = 'index/board/content.do?cate='+cateName+'&subCate='+basicBoardName+'&idx='+getIdx;
}
$(document).ready(function() {
	
	var getLocationUrl = $(location).attr('search');
	var urlBlockSession = $('#getSessionResult').val();
	if(getLocationUrl.indexOf('boardKind=write') != -1 && getLocationUrl.indexOf('subCate=') != -1 && getLocationUrl.indexOf('cate=') != -1) {
		if(urlBlockSession == 'null') {
			history.back();
			alert('wrong path\nsign up Please');
		}
	}
	
	$('#basicBoardSearch').on('click', function() {
		var cateName = $('#cateName').val();
		var basicBoardName = $('#basicBoardName').val();
		var selectOption = $('#selectOption').val();
		var searchContent = $('#searchContent').val();
		
		var getName = changeOptionName(selectOption);
		
		location.href = "index.do?cate="+cateName+"&subCate"+basicBoardName+"&searchOption="+getName+"&search="+searchContent;
	});
	
	$('#basicBoardWrite').on('click', function() {
		$('#boardWriteForm').submit();
	});
	
});