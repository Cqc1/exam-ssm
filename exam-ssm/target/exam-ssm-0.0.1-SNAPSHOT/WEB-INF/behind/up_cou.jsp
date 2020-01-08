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
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
        <li><a href="#">修改课程</a></li>
    </ul>
</div>
<div class="tm_container" style="margin: 20px">
    <form method="post" action="${pageContext.request.contextPath}/admin/CouUpdate">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
           <tbody>
            <tr>
                <th width="120">课程编号：</th>
                <td>
                    <input type="text"  name="couid" placeholder="${couid}" value="${couid}" readonly="readonly" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>课程名称：</th>
                <td>
                    <input type="text" name="couname" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr> 
            <tr>
                <th>课程学分：</th>
                <td>
                    <input type="text" name="credit" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>         
            </tbody>
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