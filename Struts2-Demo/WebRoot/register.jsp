<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>
		<s:fielderror fieldName="SystemError" />
	</h1>
	<hr>
	
	<form action="RegisterAction" method="post">
		<div align="center">
			<h2>Register</h2>
			<table>
				<tr>
					<td>Account</td>
					<td><input type="text" name="account" style="width:120px;"></td>
					<td><s:fielderror fieldName="AccountRepeat" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" style="width:120px;"></td>
					<td><s:fielderror fieldName="PasswordLength" /></td>
				</tr>
			</table>
			<input type="submit" value="submit" style="width:60px;">
		</div>
	</form>
</body>
</html>
