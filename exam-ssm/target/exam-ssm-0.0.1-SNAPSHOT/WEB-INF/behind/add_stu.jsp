<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css" />
    <link href="style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/ace.min.css" />
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#add").click(function() {
		var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.stuid = $("#stuid").val();
		params.stupwd =$("#stupwd").val();
		params.stuname =$("#stuname").val();
		params.stusex =$("#stusex").val();
		params.classid =$("#classid").val();
		params.stumail =$("#stumail").val();
		params.stunum =$("#stunum").val();		
			$.ajax({
				async:false,
				type: "POST",
				url: "${pageContext.request.contextPath}/student/addStu",//注意路径	
				data:JSON.stringify(params),
				dataType:"json",
				contentType : "application/json;charset=UTF-8",				
				success:function(result) {
	                    var message=result;
	                    if(message==null){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+result);		                
	                    	alert("添加成功！");
	                    	/* document.write("<form action=${pageContext.request.contextPath}/behind/manager_teacher method=post name=form1 style='display:none'>");
	                    	document.write("</form>");
	                    	document.form1.submit();   */         
	                    	window.location.href="${pageContext.request.contextPath}/student/StuInfo";
		                    }
	                    else if(message!=null){
		                    alert("此用户已存在！");
		                    window.location.href="${pageContext.request.contextPath}/student/Add_view";
	                    }
	                },
	                error:function(result){	          
	                	 alert("添加失败！");
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
        <li><a href="#">添加学生</a></li>
    </ul>
</div>
<div class="tm_container" style="margin: 20px">
    <form method="post">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
            <tbody>
            <tr>
                <th width="120">用&nbsp;户&nbsp;Id&nbsp;：</th>
                <td>
                    <input type="text" id="stuid" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>学生姓名：</th>
                <td>
                    <input type="text" id="stuname" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>学生密码：</th>
                <td>
                    <input type="text" id="stupwd" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</th>
                <td>
                    <input type="radio" name="stusex" id="stusex" value="男" checked>男
                    <input type="radio" name="stusex" id="stusex" value="女">女
                </td>
            </tr>
            <tr>
                <th>所属班级：</th>
                <td>
                <select id="classid">
                  <c:forEach items="${clas}" var="cl">
					  <option value="${cl.classid}">${cl.classid}-${cl.claname}</option>					  
				  </c:forEach>
				</select>
				</td>
            </tr>
            <tr>
                <th>邮箱地址：</th>
                <td>
                   <input type="email" id="stumail" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            
            <tr>
                <th>电话号码：</th>
                <td>
                   <input type="text" id="stunum" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <th></th>
                <td>
                    <button class="tm_btn tm_btn_primary" id="add" type="button" onclick="">添加</button>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>