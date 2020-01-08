<%@ page import="ssm.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<base href="<%=basePath%>">
<head>
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/ace.min.css" />
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    $(document).ready(function(){                  
    	$("#couid").change(function(){
        	var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
    		params.vals = $("#couid").val();
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/score/getList2",
                datatype:"json",
                data:params,
                success:function(data){    
                	var t = data["shijuanInfo"]; 
                    $("#shijuanid").html("<option value=''>--请选择--");
                    for(var i = 0;i<t.length;i++){
                    $("#shijuanid").append("<option value='"+t[i].shijuanid+"'>"+t[i].shijuanid+"</option>");           
                    }
                },
                error:function(data){
                    alert("失败！")
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
        <li><a href="#">修改考生成绩</a></li>
    </ul>
</div>
<div class="tm_container" style="margin: 20px">
    <form method="post" action="${pageContext.request.contextPath}/score/ScoUpdate">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
           <tbody>
            <tr>
                <th width="120">教学学期：</th>
                <td>
                    <input type="text"  name="term"  class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>课程名称：</th>
                <td>
                <select name="couid" id="couid">
                  <c:forEach items="${cou}" var="c">
					  <option value="${c.couid}">${c.couid}-${c.couname}</option>					  
				  </c:forEach>
				</select>
				</td>
            </tr>
            <tr>
            <tr>
                <th>学生学号：</th>
                <td>
                    <input type="text" name="stuid" placeholder="${stuid}" value="${stuid}" readonly="readonly" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>试卷编号：</th>
                <td>
                <select name="shijuanid" id="shijuanid">
                <option value="">--请选择--</option>
                </select>               
				</td>
            </tr>
            <tr>
                <th>考生成绩：</th>
                <td>
                    <input type="text" id="score" name="score" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
            <tfoot>
            <tr>
                <th></th>
                <td>
                    <button class="tm_btn tm_btn_primary" type="submit" onclick="">修改</button>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>