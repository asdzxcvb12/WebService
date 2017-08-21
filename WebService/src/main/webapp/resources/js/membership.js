//Email Visibility
function inputEmailVisibility() {
	if($('[name="chkTermsOne"]:checked').val() == 'agree' && $('[name="chkTermsTwo"]:checked').val() == 'agree'){
		$('#inputEmail').css('display','inline');
	} else {
		$('#inputEmail').css('display','none');
	}
}

//onload action
$(document).ready(function() {
	
	//checkBox action
	$('input[type="checkbox"][name="chkTermsOne"]').click(function(){
        if ($(this).prop('checked')) {
            $('input[type="checkbox"][name="chkTermsOne"]').prop('checked', false);
            $(this).prop('checked', true);
            inputEmailVisibility();
        }
	});
	
	$('input[type="checkbox"][name="chkTermsTwo"]').click(function(){
        if ($(this).prop('checked')) {
            $('input[type="checkbox"][name="chkTermsTwo"]').prop('checked', false);
            $(this).prop('checked', true);
            inputEmailVisibility();
        }
	});
	
	//option change
	$('#emailBack').change(function() {
		
		$("#emailBack option:selected").each(function(){ 
			var backEmail = $('#backEmail');
			backEmail.val($(this).val());
			
			if($(this).val() == 'self') {
				backEmail.val('');
				backEmail.removeAttr('disabled');
			} else backEmail.attr('disabled', 'disabled');
	    });  
	});
	
	//sendEmail
	$('#sendE_mail').click(function() {
		var frontEmail = $('#frontEmail').val();
		var backEmail = $('#backEmail').val();

		var email = frontEmail + '@' + backEmail;
		
		var sendData = {"email":email};
		
		$.ajax({
			url: 'SendMail',
			type: 'post',
			data: sendData,
			success: function(setValues) {
				var result = JSON.parse(setValues);
				var sendCode = $('#getCode');
				
				if(result.code != 'null' && result.result == 'success'){
					sendCode.val(result.code);
					$('#insertCode').removeAttr('disabled');
					alert('Please enter the code');
				} else 	alert('Send Email fail...\nPlease check your E-mail');
			}
		});
	});
	
	//check code
	$('#insertCode').keyup(function() {
		if($(this).val() == $('#getCode').val()) {
			$('#cancle_next').css('display','inline');
			$(this).attr('disabled', 'disabled');
			$('#checkCodeMsg').html('Correct Code');
		} else $('#checkCodeMsg').html('Incorrect Code');
	});
});