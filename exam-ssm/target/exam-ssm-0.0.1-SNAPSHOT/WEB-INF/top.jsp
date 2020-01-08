<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import= "ssm.model.* "%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css" />
    <link href="images/**">
    <title>Title</title>
</head>
<body  style="background:url(images/topbg.gif) repeat-x;">
    <div class="topleft">
        <a href="" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
    <div class="topright">
        <ul>
            <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="login.jsp" target="_parent">退出</a></li>
        </ul>
        <div class="user">
            <%
                String name=null;
                String level=request.getSession().getAttribute("sessionlevel").toString();     
                if(level.equals("0")){  
                	name=request.getSession().getAttribute("student").toString();
                }
                else if(level.equals("1")){
                	name=request.getSession().getAttribute("teacher").toString();
                }
                else{
                	name=request.getSession().getAttribute("admin").toString();
                }
            %>
            <span>欢迎您！ <%=name%></span>
        </div>
    </div>
</body>
</html>