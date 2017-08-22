// select box combine
function combin_selectBox() {
	var result = '';
	
	$("input[name=upFavorite]:checked").each(function() {
		result += ($(this).val()+',');
	});
	$("input[name=downFavorite]:checked").each(function() {
		result += ($(this).val()+',');
	});
	
	$('#languageList').val(result);
}


//onload action
$(document).ready(function() {
	/* effectiveness test id */
	$('#membershipID').on('keyup', function() {
		var id = $(this).val();
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
	});
	
	/* id check */
	$('#idChk').on('click', function() {
		var id = $('#membershipID');
		var effectID = $('#effectID');
		var idInvisibility = $('#idInvisibility');
		
		var sendIdCheck = {"id":id.val()};
		
		if(effectID.html() != 'check') {
			alert('Please check your id');
		} else {
			$.ajax({
				url: 'checkId',
				type: 'post',
				data: sendIdCheck,
				success: function(getData) {
					var result = JSON.parse(getData);
					if(result.id == 'true') {
						id.attr('disabled', 'disabled');
						effectID.html('confirm');
						idInvisibility.css('display', 'inline');
						alert('you can use this id');
					} else {
						id.val('');
						alert('you can`t use this id');
					}
				}
			});
		}
	});
	
	/* change id */
	$('#idCge').on('click', function() {
		var id = $('#membershipID');
		var effectID = $('#effectID');
		var idInvisibility = $('#idInvisibility');
		
		id.removeAttr('disabled');
		idInvisibility.css('display','none');
		id.val('');
		effectID.html('');
	});
	
	/* effectiveness test pw */
	$('#membershipPW').on('keyup', function() {
		var pw = $(this).val();
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
	});
	
	/* chk pw */
	$('#chkMemberPW').on('keyup', function() {
		var obj = $(this).val();
		var membershipPW = $('#membershipPW').val();
		var chkPW = $('#chkPW');
		
		if(membershipPW == obj) {
			chkPW.html('check'); 
			if(obj == '') chkPW.html('');
		} else {
			chkPW.html('fail');
			if(obj == '') chkPW.html('');
		}
	});
	
	/* effectiveness test nickname */
	$('#membership_NickName').on('keyup', function() {
		var nickname = $(this).val();
		var effectNN = $('#effectNN');
		
		var spe = nickname.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		var ws = nickname.search(/\s/);
		
		if(nickname.length <= 3) effectNN.html('Please enter at least 3 charactors.');
		else if(spe >= 0 || ws >= 0) effectNN.html('Please not special characters and include white space.');
		else effectNN.html('check');
		
		if(nickname == '') effectID.html('');
		
	});
	
	/* nickname check */
	$('#nicknameChk').on('click', function() {
		var nickname = $('#membership_NickName');
		var effectNN = $('#effectNN');
		var nicknameInvisibility = $('#nicknameInvisibility');
		
		var sendNickNameCheck = {"nickname":nickname.val()};
		
		if(effectNN.html() != 'check') {
			alert('Please check your nickname');
		} else {
			$.ajax({
				url: 'checkNickName',
				type: 'post',
				data: sendNickNameCheck,
				success: function(getData) {
					var result = JSON.parse(getData);
					if(result.nickname == 'true') {
						nickname.attr('disabled', 'disabled');
						effectNN.html('confirm');
						nicknameInvisibility.css('display', 'inline');
						alert('you can use this nickname');
					} else {
						nickname.val('');
						alert('you can`t use this nickname');
					}
				}
			});
		}
	});
	
	/*change nickname*/
	$('#nicknameCge').on('click', function() {
		var nickname = $('#membership_NickName');
		var effectNN = $('#effectNN');
		var nicknameInvisibility = $('#nicknameInvisibility');
		
		nickname.removeAttr('disabled');
		nicknameInvisibility.css('display','none');
		nickname.val('');
		effectNN.html('');
	});
	
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
	
	//test
	$('#infoCancle').on('click', function() {
		history.back(-2);
		alert('cancle');
	});
	
	/* membershipResult form tag */
	$('#infoNext').on('click', function() {
		var effectID = $('#effectID');
		var chkingPW = $('#chkingPW');
		var chkPW = $('#chkPW');
		var effectNN = $('#effectNN');
		var postcode = $('#postcode');
		
		
		var membershipResult = $('#membershipResult');
		var membershipID = $('#membershipID');
		var membership_ID = $('#membership_ID');
		var membershipPW = $('#membershipPW');
		var membership_PW = $('#membership_PW');
		var membership_NickName = $('#membership_NickName');
		var membership_NICK = $('#membership_NICK');
		var setEmail = $('#setEmail');
		var membership_EMAIL = $('#membership_EMAIL');
		var postcode = $('#postcode');
		var membership_POSTCODE = $('#membership_POSTCODE');
		var roadAddress = $('#roadAddress');
		var membership_ROADADDRESS = $('#membership_ROADADDRESS');
		var jibunAddress = $('#jibunAddress');
		var membership_JIBUNADDRESS = $('#membership_JIBUNADDRESS');
		var detailAddress = $('#detailAddress');
		var membership_DETAILADDRESS = $('#membership_DETAILADDRESS');
		var languageList = $('#languageList');
		
		var RSAModulus = $('#RSAModulus');
		var RSAExponent = $('#RSAExponent');
		
		if(effectID.html() != 'confirm' || chkingPW.html() != 'check' || chkPW.html() != 'check' || 
				effectNN.html() != 'confirm' || postcode.val() == ''){
			alert('check your document');
		} else {
			var rsa = new RSAKey();
			rsa.setPublic(RSAModulus.val(), RSAExponent.val());
			
			membership_ID.val(rsa.encrypt(membershipID.val()));
			membership_PW.val(rsa.encrypt(membershipPW.val()));	
			membership_NICK.val(membership_NickName.val());
			membership_EMAIL.val(setEmail.val());
			membership_POSTCODE.val(postcode.val());
			membership_ROADADDRESS.val(roadAddress.val());
			membership_JIBUNADDRESS.val(jibunAddress.val());
			membership_DETAILADDRESS.val(detailAddress.val());
			combin_selectBox();
			
			membershipID.val("");
			membershipPW.val("");
			
			membershipResult.submit();
		}
	});
});

