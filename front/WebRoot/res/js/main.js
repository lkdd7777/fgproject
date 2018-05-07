$.extend({
	checkDate:function(date){
		var DATE_FORMAT = /^[0-9]{4}-[0-1]?[0-9]{1}-[0-3]?[0-9]{1}$/;
		if(DATE_FORMAT.test(date)){
			return true;
		} else {
			alert("抱歉，您输入的日期格式有误，正确格式应为'2014-01-01'.");
			return false;
		}
	},
	
	checkNum:function(num){
		var NUM_FORMAT = new RegExp("^[0-9]*$");
		if(NUM_FORMAT.test(num)){
			return true;
		}else{
			alert("抱歉，您输入的数字格式有误，请输入数字");
			return false;
		}
	}
});