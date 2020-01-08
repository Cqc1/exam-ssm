<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "ssm.model.* "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/ace.min.css" />
    <title>Title</title>
</head>
<body>
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
            <li><a href="#">题型管理</a></li>
        </ul>
    </div>
    <div class="rightinfo">
      <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="images/t01.png" /></span><span><a href="${pageContext.request.contextPath}/teacher/TxAdd_view"> 添加</a></span></li>
        </ul>           
    </div>
        <table class="tablelist">
            <thead>
            <tr>
                <th>题型序号<i class="sort"></i></th>
                <th>题型名称</th>
                <th>操作选项</th>             
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${tx}" var="t">
              <tr>
                <td>${t.tixinid}</td>
                <td>${t.tixinname}</td>                 
                <td><a href="${pageContext.request.contextPath}/teacher/TxDelete?txid=${t.tixinid}" class="tablelink">删除</a>|             
                <a href="${pageContext.request.contextPath}/teacher/TxUpdate_view?txid=${t.tixinid}" class="tablelink">修改</a></td>
              </tr>
             </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>