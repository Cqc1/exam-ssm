<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import= "ssm.model.* "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#fuzzy_query").click(function() {
		var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.query = $("#query").val();	
		params.type =$("#type").val();	
			$.ajax({
				async:true,
				type: "POST",
				url: "${pageContext.request.contextPath}/student/StuInfo_query",//注意路径	
				data:params,
				success:function(data) {
	                    if(data=="success"){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+data);
	                    	alert("查询成功！");                      
	                        window.location.href="${pageContext.request.contextPath}/student/StuInfo_query2";
		                    }
	                    else if(data=="error"){
		                    alert("此用户不存在！");
		                    window.location.href="${pageContext.request.contextPath}/student/StuInfo";
	                    }
	                },
	                error:function(data){         
	                	 alert("查询失败！");             	 
	                }
					});
	});
});

/* //导出
$(function(){
	$("#derive").click(function() {
		

			window.location.href="${pageContext.request.contextPath}/student/export";

		});

		//导入
     $("#excel_button").click(function() {
			if(confirm("确定导入？")){

			/* var id=$(this).attr("fileId"); */
/* 
			window.location.href="${pageContext.request.contextPath}/student/import"; 

/* 			}

		});
}); */ 

/* $('#upLoadPayerCreditInfoExcel').click(function(){

	var cacheVersion=$("#cacheVersion").val();

    if(checkData()){  

        $('#uploadForm').ajaxSubmit({    

            url:'${pageContext.request.contextPath}/student/import',

            data:{'cacheVersion':cacheVersion},

            dataType: 'text'

        });   

    }  

});   */

 

/* //JS校验form表单信息  

function checkData(){  

   var fileDir = $("#upfile").val();  

   var suffix = fileDir.substr(fileDir.lastIndexOf("."));  

   if("" == fileDir){  

       alert("选择需要导入的Excel文件！");  

       return false;  

   }  

   if(".xls" != suffix && ".xlsx" != suffix ){  

       alert("选择Excel格式的文件导入！");  

       return false;  

   }  

   return true;  

} */

</script>
<body>
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
            <li><a href="#">学生管理</a></li>
        </ul>
    </div>
    <div class="rightinfo">
      <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="images/t01.png" /></span><span><a href="${pageContext.request.contextPath}/student/Add_view"> 添加</a></span></li>
        </ul>   
         <ul class="toolbar">
            <li class="click">
            <span><img src="images/t011.png" /></span>
            <span><input type="text" name="query" id="query"size="24" maxlength="24"></span>
             <span><select name="type" id="type" >
               <option value="StuId">学号</option>
               <option value="StuName">姓名</option>
               <option value="StuSex">性别</option>
               <option value="student.ClassId">班级</option>
               <option value="StuMail">邮箱</option>
               <option value="StuNum">号码</option>
            </select></span>
            <span><button class="tm_btn tm_btn_primary" id="fuzzy_query" type="button" onclick="">模糊查询</button></span></li>
        </ul>
    </div>
        <table class="tablelist">
            <thead>
            <tr>
                <th>学号<i class="sort"></i></th>
                <th>密码</th>
                <th>姓名</th>
                <th>性别</th>
                <th>所属班级</th>
                <th>邮箱地址</th>
                <th>电话号码</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${student}" var="stu">
              <tr>
                <td>${stu.stuid}</td>
                <td>${stu.stupwd}</td>
                <td>${stu.stuname}</td>
                <td>${stu.stusex}</td>
                <td>${stu.clas.claname}</td>
                <td>${stu.stumail}</td>
                <td>${stu.stunum}</td>     
                <td><a href="${pageContext.request.contextPath}/student/Delete?stuid=${stu.stuid}" class="tablelink">删除</a>|             
                <a href="${pageContext.request.contextPath}/student/Update_view?stuid=${stu.stuid}" class="tablelink">修改</a></td>
              </tr>
             </c:forEach>
            </tbody>       
        </table>
   <%--  </div>
     <div class="rightinfo">		 
		<form id="uploadForm" enctype="multipart/form-data" method="post"> 		
			<input id="upfile" type="file" name="upfile">		
			<input type="button" value="导入" id="upLoadPayerCreditInfoExcel" name="btn">		
		</form>		
		<a href="${pageContext.request.contextPath}/student/export">导出</a>
	
	 </div> --%>
</body>
</html>