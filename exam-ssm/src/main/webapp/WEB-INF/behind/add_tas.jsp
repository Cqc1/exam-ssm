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
$(document).ready(function(){                  
    $.ajax({
    	async:true,
		type: "POST",
        url:"${pageContext.request.contextPath}/admin/getList1",
        dataType:"json",             
        success:function(data) 
        {    
        	var y = data["yuInfo1"];                      
             $("#yu").html("<option value=''>--请选择--");
            for(var i = 0;i<y.length;i++){
            $("#yu").append("<option value='"+y[i].yuid+"'>"+y[i].yuid+"："+y[i].yunam+"</option>");
            }    
	    	var p = data["proInfo2"];                      
	         $("#pro").html("<option value=''>--请选择--");
	        for(var i = 0;i<p.length;i++){
	        $("#pro").append("<option value='"+p[i].proid+"'>"+p[i].proid+"："+p[i].proname+"</option>");
	        }
	    },
        error:function(data)
        {
            alert("失败！")
        }
    });
    $("#yu").change(function(){
    	var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.vals = $("#yu").val();
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/admin/getList2",
            datatype:"json",
            data:params,
            success:function(data){    
            	var t = data["teInfo1"]; 
                $("#tea").html("<option value=''>--请选择--");
                for(var i = 0;i<t.length;i++){
                $("#tea").append("<option value='"+t[i].teaid+"'>"+t[i].teaid+"："+t[i].teaname+"</option>");           
                }
            },
            error:function(data){
                alert("失败！")
            }
        });
    });
    $("#pro").change(function(){
    	var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.vals = $("#pro").val();
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/admin/getList2",
            datatype:"json",
            data:params,
            success:function(data){
            	/* data = JSON.parse(data);  */     
            	var c = data["claInfo2"]; 
                $("#cla").html("<option value=''>--请选择--");
                for(var i = 0;i<c.length;i++){
                $("#cla").append("<option value='"+c[i].classid+"'>"+c[i].classid+"："+c[i].claname+"</option>");
                }
            },
            error:function(data){
                alert("失败！")
            }
        });
    });
});
$(function(){
	$("#add").click(function() {
		var params = {};//params.XX必须与Spring Mvc controller中的参数名称一致  	//否则在controller中使用@RequestParam绑定		
		params.taskid = $("#taskid").val();	
		params.term =$("#term").val();
		params.teaid =$("#tea").val();
		params.couid =$("#couid").val();
		params.classid =$("#cla").val();	
			$.ajax({
				async:false,
				type: "POST",
				url: "${pageContext.request.contextPath}/admin/addTask",//注意路径	
				data:JSON.stringify(params),
				dataType:"json",
				contentType : "application/json;charset=UTF-8",				
				success:function(result) {
	                    var message=result;
	                    if(message==null){
	                    	console.log("zslog 13.2 异步调用返回成功,result:"+result);		                
	                    	alert("添加成功！");     
	                    	window.location.href="${pageContext.request.contextPath}/admin/TasInfo";
		                    }
	                    else if(message!=null){
		                    alert("此教学任务已存在！");
		                    window.location.href="${pageContext.request.contextPath}/admin/TasAdd_view";
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
        <li><a href="#">添加教学任务</a></li>
    </ul>
</div>
<div class="tm_container" style="margin: 20px">
    <form method="post">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
            <tbody>
           <!--  <tr>
                <th width="120">教学编号：</th>
                <td>
                    <input type="text" id="taskid" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr> -->
            <tr>
                <th>教学学期：</th>
                <td>
                    <input type="text" id="term" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
             <tr>
            <th>教师选择：</th> 
             <td>
                 院系：
                <select name="yuid" id="yu">
                <option value="">--请选择--</option>
                </select> 
                教师：  
                <select name="teaid" id="tea">
                <option value="">--请选择--</option>
                </select>          
            </td> 
            </tr>
            <tr>
                <th>课程名称：</th>
                <td>
                <select name="couid" id="couid">
                  <c:forEach items="${cou}" var="c">
					  <option value="${c.couid}">${c.couid}-${c.couname}</option>					  
				  </c:forEach>
				</select>
				</td>
            </tr>
            <tr>
            <th>班级选择：</th> 
             <td>
                 专业：
                <select name="proid" id="pro">
                <option value="">--请选择--</option>
                </select> 
                班级：  
                <select name="classid" id="cla">
                <option value="">--请选择--</option>
                </select>          
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