<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import= "ssm.model.* "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
				url: "${pageContext.request.contextPath}/score/ScoInfo_query",//注意路径	
				data:params,
				/* dataType:"json", */
				/* contentType : "application/json;charset=UTF-8",	 */	
				success:function(data) {
	                    /* var message=JSON.stringify(result); */
	                    if(data=="success"){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+data);
	                    	alert("查询成功！");                      
	                        window.location.href="${pageContext.request.contextPath}/score/ScoInfo_query2";
		                    }
	                    else if(data=="error"){
		                    alert("此成绩信息不存在！");
		                    window.location.href="${pageContext.request.contextPath}/score/ScoInfo";
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
            <li><a href="#">成绩管理</a></li>
        </ul>
    </div>
    <div class="rightinfo">
      <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="images/t01.png" /></span><span><a href="${pageContext.request.contextPath}/score/ScoAdd_view"> 添加</a></span></li>
        </ul>
         <ul class="toolbar">
            <li class="click">
            <span><img src="images/t011.png" /></span>
            <span><input type="text" id="query"size="24" maxlength="24"></span>
             <span><select id="type" >
               <option value="score.Term">教学学期</option>
               <option value="score.StuId">学生学号</option>
               <option value="score.CouId">课程编号</option>
               <option value="score.ShijuanId">试卷编号</option>
               <option value="score.Score">考生分数</option>
            </select></span>
            <span><button class="tm_btn tm_btn_primary" id="fuzzy_query" type="button" onclick="">模糊查询</button></span></li>
        </ul>
        
    </div>
        <table class="tablelist">
            <thead>
            <tr>
                <th>教学学期<i class="sort"></i></th>
                <th>课程名称</th>
                <th>学生姓名</th>
                <th>试卷编号</th>
                <th>试卷分数</th>            
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${sco}" var="s">
              <tr>
                <td>${s.term}</td>
                <td>${s.course.couname}</td>
                <td>${s.student.stuname}</td>
                <td>${s.shijuan.shijuanid}</td>
                <td>${s.score}</td>               
                <td><a href="${pageContext.request.contextPath}/score/ScoDelete?stuid=${s.stuid}" class="tablelink">删除</a>|             
                <a href="${pageContext.request.contextPath}/score/ScoUpdate_view?stuid=${s.stuid}" class="tablelink">修改</a></td>
              </tr>
             </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>