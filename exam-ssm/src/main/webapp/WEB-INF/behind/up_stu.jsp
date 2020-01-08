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
        <li><a href="#">修改学生</a></li>
    </ul>
</div>
<div class="tm_container" style="margin: 20px">
    <form method="post" action="${pageContext.request.contextPath}/student/Update">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
           <tbody>
            <tr>
                <th width="120">用&nbsp;户&nbsp;Id&nbsp;：</th>
                <td>
                    <input type="text"  name="stuid" placeholder="${stuid}" value="${stuid}" readonly="readonly" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>学生姓名：</th>
                <td>
                    <input type="text" name="stuname" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>学生密码：</th>
                <td>
                    <input type="text" name="stupwd" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</th>
                <td>
                    <input type="radio" name="stusex" value="男" class="tm_txt" size="50" maxlength="30" checked>男
                    <input type="radio" name="stusex" value="女" class="tm_txt" size="50" maxlength="30">女
                </td>
            </tr>
            <tr>
                <th>所属班级：</th>
                <td>
                <select name="classid">
                  <c:forEach items="${clas}" var="cl">
					  <option value="${cl.classid}">${cl.classid}-${cl.claname}</option>					  
				  </c:forEach>
				</select>
				</td>
            </tr>
            <tr>
                <th>邮箱地址：</th>
                <td>
                   <input type="email" name="stumail" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            
            <tr>
                <th>电话号码：</th>
                <td>
                   <input type="text" name="stunum" class="tm_txt" size="50" maxlength="30">
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