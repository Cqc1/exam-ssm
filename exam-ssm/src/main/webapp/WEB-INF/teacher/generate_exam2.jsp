<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: yangf
  Date: 2019/11/1
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#generate").click(function() {
                var score= [];
                var num= [];
                var i1=0;
                <c:forEach items="${tixin}" var="tx">
                score[i1] = document.getElementById("score${tx.tixinid}").value;
                num[i1] =  document.getElementById("${tx.tixinid}").value;
                i1++;
                </c:forEach>
                var params = {};
                    params.t0=$("#t0").val().toString(),
                    params.score=score,
                    params.num=num;
                    params.h_ub=$("#h_ub").val().toString(),
                    params.h_lb=$("#h_lb").val().toString(),
                    params.d_ub=$("#d_ub").val().toString(),
                    params.d_lb=$("#d_lb").val().toString(),
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/teacher/GExam2",//注意路径
                    data:JSON.stringify(params),
                    dataType:"json",
                    contentType : "application/json;charset=UTF-8",
                    beforeSend(result){
                        alert(JSON.stringify(params));
                    },
                    success:function (result) {
                        window.location.href="${pageContext.request.contextPath}/teacher/show_exam";
                    },
                    error: function(result) {
                    },
                })
            });
        });
    </script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/index">试卷管理</a></li>
        <li><a href="#">开始组卷</a></li>
        <li><a href="#">生成试卷</a></li>
    </ul>


    <div class="tm_container" style="margin: 10px">
        <form method="post">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
            <tbody>
            <tr>
                <th width="120">
                    <i class="sort">考试时长:</i>
                </th>
                <td>
                    <input id="t0" type="text">
                </td>
            </tr>
            <c:forEach items="${tixin}" var="tx">
                <tr>
                    <th>${tx.tixinname}分数</th>
                    <td><input id="score${tx.tixinid}" type="text"></td>
                </tr>
                <tr>
                <th>${tx.tixinname}个数 </th>
                <td><input id="${tx.tixinid}" type="text"></td>
                </tr>
            </c:forEach>
            <tr>
                <th>难度系数上界：</th>
                <td><input id="h_ub" type="text"></td>
            </tr>
            <tr>
                <th>难度系数下届：</th>
                <td><input id="h_lb" type="text"></td>
            </tr>
            <tr>
                <th>区分度上界：</th>
                <td><input id="d_ub" type="text"></td>
            </tr>
            <tr>
                <th>区分度下界：</th>
                <td><input id="d_lb" type="text"></td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <th></th>
                <td>
                    <button id="generate" class="tm_btn tm_btn_primary" type="button" onclick="">生成试卷</button>
                </td>
            </tr>
            </tfoot>
        </table>
        </form>
    </div>
</div>
</body>
</html>
