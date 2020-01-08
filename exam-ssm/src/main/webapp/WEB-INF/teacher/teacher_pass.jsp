<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/ace.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
  <link href="style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#update").click(function() {
	var old_pass = document.getElementById("old_pass");
	var new_pass = document.getElementById("new_pass");
	var new_pass2 = document.getElementById("new_pass2");
	if (old_pass.value == "" || new_pass.value == ""||new_pass2.value=="") {
		window.alert("输入的密码都不能为空！");
		return false;
	}
	else if(new_pass.value!=new_pass2.value){
		window.alert("两次输入的密码不同！");
		return false;
		}	
	else 
		//检查旧密码是否正确
		    	var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
				params.old_pass = $("#old_pass").val();
				params.teaid=$("#teaid").html();
				params.new_pass=$("#new_pass").val();
		        $.ajax({
		        	async:true,
		            type:"post",
		            url:"${pageContext.request.contextPath}/teacher/Tea_pass",
		            datatype:"json",
		            data:params,
		            /* contentType : "application/json;charset=UTF-8",	 */
		            success:function(result){    
		            	var message=result;
	                    if(message=="success"){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+result);		                
	                    	alert("修改成功,请重新登录！");	                    	        
	                    	window.location.href="${pageContext.request.contextPath}/login.jsp";
		                    }
	                    else if(message=="error"){
		                    alert("密码输入错误！");
		                    window.location.href="${pageContext.request.contextPath}/teacher/teacher_pass.jsp";
	                    }
	                },
	                error:function(result){	          
	                	 alert("修改失败！");	
	                }
					});
		});
});

</script>
<body>
  <div class="place">
      <span>位置：</span>
      <ul class="placeul">
          <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
          <li><a href="#">修改密码</a></li>
      </ul>
  </div>
  <div class="tm_container" style="margin: 10px">
 <!--      <form method="post" action="changepass"> -->
          <table width="100%" cellpadding="5" border="0" class="tm_table_form">
              <tbody>          
                  <tr>
                     <th width="120">登录账号：</th>
                     <td id="teaid">${tea.teaid}</td>
                  </tr>
                  <tr>
                      <th width="120">教师姓名：</th>
                      <td> ${tea.teaname}</td>
                  </tr>
                  <tr>
                     <th>旧密码：</th>
                     <td>
                       <input type="password" name="old_pass" id="old_pass" class="tm_txt" size="50" maxlength="30">
                     </td>
                  </tr>
                  <tr>
                      <th>新密码：</th>
                      <td>
                        <input type="password" name="new_pass" id="new_pass" class="tm_txt" size="50" maxlength="30">
                      </td>
                  </tr>
                  <tr>
                      <th>确认新密码：</th>
                      <td>
                        <input type="password" name="new_pass2" id="new_pass2" class="tm_txt" size="59" maxlength="30">
                      </td>
                  </tr>
              </tbody>
              <tfoot>
                  <tr>
                      <th></th>
                      <td>
                          <button class="tm_btn tm_btn_primary" id="update">提交</button>
                      </td>
                  </tr>
              </tfoot>
          </table>
   <!--    </form> -->
  </div>
</body>
</html>