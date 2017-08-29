
function changeOptionName(getName) {
	var get = getName;
	var trans;
	if(getName == '제목') trans = 'title';
	else if(getName == '작성자') trans = 'writer';
	return trans;
}

function basicContent(getIdx) {
	var basicBoardName = $('#basicBoardName').val();
	var sendData = {'idx':getIdx,'board':basicBoardName};
	$.ajax({
		url: 'authorityBoard',
		data: sendData
	});
		
	alert(getIdx+"\n"+basicBoardName);
}
$(document).ready(function() {
	$('#basicBoardSearch').on('click', function() {
		var basicBoardName = $('#basicBoardName').val();
		var cateName = $('#cateName').val();
		var selectOption = $('#selectOption').val();
		var searchContent = $('#searchContent').val();
		
		var getName = changeOptionName(selectOption);
		
		location.href = "?cate="+cateName+"&subCate="+basicBoardName+"&searchOption="+getName+"&search="+searchContent;
	});
	
});