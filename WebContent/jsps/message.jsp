<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSM Web Demo</title>
</head>
<body>
	<h1>后台管理员: </h1>
	<table>
	<tr><td>账户</td><td>密码</td><td>昵称</td></tr>
	<c:forEach items="${users}" var="e">
		<tr><td>${e.uid}</td><td>${e.pwd}</td><td>${e.nickname}</td></tr>
		<br>
	</c:forEach>
	</table>
</body>
</html>