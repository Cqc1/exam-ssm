<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/ace.min.css" />
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#add").click(function() {
		var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.couid = $("#couid").val();
		params.couname=$("#couname").val();
		params.credit =$("#credit").val();
		$.ajax({
				async:false,
				type: "POST",
				url: "${pageContext.request.contextPath}/admin/addCou",//注意路径	
				data:JSON.stringify(params),
				dataType:"json",
				contentType : "application/json;charset=UTF-8",
                beforeSend:function(result){
                    if(params.couname==""||params.couname==null){
                        alert("请填写学科名称");
                        return false;
                    }
                    if(params.credit==""||params.couname==null){
                        alert("请填写学分");
                        return false;
                    }
                },
				success:function(result) {
	                    var message=result;
	                    if(message==null){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+result);		                
	                    	alert("添加成功！");     
	                    	window.location.href="${pageContext.request.contextPath}/admin/CouInfo";
		                    }
	                    else if(message!=null){
		                    alert("此课程已存在！");
		                    window.location.href="${pageContext.request.contextPath}/admin/CouAdd_view";
	                    }
	                },
	                error:function(result){	          
	                	 alert("添加失败！");
	                }
					});
	});
});
</script>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
        <li><a href="#">添加课程</a></li>
    </ul>
</div>
<div class="tm_container" style="margin: 20px">
    <form method="post">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
            <tbody>
            <tr>
                <th>课程名称：</th>
                <td>
                    <input type="text" id="couname" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr> 
            <tr>
                <th>课程学分：</th>
                <td>
                    <input type="text" id="credit" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>       
            </tbody>
            <tfoot>
            <tr>
                <th></th>
                <td>
                    <button class="tm_btn tm_btn_primary" id="add" type="button" onclick="">添加</button>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>