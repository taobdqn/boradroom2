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
    
    <title>会议室预定系统首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
<body style="text-align:right">
  <c:if test="${empty dlist}">
  		<c:redirect url="DestineServlet?action=select"></c:redirect>
  </c:if>

<table  border="1" align="center">
  <tr style="background-color: red;">
    <td colspan="4" style="text-align: center;"><h2>会议室信息</h2></td>
  </tr>
  <tr>
    <td>编号</td>
    <td>会议室名称</td>
    <td>预定人</td>
    <td>日期</td>
  </tr>

  <c:forEach var="dd" items="${dlist}" >
	  <tr>
	    <td>${dd.id}</td>
	    <td>${dd.room_name}</td>
	    <td>${dd.destine_name}</td>
	    <td>${dd.destine_time}</td>
	  </tr>
  </c:forEach>
    <tr style="border: none;">
    <td colspan="4" style="text-align:right"><a href="addInfo.jsp">预定</a></td>
  </tr>
</table>


</body>
</html>
