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
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="css/word.css.css">
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body>
<div class="word">
    <c:forEach items="${line}" var="line">
        <span>
                ${line}
        </span>
    </c:forEach>
</div>
<p>

</p>
<div>
    <ol>
        <c:forEach items="${tixinlist}" var="txl">
            ${txl.get(0).tixinname}(共个)
            <p>

            </p>
        <c:forEach items="${list}" var="l">
            <c:if test="${l.get(0).tixinid.equals(txl.get(0).tixinid)}">
                <li type="1">
                        ${l.get(0).content}
                </li>
                <p>
                </p>
            </c:if>
        </c:forEach>
    </c:forEach>
    </ol>
</div>
</body>
</html>
