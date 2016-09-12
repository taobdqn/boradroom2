<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会议室预定页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#destine_time").blur(checkTime);
		
		$("#myform").submit(function(){
			var flag=true;
			if(!checkDestine()) flag=false;
			if(!checkTime()) flag=false;
			return flag;	
		
		});	
	
	});

function checkDestine() {
	var destine_name = $("#destine_name").val();
	var destine_time = $("#destine_time").val();
	if(destine_name == "" || destine_time == "") {
		alert("预定日期和预定人不允许为空！！");
		return false;
		}
		return true;
	}

function checkTime() {
	var destine_time = $("#destine_time").val();
	if(destine_time == "") {
		alert("预定日期不允许为空！！");
		return false;		
	}	
	var reg = /^\d{4}-\d{1,2}-\d{1,2}$/;
	if (reg.test(destine_time) == false) {
		alert("预定日期格式不正确！");
		return false;
	}
	return true;
}


</script>
</head>

<body >
<form action="DestineServlet?action=add" method="post" name="myform" id="myform">
<table  border="1" align="center" >
 <tr style="text-align:center">
  	<td colspan="3">    
    	<h2>预定会议室</h2>
    </td>
  </tr>
  <tr>
    <td style="text-align:right">会议室名称：</td>
    <td>
	    <select name="room_name" id="room_name">
	      <option value="第一会议室">第一会议室</option>
	      <option value="第二会议室">第二会议室</option>
	      <option value="第三会议室">第三会议室</option>
	    </select>
    </td>
    <td>&nbsp;</td>
  </tr>
   
  <tr>
    <td style="text-align:right">预定日期：</td> 
    <td><input name="destine_time" id="destine_time" type="text"/></td>
    <td>如：yyyy-mm-dd</td>
  </tr>
  
  <tr>
    <td style="text-align:right">预定者:</td>
    <td  colspan="2"><input name="destine_name" type="text" id="destine_name"  /></td>
  </tr>
  <tr style="text-align:center">
  	<td colspan="3">    
    	<input name="distine" id="distine" type="submit" value="预定"  />
        <input name="reset" id="reset"  type="reset" value="重置" />
    </td>
  </tr>
</table>

</form>
</body>
</html>
