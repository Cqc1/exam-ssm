<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: yangf
  Date: 2019/11/1
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <title></title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#down").click(function() {
                var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定
                params.query = $("#query").val();
                params.type =$("#type").val();
                $.ajax({
                    async:true,
                    type: "POST",
                    url: "${pageContext.request.contextPath}/teacher/SetExam",//注意路径
                    data:params,
                    success:function(data) {
                        if(data=="success"){
                            alert("查询成功")
                            console.log("zslog 13.2 异步调用返回成功,result:"+data);
                            window.location.href="${pageContext.request.contextPath}/teacher/GExam_query";
                        }
                        else if(data=="error"){
                            alert("该学科没有设置题型，请现设置");
                            window.location.href="${pageContext.request.contextPath}/admin/YuxiInfo";
                            window.location.href="${pageContext.request.contextPath}/teacher/TxInfo";
                        }
                    },
                    error:function(data){
                        alert("查询失败！");
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/index">试卷管理</a></li>
        <li><a href="#">开始组卷</a></li>
    </ul>

    <div class="tools">
        <ul class="toolbar">
            <li class="click">
                <span>
                    <input type="text" name="query" id="query"size="24" maxlength="24">
                </span>
                <span>
                    <select name="type" id="type" >
                        <c:forEach items="${tx1}" var="t1">
                            <option value="CouId">${t1.couid}-${t1.course.couname}</option>
                        </c:forEach>
                    </select>
                </span>
                <span><button id="down" class="tm_btn tm_btn_primary" type="button" >确定</button></span></li>
        </ul>
    </div>
</div>
</body>
</html>
