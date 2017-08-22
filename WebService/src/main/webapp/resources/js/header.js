function wrapWindowByMask(){
        // 화면의 높이와 너비를 변수로 만듭니다.
        var maskHeight = $(document).height();
        var maskWidth = $(window).width();
 
        // 마스크의 높이와 너비를 화면의 높이와 너비 변수로 설정합니다.
        $('.mask').css({'width':maskWidth,'height':maskHeight});
 
        // fade 애니메이션 : 1초 동안 검게 됐다가 80%의 불투명으로 변합니다.
        $('.mask').fadeIn(1000);
        $('.mask').fadeTo("slow",0.6);
 
        // 레이어 팝업을 가운데로 띄우기 위해 화면의 높이와 너비의 가운데 값과 스크롤 값을 더하여 변수로 만듭니다.
        var left = ( $(window).scrollLeft() + ( $(window).width() - $('.window').width()) / 2 );
        var top = ( $(window).scrollTop() + ( $(window).height() - $('.window').height()) / 2 );
 
        // css 스타일을 변경합니다.
        $('.window').css({'left':left,'top':top, 'position':'absolute'});
 
        // 레이어 팝업을 띄웁니다.
        $('.window').show();
    }
 
    $(document).ready(function(){
        // showMask를 클릭시 작동하며 검은 마스크 배경과 레이어 팝업을 띄웁니다.
        $('.showMask').click(function(e){
            // preventDefault는 href의 링크 기본 행동을 막는 기능입니다.
            e.preventDefault();
            wrapWindowByMask();
        });
 
        // 닫기(close)를 눌렀을 때 작동합니다.
        $('.window .close').click(function (e) {
            e.preventDefault();
            $('.mask, .window').hide();
        });
 
        // 뒤 검은 마스크를 클릭시에도 모두 제거하도록 처리합니다.
        $('.mask').click(function () {
            $(this).hide();
            $('.window').hide();
        });
 
        //SIGN IN BUTTON
        $('#signInBtn').on('click', function() {
        	
        	var sendData = {'rsa':'rsa'};
        	var a = $('#a');
        	var b = $('#b');
        	$.ajax({
        		url: 'createRSAkey',
        		type: 'post',
        		data: sendData,
        		success: function(getData){
        			var result = JSON.parse(getData);
        			a.val(result.a);
        			b.val(result.b);
        		}
        	});
        });
 
 //LOGIN BUTTON       
        $('#logBtn').on('click', function() {
        	var logFormTag = $('#logFormTag');
        	
        	var logId = $('#logId');
        	var logPassword = $('#logPassword');
        	var logEncriptId = $('#logEncriptId');
        	var logEncriptPw = $('#logEncriptPw');
        	
        	var RSAModulus = $('#a');
        	var RSAExponent = $('#b');
        	
        	var hangle = logId.val().search(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g);
    		var spe = logId.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
    		var ws = logId.val().search(/\s/);
    		var sws = logPassword.val().search(/\s/);
    		
        	if(logId.val().length < 7 || logPassword.val().length < 10 || 
        			hangle >= 0 || spe >= 0 || ws >= 0 || sws >= 0) {
        			alert('Please check your id / password');
        	} else {
        		var rsa = new RSAKey();
        		rsa.setPublic(RSAModulus.val(), RSAExponent.val());
			
        		logEncriptId.val(rsa.encrypt(logId.val()));
        		logEncriptPw.val(rsa.encrypt(logPassword.val()));	
			
        		logId.val('');
        		logPassword.val('');
			
        		logFormTag.submit();
        	}
        });
    });