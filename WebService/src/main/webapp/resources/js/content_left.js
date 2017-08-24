function go_time() {

	var now = new Date();

	var year = now.getFullYear(); // 년
	var month = now.getMonth()+1; // 월
	var date = now.getDate(); // 일
	var day = now.getDay(); // 요일
	var hour = now.getHours(); // 시
	var min = now.getMinutes(); // 분
	var sec = now.getSeconds(); // 초
	var am_pm;
	
	if(hour > 12) {
		am_pm = 'PM';
		hour = hour - 12;
		if(hour < 10) hour = '0'+hour;
	} else if(hour < 12) {
		am_pm = 'AM';
		if(hour < 10) hour = '0'+hour;
	}
	
	if(min < 10) min = '0' + min;
	if(sec < 10) sec = '0' + sec;

	$('#ymd').html(year + "年 " + month + "月 " + date + "日 " + getTransDay(day));
	$('#time').html(am_pm + "  " + hour + ":" + min + ":" + sec);

	setTimeout("go_time()", 1000);
}

function getTransDay(day) {
	if(day == 0) return 'Sun'
	if(day == 1) return 'Mon'
	if(day == 2) return 'Tue'
	if(day == 3) return 'Wed'
	if(day == 4) return 'Thu'
	if(day == 5) return 'Fri'
	if(day == 6) return 'Sat'
}

function backBtn() {
	var calTable = $('#Calendar');
	var calCount = $('#calCount').val();
	var calCountYear = $('#calCountYear').val();
	var minusYear = calCountYear;
	
	var minus = parseInt(calCount)-1;
	if(minus == 0) {
		minusYear = parseInt(minusYear) - 1;
		minus = 12;
	}
	calTable.empty();
	setCalendarTable(minusYear,minus);
	$('#calCount').val(minus);
	$('#calCountYear').val(minusYear);
}
function goBtn() {
	var calTable = $('#Calendar');
	var calCount = $('#calCount').val();
	var calCountYear = $('#calCountYear').val();
	var plusYear = calCountYear;
	
	var plus = parseInt(calCount)+1;
	if(plus == 13) {
		plusYear = parseInt(plusYear) + 1;
		plus = 1;
	}
	calTable.empty();
	setCalendarTable(plusYear, plus);
	$('#calCount').val(plus);
	$('#calCountYear').val(plusYear);		
}

function setCalendarTable(y, m) {
	var calTable = $('#Calendar');
	var day = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
	var endDate = [31,28,31,30,31,30,31,31,30,31,30,31];
	
	var now = new Date();
    var year = now.getFullYear(); 
    var month = now.getMonth() + 1; 
    var date = now.getDate();
    
    var y = (y != null) ?y :year;
    var m = (m != null) ?m :month;

    if(y%4 == 0 && y%400 == 0 || y%100 != 0) endDate[1]=29;
    
	var monthFirstDay = new Date(y,m-1,1);
	var firDay = monthFirstDay.getDay();
	
	var pastLastDate = endDate[m-1];
	var lastDay = pastLastDate - firDay + 1;
	
	var space = firDay;
	var start = 1;
	var spaceStart = 1;
	
	calTable.append('<tr><td colspan=7 align=center><strong id=backBtn class=commonAtag onclick=backBtn()>&lt;&lt;&lt;&lt;</strong>&nbsp;&nbsp;&nbsp;'+y+'年&nbsp;&nbsp;'+m+
			'月&nbsp;&nbsp;&nbsp;<strong id=goBtn class=commonAtag onclick=goBtn()>&gt;&gt;&gt;&gt;</strong></td></tr><tr>');
	for(var i=0; i<7; i++) calTable.append('<td align=center>'+day[i]+'</td>');
	calTable.append('</tr>');
	
	for(var i=0; i<6; i++) {
		calTable.append('<tr>');
		for(var j=0; j<7; j++) {
			if(space > 0) {
				calTable.append('<td class=passDay align=center>' + lastDay + '</td>');
				space -= 1;
				lastDay += 1;
			} else if(start <= pastLastDate) {
				var present = new Date(y,m-1,start);
				if(present.getDay() == 0) {
					if(start == date) calTable.append('<td class=presentRedDay align=center style=\"fonttext-decoration: underline;\">' + start + '</td>');
					else calTable.append('<td class=presentRedDay align=center>' + start + '</td>');
				} else if(present.getDay() == 6) {
					if(start == date) calTable.append('<td class=presentBlueDay align=center style=\"fonttext-decoration: underline;\">' + start + '</td>');
					else calTable.append('<td class=presentBlueDay align=center>' + start + '</td>');
				} else {
					if(start == date) calTable.append('<td class=presentWhiteDay align=center style=\"fonttext-decoration: underline;\">' + start + '</td>');
					else calTable.append('<td class=presentWhiteDay align=center>' + start + '</td>');
				}
				start += 1;
			} else {
				calTable.append('<td class=passDay align=center>' + spaceStart + '</td>');
				spaceStart += 1;
			}
		}
		calTable.append('</tr>');
	}
}

//CALENDAR TEST
$(document).ready(function() {
	var now = new Date();
    var year = now.getFullYear(); 
    var month = now.getMonth() + 1;
    
    $('#calCountYear').val(year);
    $('#calCount').val(month);
	
	setCalendarTable(null,null);
});