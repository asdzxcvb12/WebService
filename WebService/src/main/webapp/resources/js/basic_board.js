function recommendedBtn(action, idx, board_name) {
	var currentURL = $(location).attr('search');
	var sessionIdget = $('#sessionIdget').val();
	var sendData = {'action':action,'idx':idx,'board_name':board_name};

	if(sessionIdget == '') {
		alert('you need signIn');
	} else {
		$.ajax({
			url: '/project/recommended.do',
			type: 'post',
			data: sendData,
			success: function(getData) {
				var result = JSON.parse(getData);
				alert(result.msg);
				location.href = '/project/index/board/content.do'+currentURL;
			}
		});
	}
}

function commentDelete(inx, board_name) {
	var currentURL = $(location).attr('search');
	var sendData = {'inx':inx,'board_name':board_name};
	
	$.ajax({
		url: '/project/commentDelete.do',
		type: 'post',
		data: sendData,
		success: function(result) {
			alert('delete complete');
			location.href = '/project/index/board/content.do'+currentURL;
		}
	});
}
function changeOptionName(getName) {
	var get = getName;
	var trans;
	if(getName == '제목') trans = 'title';
	else if(getName == '작성자') trans = 'writer';
	return trans;
}

function basicContent(cate, subCate, getIdx) {
	location.href = '/project/index/board/content.do?cate='+cate+'&subCate='+subCate+'&idx='+getIdx;
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
	
	var fixContent = $('#fixContent');
	var deleteContent = $('#deleteContent');
	var showItems = $('#showItems').val();
	
	if(showItems == 'yes') {
		fixContent.css({'display':'inline'});
		deleteContent.css({'display':'inline'});
	} else if(showItems == 'no') {
		fixContent.css('display', 'none');
		deleteContent.css('display', 'none');
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
	
	$('#commentInsert').on('click', function() {
		var sessionNickget = $('#sessionNickget').val();
		var commentText = $('#commentText').val();
		
		if(sessionNickget == '' || commentText.length < 1) {
			alert('check form or signIn plz');
		} else {
			var currentURL = $(location).attr('search');
			var getIDX = $('#getIDX').text();
			var getBoName = $('#getBoName').val();
			var sendData = {'boardName':getBoName,'getIDX':getIDX,'commentText':commentText};
			$.ajax({
				url: '/project/commentInsert.do',
				type: 'post',
				data: sendData,
				success: function(getData) {
					alert('Done');
					location.href = '/project/index/board/content.do'+currentURL;
				}
			});
		}
	});
	
	$('#imgFormSubmit').on('click', function() {
		var inserForm = $('#inserForm');
		var imgCate = $('#imgCate').val();
		var imgSubCate = $('#imgSubCate').val();
		var imgSession = $('#imgSession').val();
		
		if(imgSession == '') {
			alert('you need signIn');
		} else {
			inserForm.submit();
		}
	});
	
	$('#deleteCon').on('click', function() {
		var deleteForm = $('#deleteForm');
		deleteForm.submit();
	});
});