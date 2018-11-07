<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--shortcut start-->
<jsp:include page="shortcut.jsp" />
<!--shortcut end-->
<div id="header">
	<div class="header_inner">
		<div class="logo">

			<div class="index_topad" id="playLogo" style="">
				<a href="#">
					<img src="/images/html/20160829181637762.gif">
				</a>
			</div>
			<a name="sfbest_hp_hp_head_logo" href="http://localhost:82" class="trackref logoleft">
			</a>
			<div class="logo-text">
				<img src="/images/html/logo_word.jpg">
			</div>
		</div>
		<div class="index_promo"></div>
		<div class="search">
			<form action="http://localhost:83/search.html" id="searchForm"
				name="query" method="GET">
				<input type="text" class="text keyword ac_input" name="keyword"
					id="keyword" value="" style="color: rgb(153, 153, 153);"
					onkeydown="javascript:if(event.keyCode==13) search_keys('searchForm');"
					autocomplete="off">
				<input type="button" value="" class="submit"
					onclick="search_keys('searchForm')">
			</form>
			<div class="search_hot">
				<a href="#">大闸蟹</a>
				<a href="#">石榴</a>
				<a href="#">松茸</a>
				<a href="#">牛排</a>
				<a href="#">白虾</a>
				<a href="#">全脂牛奶</a>
				<a href="#">洋河</a>
				<a href="#">绿豆</a>
				<a href="#">一品玉</a>
			</div>
		</div>
		<div class="shopingcar" id="topCart">
			<s class="setCart"></s>
			<a href="http://localhost:86/cart/cart.html" class="t"
				rel="nofollow">我的购物车</a>
			<b id="cartNum">0</b>
			<span class="outline"></span>
			<span class="blank"></span>
			<div id="cart_lists">
				<!--cartContent-->
				<div class="clear"></div>
			</div>
		</div>
	</div>
</div>