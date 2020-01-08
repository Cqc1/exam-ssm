<%--
  Created by IntelliJ IDEA.
  User: yangf
  Date: 2019/11/1
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
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
    <title></title>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/index">试卷管理</a></li>
        <li><a href="#">管理试卷</a></li>
    </ul>
</div>
<form>
    <table class="tablelist">
        <thead>
        <tr>
            <th>试卷编号</th>
            <th>考试科目</th>
            <th>考试时间</th>
            <th>考试时长</th>
            <th>考试地点</th>
            <th>组卷人</th>
            <th>考试班级</th>
            <th>代考人数</th>
            <th>操作选项</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sj}" var="sj" >
            <tr>
                <td>${sj.shijuanid}</td>
                <td>${sj.course.couname}</td>
                <td>${sj.examday}</td>
                <td>${sj.examtime}</td>
                <td>${sj.examadr}</td>
                <td>${sj.zujuuser}</td>
                <td>${sj.clas.claname}${sj.clas.classid}</td>
                <td></td>
                <td>
                    <a href="${pageContext.request.contextPath}/teacher/UpdateExam" class="tablelink">修改/</a>
                    <a href="${pageContext.request.contextPath}/teacher/Download" class="tablelink">下载</a>
                </td>
            </tr
            </c:forEach>>
        </tbody>
    </table>
</form>
</body>
</html>
