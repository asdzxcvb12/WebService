function showHTML() {
	oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	var sHTML = oEditors.getById["ir1"].getIR();
	
	var writeForm = $('#writeForm');
	var getBoardCate = $('#getBoardCate').val();
	var getBoardSubCate = $('#getBoardSubCate').val();
	
	var resultContent = $('#resultContent');
	
	resultContent.val(sHTML);
	resultContent = resultContent.val();
	
	var titleTextBox = $('#titleTextBox').val();
	
	if(resultContent.length > 0 && titleTextBox.length > 0) {
		writeForm.attr('action', '/project/index/board/write/result.do');
		writeForm.attr('method', 'post');
		writeForm.submit();
	} else alert('Please check your document\n'+resultContent+'\n'+titleTextBox+'\n'+ir1);
}

function submitContents(elClickedObj) {
		// 에디터의 내용이 textarea에 적용됩니다.
	
	// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
	
	try {
		elClickedObj.form.submit();
	} catch(e) {}
}


$(document).ready(function() {
	$('#boardWriteCancle').on('click', function() {
		history.back();
	});
});

