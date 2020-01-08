<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
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
                我的考试
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="student_test.jsp" target="rightFrame">我要考试</a><i></i></li>
                <li class="active"><cite></cite><a href="student_record.jsp" target="rightFrame">考试记录</a><i></i></li>
            </ul>
        </dd>
        <dd><div class="title">我的信息</div>
            <ul class="menuson">
                <li><cite></cite>
                <a href="${pageContext.request.contextPath}/student/Stu_idioInfo?stuid=<%=request.getSession().getAttribute("studentId").toString() %>" target="rightFrame">
                查看资料</a>
                <i></i></li>
                <li><cite></cite>
                <a href="${pageContext.request.contextPath}/student/student_pass?stu=<%=request.getSession().getAttribute("stu") %>" target="rightFrame">
                修改密码</a>
                <i></i></li>
            </ul>
        </dd>
    </dl>
</body>
</html>