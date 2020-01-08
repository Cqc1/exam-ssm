<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script language="JavaScript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //导航切换
            $(".menuson li").click(function(){
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function(){
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if($ul.is(':visible')){
                    $(this).next('ul').slideUp();
                }else{
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>
    <title>Title</title>
</head>
<body style="background:#f0f9fd;">
    <dl class="leftmenu">
        <dd>
            <div class="title">
                 用户信息管理
            </div>
            <ul class="menuson">
             <li class="active"><cite></cite><a href="${pageContext.request.contextPath}/student/StuInfo"  target="rightFrame">学生管理</a><i></i></li>
             <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/TeInfo" target="rightFrame">教师管理</a><i></i></li>            
            </ul>
        </dd>
        <dd>
            <div class="title">
           教务信息管理
          </div>
            <ul class="menuson">
                <li><cite></cite><a href="${pageContext.request.contextPath}/admin/YuxiInfo" target="rightFrame">院系管理</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/admin/ProInfo" target="rightFrame">专业管理</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/admin/ClaInfo" target="rightFrame">班级管理</a><i></i></li>              
            </ul>
        </dd>
         <dd>
            <div class="title">
           教学信息管理
          </div>
            <ul class="menuson">
                <li><cite></cite><a href="${pageContext.request.contextPath}/admin/CouInfo" target="rightFrame">课程管理</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/score/ScoInfo" target="rightFrame">成绩管理</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/admin/TasInfo" target="rightFrame">教学任务管理</a><i></i></li>              
            </ul>
        </dd>
    </dl>
</body>
</html>