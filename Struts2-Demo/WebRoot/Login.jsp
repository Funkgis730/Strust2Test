<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function reg() {
		document.getElementById("MyForm").action = "register.jsp";
		document.getElementById("MyForm").submit();
	}
</script>
</head>


<h1>系统登录</h1>
<hr>

<body>

	<form id="MyForm" name="MyForm" action="LoginAction" method="post">
		<div align="center">
			<h2>Login</h2>
			<table>
				<tr>
					<td>Account:&nbsp;&nbsp;<input type="text" name="account"
						style="width:120px;" /></td>
					<td><s:fielderror fieldName="AccountNotFound"/></td>
				</tr>

				<tr>
					<td>Password:<input type="password" name="password"
						style="width:120px;" /></td>
					<td><s:fielderror fieldName="PasswordError"/></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" style="width:60px;">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="button" value="Register" onclick="reg()" style="width:60px;"></td>
				</tr>

			</table>
		</div>
	</form>
</body>

</html>
