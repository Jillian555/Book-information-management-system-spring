<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<html>
<head>
<meta charset="UTF-8">
<title>SSM Web Demo</title>
</head>
<body>
<h2>用户登录页面!</h2>
<c:if test="${msg ne null}">
	<font color="red" >${msg}<br></font>	
</c:if>
<form action="log"  method="post" >
	<table>
		<tr>
			<td>用户名称：</td>
			<td><input type="text" name="username" ></td>
			<td><c:if test="${username ne null}">${username}</c:if>
			</td>			
		</tr>
		<tr>
			<td>用户密码：</td>
			<td><input type="password" name="password" ></td>
			<td><c:if test="${password ne null}">${password}</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="3" ><input  type="submit"  value="登录" ></td>
		</tr>
	</table>
</form>
</body>
</html>
