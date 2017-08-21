/* effectiveness test id */
function effectID(id) {
	var effectID = $('#effectID');
	
	var hangle = id.search(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g);
	var spe = id.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	var ws = id.search(/\s/);
	
	/*//좌우 방향키, 백스페이스, 딜리트, 탭키 제외
    if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39
    || event.keyCode == 46 ) return;
    */
	
    if(id.length < 7) effectID.html('Please enter at least 7 charactors.');
    else if(hangle >= 0 || spe >= 0 || ws >= 0) effectID.html('Please not include hangle, special characters and white space.');
    else effectID.html('check');
    
    if(id == '') effectID.html('');
}

/* effectiveness test pw */
function effectPW(pw) {
	var effectPW = $('#effectPW');
	var chkingPW = $('#chkingPW');
	var chkMemberPW = $('#chkMemberPW');
	
	var num = pw.search(/[0-9]/g);
	var eng = pw.search(/[a-z]/ig);
	var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	console.log(num);
	console.log(eng);
	console.log(spe);
	
	if(pw.length < 8) {
		effectPW.html('Please enter at least 8 charactors.');
		chkMemberPW.attr('disabled', 'disabled');
	} else if(pw.search(/\s/) != -1) {
		effectPW.html('Please not include white space');
		chkMemberPW.attr('disabled', 'disabled');
	} else if(num < 0 || eng < 0 || spe < 0) {
		effectPW.html('Please include that one or more alphabets, numbers, and special characters.');
		chkMemberPW.attr('disabled', 'disabled');
	} else {
		effectPW.html('complete check!.. good boy');
		chkingPW.html('check');
		chkMemberPW.removeAttr('disabled');	
	}
	
	if(pw == '') {
		effectPW.html('');
		chkingPW.html('');
		chkMemberPW.attr('disabled', 'disabled');
	}
}

/* chk pw */
function chkPW(obj) {
	var membershipPW = $('#membershipPW').val();
	var chkPW = $('#chkPW');
	
	console.log('checking....');
	console.log(membershipPW);
	console.log(obj);
	
	if(membershipPW == obj) {
		chkPW.html('check'); 
		if(obj == '') chkPW.html('');
	} else {
		chkPW.html('fail');
		if(obj == '') chkPW.html('');
	}
}

//onload action
$(document).ready(function() {
	/* address action */
	$('#address').on('click', function() {
        new daum.Postcode({
            oncomplete: function(data) {

                var fullRoadAddr = data.roadAddress;
                var extraRoadAddr = '';

                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }

                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
                
                $('#postcode').val(data.zonecode);
                $('#roadAddress').val(fullRoadAddr);
                $('#jibunAddress').val(data.jibunAddress);

                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    $('#guide').html('(예상 도로명 주소 : ' + expRoadAddr + ')');
                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    $('#guide').html('(예상 지번 주소 : ' + expJibunAddr + ')');
                } else {
                	$('#guide').html('');
                }
            }
        }).open();
	});
});

