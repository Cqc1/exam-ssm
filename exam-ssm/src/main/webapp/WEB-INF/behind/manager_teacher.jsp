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
				url: "${pageContext.request.contextPath}/teacher/TeInfo_query",//注意路径	
				data:params,
				/* dataType:"json", */
				/* contentType : "application/json;charset=UTF-8",	 */	
				success:function(data) {
	                    /* var message=JSON.stringify(result); */
	                    if(data=="success"){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+data);
	                    	alert("查询成功！");                      
	                        window.location.href="${pageContext.request.contextPath}/teacher/TeInfo_query2";
		                    }
	                    else if(data=="error"){
		                    alert("此用户不存在！");
		                    window.location.href="${pageContext.request.contextPath}/teacher/TeInfo";
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
            <li><a href="#">教师管理</a></li>
        </ul>
    </div>
    <div class="rightinfo">
      <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="images/t01.png" /></span><span><a href="${pageContext.request.contextPath}/teacher/Add_view"> 添加</a></span></li>
        </ul>
         <ul class="toolbar">
            <li class="click">
            <span><img src="images/t011.png" /></span>
            <span><input type="text" id="query"size="24" maxlength="24"></span>
             <span><select id="type" >
               <option value="TeaId">工号</option>
               <option value="TeaName">姓名</option>
               <option value="TeaSex">性别</option>
               <option value="teacher.YuId">院系</option>
               <option value="TeaMail">邮箱</option>
               <option value="TeaNum">号码</option>
            </select></span>
            <span><button class="tm_btn tm_btn_primary" id="fuzzy_query" type="button" onclick="">模糊查询</button></span></li>
        </ul>
        
    </div>
        <table class="tablelist">
            <thead>
            <tr>
                <th>工号<i class="sort"></i></th>
                <th>姓名</th>
                <th>密码</th>
                <th>性别</th>
                <th>所属院系</th>
                <th>邮箱地址</th>
                <th>电话号码</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${teacher}" var="te">
              <tr>
                <td>${te.teaid}</td>
                <td>${te.teaname}</td>
                <td>${te.teapwd}</td>
                <td>${te.teasex}</td>
                <td>${te.yuanxi.yunam}</td>
                <td>${te.teamail}</td>
                <td>${te.teanum}</td>     
                <td><a href="${pageContext.request.contextPath}/teacher/Delete?teaid=${te.teaid}" class="tablelink">删除</a>|             
                <a href="${pageContext.request.contextPath}/teacher/Update_view?teaid=${te.teaid}" class="tablelink">修改</a></td>
              </tr>
             </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>