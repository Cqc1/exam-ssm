<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
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
                题库管理
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/addRadio_view" target="rightFrame">新增单选题</a><i></i></li>
                <li class="active"><cite></cite><a href="${pageContext.request.contextPath}/teacher/addCheckbox_view" target="rightFrame">新增多选题</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/addJuage_view" target="rightFrame">新增判断题</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/addFill_view" target="rightFrame">新增填空题</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/addSAQ_view" target="rightFrame">新增简答题</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/" target="rightFrame">管理试题</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/TxInfo" target="rightFrame">题型设置</a><i></i></li>
            </ul>
        </dd>
        <dd><div class="title">试卷管理</div>
            <ul class="menuson">
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/GExam?teaid=<%=request.getSession().getAttribute("teacherId").toString()%>" target="rightFrame">开始组卷</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/MExam?teaid=<%=request.getSession().getAttribute("teacherId").toString()%>" target="rightFrame">管理试卷</a><i></i></li>
                <li><cite></cite><a href="${pageContext.request.contextPath}/teacher/TestExam" target="rightFrame">批改试卷</a><i></i></li>
            </ul>
        </dd>
        <dd><div class="title">我的信息</div>
            <ul class="menuson">
                <li><cite></cite>
                <a href="${pageContext.request.contextPath}/teacher/Tea_idioInfo?teaid=<%=request.getSession().getAttribute("teacherId").toString() %>" target="rightFrame">
                个人资料</a><i></i></li>
                <li><cite></cite>
                <a href="${pageContext.request.contextPath}/teacher/Tea_tasInfo?teaid=<%=request.getSession().getAttribute("teacherId").toString() %>" target="rightFrame">
                教学任务</a><i></i></li>
                <li><cite></cite>
                <a href="${pageContext.request.contextPath}/teacher/teacher_pass?tea=<%=request.getSession().getAttribute("tea") %>" target="rightFrame">
                修改密码</a><i></i></li>
            </ul>
        </dd>
    </dl>
</body>
</html>