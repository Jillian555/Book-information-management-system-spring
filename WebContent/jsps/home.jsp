<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/book/list.css'/>">
<title>SSM Web Demo</title>
</head>
<body>
	<h1 style="text-align: center;margin-top:10px;"  >网上书城</h1>
	<div style="height:18pt;  font-size: 14pt; line-height: 14px;text-align: center;" >
	
	<c:choose>
		<c:when test="${empty sessionScope.onlineUser }">		
			<a href="log">登录</a>
			<a href="reg">注册</a>
		</c:when>
		<c:otherwise>
			欢迎您：${sessionScope.onlineUser.nickname }&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="/WebDemo0912/showCartInfos" >我的购物车</a>
		</c:otherwise>
	</c:choose>
	</div>
	
	<c:forEach items="${bookList}" var="book">
		<li>
			<div class="inner">
				<a class="pic" href="/WebDemo0912/desc?bid=${book.bid }">
					<img src="<c:url value='/static/${book.image_b }'/>" border="0" />
				</a>
				<p class="price">
					<span class="price_n">&yen;${book.currPrice }</span> 
					<span class="price_r">&yen;${book.price }</span> 
					(<span class="price_s">${book.discount }折</span>)
				</p>
				<p>
					<a id="bookname" title="${book.bname }"
						href="/WebDemo0912/desc?bid=${book.bid }">
						${book.bname }</a>
				</p>							
			</div>
		</li>
	</c:forEach>
	<c:forEach items="${popularList}" var="book">
		<li>
			<div class="inner">
				<h3>热门图书推荐</h3>
				<a class="pic" href="/WebDemo0912/desc?bid=${book.bid }">
					<img src="<c:url value='/static/${book.image_b }'/>" border="0" />
				</a>
				<p class="price">
					<span class="price_n">&yen;${book.currPrice }</span> 
					<span class="price_r">&yen;${book.price }</span> 
					(<span class="price_s">${book.discount }折</span>)
				</p>
				<p>
					<a id="bookname" title="${book.bname }"
						href="/WebDemo0912/desc?bid=${book.bid }">
						${book.bname }</a>
				</p>							
			</div>
		</li>
	</c:forEach>
</body>
</html>