<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>SSM Web Demo</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/cart/list.css'/>">
	<script src="<c:url value='/static/js/jquery/jquery-1.12.4.js'/>"></script>	
	<script src="<c:url value='/static/js/front/round.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/static/js/cart/list.js'/>"></script>
  </head>
  <body>

<c:choose>
	<c:when test="${empty cartItemList }">
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="<c:url value='/static/images/icon_empty.png'/>"/>
			</td>
			<td>
				<a href="/WebDemo0912/infos"  ><span class="spanEmpty">您的购物车中暂时没有商品,回主页继续购物</span></a>
			</td>
		</tr>
	</table>  
	</c:when>
	<c:otherwise>
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr align="center" bgcolor="#efeae5">
			<td align="left" width="50px">
				<input type="checkbox" id="selectAll" /><label for="selectAll">全选</label>
			</td>
			<td colspan="2">商品名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
			<td>操作</td>
		</tr>

	<c:forEach items="${cartItemList }" var="cartItem">
		<tr align="center">
			<td align="left">
				<input value="${cartItem.cartItemId }" type="checkbox" name="checkboxBtn"  class="cbItem" />
			</td>
			<td align="left" width="70px">
											
				<a class="linkImage" href="/WebDemo0912/desc?bid=${cartItem.bid }"><img border="0" width="54" align="top" src="<c:url value='/static/${cartItem.book.image_b }'/>"/></a>
			</td>
			<td align="left" width="400px">
			    <a href="/WebDemo0912/desc?bid=${cartItem.bid }"><span>${cartItem.book.bname }</span></a>
			</td>
			<td>
				<span>&yen;
				<span class="currPrice">${cartItem.book.currPrice }</span>
				</span>
			</td>
			<td>				
				<input type="button" class="minus" value="-" />
				<input class="quantity" readonly="readonly" id="${cartItem.cartItemId }Quantity" type="text" value="${cartItem.quantity }"/>
				<input type="button" class="plus" value="+" />				
			</td>
			<td width="100px">
				<span class="price_n">&yen;
				<span class="subTotal" id="${cartItem.cartItemId }Subtotal">${cartItem.subtotal }</span>
				</span>
			</td>
			<td>
				<a href="/WebDemo0912/removeCart?cartItemId=${cartItem.cartItemId }">删除</a>
			</td>
		</tr>
	</c:forEach>
	
		<tr>
			<td colspan="4" class="tdBatchDelete">
				<a href="/WebDemo0912/cleanCart?uid=${ownerId}">清空购物车</a>
			</td>
			<td colspan="3" align="right" class="tdTotal">
				<span>总计：</span><span class="price_t">&yen;<span id="total"></span></span>
			</td>
		</tr>
		<tr>
			<td colspan="7" align="right">
				<a href="/WebDemo0912/infos"  ><span class="spanEmpty">继续购物</span></a>
			</td>
		</tr>
	
	</table>
	

	</c:otherwise>
	</c:choose>
  </body>
</html>
