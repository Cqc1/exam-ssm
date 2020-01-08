<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import= "ssm.model.* "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<link rel="stylesheet" href="css/ace.min.css" />
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#fuzzy_query").click(function() {
		var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.query = $("#query").val();	
		params.type =$("#type").val();	
			$.ajax({
				async:true,
				type: "POST",
				url: "${pageContext.request.contextPath}/admin/CouInfo_query",//注意路径	
				data:params,
				success:function(data) {
	                    if(data=="success"){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+data);
	                    	alert("查询成功！");                      
	                        window.location.href="${pageContext.request.contextPath}/admin/CouInfo_query2";
		                    }
	                    else if(data=="error"){
		                    alert("此课程不存在！");
		                    window.location.href="${pageContext.request.contextPath}/admin/CouInfo";
	                    }
	                },
	                error:function(data){         
	                	 alert("查询失败！");             	 
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
            <li><a href="#">课程管理</a></li>
        </ul>
    </div>
    <div class="rightinfo">
      <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="images/t01.png" /></span><span><a href="${pageContext.request.contextPath}/admin/CouAdd_view"> 添加</a></span></li>
        </ul>   
         <ul class="toolbar">
            <li class="click">
            <span><img src="images/t011.png" /></span>
            <span><input type="text" name="query" id="query"size="24" maxlength="24"></span>
             <span><select name="type" id="type" >
               <option value="CouId">课程编号</option>
               <option value="CouName">课程名称</option>
               <option value="Credit">课程学分</option>
            </select></span>
            <span><button class="tm_btn tm_btn_primary" id="fuzzy_query" type="button" onclick="">模糊查询</button></span></li>
        </ul>
    </div>
        <table class="tablelist">
            <thead>
            <tr>
                <th>课程编号<i class="sort"></i></th>
                <th>课程名称</th>
                <th>课程学分</th>
                <th>操作选项</th>             
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${cou}" var="c">
              <tr>
                <td>${c.couid}</td>
                <td>${c.couname}</td>
                <td>${c.credit}</td>                  
                <td><a href="${pageContext.request.contextPath}/admin/CouDelete?couid=${c.couid}" class="tablelink">删除</a>|             
                <a href="${pageContext.request.contextPath}/admin/CouUpdate_view?couid=${c.couid}" class="tablelink">修改</a></td>
              </tr>
             </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>