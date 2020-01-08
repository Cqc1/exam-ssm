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
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/ace.min.css" />
    <title>查看个人信息</title>
</head>
<body>
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
            <li><a href="#">查看个人教学信息</a></li>
        </ul>
    </div>
    <div class="tm_container" style="margin: 10px">
            <table class="tablelist">
                <tbody> 
               <thead>
            <tr>
                <th>教学学期</th>
                <th>教师姓名</th>
                <th>课程名称</th>
                <th>班级名称</th>            
            </tr>
               </thead>
               <tbody>
             <c:forEach items="${tas}" var="t">
              <tr>
                <td>${t.term}</td>
                <td>${t.teacher.teaname}</td>
                <td>${t.course.couname}</td>
                <td>${t.clas.claname}${t.classid}</td>
              </tr>
             </c:forEach>
            </tbody>
            </table>                   
                <tfoot>
                <tr>
                    <td>
                        <button class="tm_btn tm_btn_primary" type="button" onclick="javascript:history.back(-1);">返回</button>
                    </td>
                </tr>
                </tfoot>        
      </div>
</body>
</html>