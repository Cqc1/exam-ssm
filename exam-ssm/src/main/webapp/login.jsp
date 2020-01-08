<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="en">
<script language="JavaScript">            
    if (window != top)                      
          top.location.href =location.href;
</script>
<script type="text/javascript">
function check_login() {
	var userid = document.getElementById("userid");
	var password = document.getElementById("password");
	if (userid.value == "" || password.value == "") {
		window.alert("登录ID和登录密码都不能为空！");
		return false; 
	}
	return true;
}
</script>
<head>
        <base href="<%=basePath%>">
        <link rel="stylesheet" type="text/css" href="style.css" />
		<title>登录页面</title>
		<meta name="keywords" content="在线考试系统" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/ace.min.css" />
		<link rel="stylesheet" href="css/ace-rtl.min.css" />
</head>
<body style="background:#93defe" class="login-layout">
    <div class="login_box">
        <div class="login_l_img"><img src="images/login-img.png" /></div>
        <div class="login" style="background:#93defe">
			<div class="space-6"></div>
			<div class="position-relative">
			<div id="login-box" class="login-box visible widget-box no-border">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header blue lighter bigger">
							<i class="icon-coffee green"></i>
							   在线考试系统
						</h4>
						<div class="space-6"></div>
						<form action="${pageContext.request.contextPath}/user/login" method="post">
							<fieldset>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
										class="form-control" placeholder="用户ID" name="userid" id="userid"/>
										<i class="icon-user"></i>
									</span>
								</label>

								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="password" class="form-control" placeholder="密码"  name="password" id="password"/>
										<i class="icon-lock"></i>
									</span>
								</label>
								<div class="limit_radio" style="padding-top: 10px">
				                   <input type="radio" name="type" value="0"  checked >学生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                   <input type="radio" name="type" value="1">教师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                   <input type="radio" name="type" value="2">管理员
				               </div>				              
							   <input type="submit" value="登录" class="width-35 pull-right btn btn-sm btn-primary" onclick="return check_login();"/>
							</fieldset>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>