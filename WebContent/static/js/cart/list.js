$(function() {
	
	$("#selectAll").prop("checked",true);
	$(".cbItem").prop("checked",true);
	showTotal();//计算总计
	
	$("#selectAll").click(function() {
		$(".cbItem").prop("checked",$(this).prop("checked"));
		showTotal();
	});
	$(".cbItem").click(function () {
		var numChecked=$(".cbItem:checked").length;
		var numAll=$(".cbItem").length;
		if (numChecked==numAll) {
			$("#selectAll").prop("checked",true);
		} else{
			$("#selectAll").prop("checked",false);
		}
		showTotal();
	});
	$(".plus").click(function () {
		var $n = $(this).prev("input");
		var v= $n.val();
		var i = parseInt(v)+1;
		$n.val(i);
		//单项小计
		var $p = $(this).parent().next("td").children("span").children("span").eq(0);
		var p1 = parseFloat($p.text());
		//单价
		var p2 =parseFloat($(this).parent().prev("td").children("span").children("span").eq(0).text());
		//加后
		var item =round(p1+p2, 2) ;
		console.log("小计："+item);
		$p.text(item);
		showTotal();
	});
	
	$(".minus").click(function () {
		var $n = $(this).next("input");
		var v= $n.val();
		if (parseInt(v) > 0) {
			var i = parseInt(v)-1;
			$n.val(i);
			//单项小计
			var $p = $(this).parent().next("td").children("span").children("span").eq(0);
			var p1 = parseFloat($p.text());
			//单价
			var p2 =parseFloat($(this).parent().prev("td").children("span").children("span").eq(0).text());
			//减后
			var item =round(p1-p2, 2) ;
			console.log("小计："+item);
			$p.text(item);						
		}
		showTotal();
	});
	
});

// 请求服务器，修改数量。
function sendUpdateQuantity(cartItemId, quantity) {
	$.ajax({
		async:false,
		cache:false,
		url:"/JustDoit/cartitem/updateQuantity",
		data:{"cartItemId":cartItemId,"quantity":quantity},
		type:"POST",
		dataType:"json",
		success:function(result) {
			//1. 修改数量
			$("#" + cartItemId + "Quantity").val(result.quantity);
			//2. 修改小计
			$("#" + cartItemId + "Subtotal").text(result.subtotal);
			//3. 重新计算总计
			showTotal();
		}
	});
}

/*
 * 计算总计
 */
function showTotal() {
	var total = 0;
	/*
	1. 获取所有的被勾选的条目复选框！循环遍历之
	*/
	$(".cbItem").each(function() {
		//2. 获取复选框的值，即其他元素的前缀
		var id = $(this).val();
		//3. 再通过前缀找到小计元素，获取其文本
		var num =parseFloat($("#" + id + "Subtotal").text()) ;
		//4. 累加计算
		if($(this).prop("checked")){
			total += num;
		}		
	});
	// 5. 把总计显示在总计元素上
	console.log("合计："+total);
	$("#total").text(round(total, 2));//round()函数的作用是把total保留2位
}



/*
 * 设置结算按钮样式
 */
function setJieSuan(bool) {
	if(bool) {
		$("#jiesuan").removeClass("kill").addClass("jiesuan");
		$("#jiesuan").unbind("click");//撤消当前元素止所有click事件
	} else {
		$("#jiesuan").removeClass("jiesuan").addClass("kill");
		$("#jiesuan").click(function() {return false;});
	}
	
}

/*
 * 批量删除
 */
function batchDelete() {
	// 1. 获取所有被选中条目的复选框
	// 2. 创建一数组，把所有被选中的复选框的值添加到数组中
	// 3. 指定location为CartItemServlet，参数method=batchDelete，参数cartItemIds=数组的toString()
	var cartItemIdArray = new Array();
	$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
		cartItemIdArray.push($(this).val());//把复选框的值添加到数组中
	});
	location = "/JustDoit/cartitem/batchDelete?cartItemIds=" + cartItemIdArray;
}

/*
 * 结算
 */
function jiesuan() {
	// 1. 获取所有被选择的条目的id，放到数组中
	var cartItemIdArray = new Array();
	$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
		cartItemIdArray.push($(this).val());//把复选框的值添加到数组中
	});	
	// 2. 把数组的值toString()，然后赋给表单的cartItemIds这个hidden
	$("#cartItemIds").val(cartItemIdArray.toString());
	// 把总计的值，也保存到表单中
	$("#hiddenTotal").val($("#total").text());
	// 3. 提交这个表单
	$("#jieSuanForm").submit();
}