/**
 * 
 */
//登陆
function loginuser() {
	$.ajax({
		type : "POST", //用POST方式传输  
		dataType : "json", //数据格式:JSON  
		url : 'login.do', //目标地址  
		scriptCharset : 'utf-8',
		async : true,
		data : {
			username : $("#userAccount").val(),
			password : $("#password1").val(),
		},
		success : function(data) {
			$.each(data, function(idx, element) {
				console.log("------>" + element);
			});
		},
		error : function() {
			alert("获取信息失败！");
		},

	});
}

//注册
function register() {
	useraccount = $("#useraccount").val();
	useridcare = $("#useridcare").val();
	username = $("#username").val();
	password = $("#password").val();
	sex = $("#sex").val();
	phone = $("#phone").val();
	if (username.length <= 0) {
		alert("账号不能为空！");
	} else if (password.length <= 0) {
		alert("密码不能为空");
	} else if (useraccount.length <= 0) {
		alert("姓名不能为空！");
	} else if (useridcare.length <= 0) {
		alert("身份证不能为空");
	} else if (sex.length <= 0) {
		alert("需选择性别");
	} else if (phone.length <= 0) {
		alert("电话号码不能为空");
	} else {
		$.ajax({
			type : "POST", //用POST方式传输  
			dataType : "json", //数据格式:JSON  
			url : 'register.do', //目标地址  
			scriptCharset : 'utf-8',
			data : {
				username : username,
				useraccount : useraccount,
				password : password,
				sex : sex,
				useridcare : useridcare,
				phone : phone,
			},
			async : true,
			success : function(data) {
				console.log(data);
			},
			error : function(e) {
				console.log(e);
			},
		});
	}
}