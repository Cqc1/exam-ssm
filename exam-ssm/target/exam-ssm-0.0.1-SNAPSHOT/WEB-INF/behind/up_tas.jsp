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
                	var aa = data["proInfo2"];                                      
                     $("#pro").html("<option value=''>--请选择--");
                    for(var i = 0;i<aa.length;i++){
                    $("#pro").append("<option value='"+aa[i].proid+"'>"+aa[i].proid+"："+aa[i].proname+"</option>");
                    }
                },
                error:function(data)
                {
                    alert("失败！")
                }
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
                    	var bb = data["claInfo2"]; 
                        $("#cla").html("<option value=''>--请选择--");
                        for(var i = 0;i<bb.length;i++){
                        $("#cla").append("<option value='"+bb[i].classid+"'>"+bb[i].classid+"："+bb[i].claname+"</option>");
                        }
                    },
                    error:function(data){
                        alert("失败！")
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
        <li><a href="#">修改教学任务</a></li>
    </ul>
</div>
<div class="tm_container" style="margin: 20px">
    <form method="post" action="${pageContext.request.contextPath}/admin/TasUpdate">
        <table width="100%" cellpadding="5" border="0" class="tm_table_form">
           <tbody>
            <tr>
                <th width="120">教学编号：</th>
                <td>
                    <input type="text"  name="taskid" placeholder="${taskid}" value="${taskid}" readonly="readonly" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>教学学期：</th>
                <td>
                    <input type="text" name="term" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>
            <tr>
                <th>教师名称：</th>
                <td>
                    <input type="text" name="teaid" placeholder="<%=request.getParameter("teaname") %>" value="<%=request.getParameter("teaid") %>" readonly="readonly" class="tm_txt" size="50" maxlength="30">
                </td>
            </tr>                
            <tr>
                <th>课程名称：</th>
                <td>
                <select name="couid">
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
                    <button class="tm_btn tm_btn_primary" type="submit" onclick="">修改</button>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>