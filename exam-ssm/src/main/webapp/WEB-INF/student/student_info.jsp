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
            <li><a href="#">查看个人信息</a></li>
        </ul>
    </div>
    <div class="tm_container" style="margin: 10px">
        <form method="method" >
            <table width="100%" cellpadding="5" border="0" class="tm_table_form">
                <tbody>             
                <tr>
                    <th width="120">学生学号：<i class="sort"></i></th>
                    <td>${student.stuid}</td>
                </tr>
                <tr>
                    <th>学生密码：</th>
                    <td>${student.stupwd}</td>
                </tr>
                <tr>
                    <th>学生姓名：</th>
                    <td>${student.stuname}</td>
                </tr>
                <tr>
                    <th>学生性别：</th>
                    <td>${student.stusex}</td>                
                </tr>
                <tr>
                    <th>所属班级：</th>
                    <td>${student.clas.claname}</td>
                </tr>
                <tr>
                    <th>邮箱地址：</th>
                    <td>${student.stumail}</td>                
                </tr>
                <tr>
                    <th>电话号码：</th>
                    <td>${student.stunum}</td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <th></th>
                    <td>
                        <button class="tm_btn tm_btn_primary" type="button" onclick="javascript:history.back(-1);">返回</button>
                    </td>
                </tr>
                </tfoot>
            </table>
        </form>
    </div>
    </div>
</body>
</html>