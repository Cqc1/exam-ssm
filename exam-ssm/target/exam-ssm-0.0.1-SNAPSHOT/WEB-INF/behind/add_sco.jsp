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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ace.min.css" />
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){  
	$("#classid").change(function(){
    	var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.vals = $("#classid").val();
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/score/getList2",
            datatype:"json",
            data:params,
            success:function(data){    
            	var t = data["stuInfo"]; 
                $("#stuid").html("<option value=''>--请选择--");
                for(var i = 0;i<t.length;i++){
                $("#stuid").append("<option value='"+t[i].stuid+"'>"+t[i].stuid+"-"+t[i].stuname+"</option>");           
                }
            },
            error:function(data){
                alert("失败！")
            }
        });
    });
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
$(function(){
	$("#add").click(function() {
		var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.term = $("#term").val();	
		params.score =$("#score").val();
		params.stuid = $("#stuid").val();	
		params.couid =$("#couid").val();
		params.shijuanid =$("#shijuanid").val();	
			$.ajax({
				async:false,
				type: "POST",
				url: "${pageContext.request.contextPath}/score/addScore",//注意路径	
				data:JSON.stringify(params),
				dataType:"json",
				contentType : "application/json;charset=UTF-8",				
				success:function(result) {
	                    var message=result;
	                    if(message==null){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+result);		                
	                    	alert("添加成功！");     
	                    	window.location.href="${pageContext.request.contextPath}/score/ScoInfo";
		                    }
	                    else if(message!=null){
		                    alert("此成绩记录已存在！");
		                    window.location.href="${pageContext.request.contextPath}/score/ScoAdd_view";
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
        <li><a href="#">添加成绩</a></li>
    </ul>
</div>
<div class="tm_container" style="margin: 20px">
    <form method="post">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
            <tbody>   
            <tr>
                <th>教学学期：</th>
                <td>
                    <input type="text" id="term" name="term" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
             <tr>
            <th>考生选择：</th> 
             <td>
                 班级：
                <select name="classid" id="classid">
                  <c:forEach items="${cla}" var="c">
					  <option value="${c.classid}">${c.classid}-${c.claname}</option>					  
				  </c:forEach>
				</select>
                学生：  
                <select name="stuid" id="stuid">
                <option value="">--请选择--</option>
                </select>          
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
                    <button class="tm_btn tm_btn_primary" id="add" type="button" onclick="">添加</button>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>