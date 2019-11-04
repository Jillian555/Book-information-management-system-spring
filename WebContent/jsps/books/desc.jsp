<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>SSM Web Demo</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/book/desc.css'/>">
<script src="<c:url value='/static/js/jquery/jquery-1.5.1.js'/>"></script>
<script src="<c:url value='/static/js/book/desc.js'/>"></script>
</head>

<body>
	<div class="divBookName">${book.bname }</div>
	<div>
		<img align="top" src="<c:url value='/static/${book.image_w }'/>"
			class="img_image_w" />
		<div class="divBookDesc">
			<ul>
				<li>商品编号：${book.bid }</li>
				<li>当前价：<span class="price_n">&yen;${book.currPrice }</span></li>
				<li>定价：<span class="spanPrice">&yen;${book.price }</span> 折扣：<span
					style="color: #c30;">${book.discount }</span>折
				</li>
			</ul>
			<hr class="hr1" />
			<table>
				<tr>
					<td colspan="3">作者：${book.author } 著</td>
				</tr>
				<tr>
					<td colspan="3">出版社：${book.press }</td>
				</tr>
				<tr>
					<td colspan="3">出版时间：${book.publishtime }</td>
				</tr>
				<tr>
					<td>版次：${book.edition }</td>
					<td>页数：${book.pageNum }</td>
					<td>字数：${book.wordNum }</td>
				</tr>
				<tr>
					<td width="180">印刷时间：${book.printtime }</td>
					<td>开本：${book.booksize }开</td>
					<td>纸张：${book.paper }</td>
				</tr>
			</table>
			<div class="divForm">
				<c:choose>
					<c:when test="${empty sessionScope.onlineUser }">
						<h1>您还没有登录!购买不了图书!</h1>
					</c:when>
					<c:otherwise>
						<form id="form1" action="/WebDemo0912/addCart" method="post">
						<input type="hidden" name="bid" value="${book.bid}" />
						我要买：<input
						id="cnt" style="width: 40px; text-align: center;" type="text"
						name="quantity" value="1" />件
						<input type="submit" value="加入购物车"  >
						</form>						
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
