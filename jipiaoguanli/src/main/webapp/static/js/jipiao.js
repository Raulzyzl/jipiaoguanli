/**
 * 
 */
//获取所有机票信息
function getalljipiao() {
	$.ajax({
		type : "POST", //用POST方式传输  
		dataType : "json", //数据格式:JSON  
		url : 'getalljipiao.do', //目标地址  
		scriptCharset : 'utf-8',
		async : true,
		success : function(data) {
			$.each(data, function(idx, element) {
				console.log("------>" + JSON.stringify(element));
			});
		},
		error : function() {
		},

	});
}

//根据出发地、到达地或是出发时间或是三者都有来搜索出符合条件的机票
function findjipiao1() {
	chufadi = $("#chufadi").val();
	daodadi = $("#daodadi").val();
	chufariqi = $("#chufariqi").val();
	$.ajax({
		type : "POST", //用POST方式传输  
		dataType : "json", //数据格式:JSON  
		url : 'findjipiao.do', //目标地址  
		scriptCharset : 'utf-8',
		data : {
			chufadi : chufadi,
			daodadi : daodadi,
			chufariqi : chufariqi,
		},
		async : true,
		success : function(data) {
			$.each(data, function(idx, element) {
				console.log("------>" + JSON.stringify(element));
			});
		},
		error : function() {
		},

	});
}