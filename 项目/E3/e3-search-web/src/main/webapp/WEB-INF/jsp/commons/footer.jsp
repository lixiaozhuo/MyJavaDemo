<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="footer">
	<div class="footer_zd">
		<ul>
			<li class="quanqiu"></li>
			<li class="chandi"></li>
			<li class="qcll"></li>
			<li class="sfzd"></li>
		</ul>
	</div>
	<div class="foot">
		<div class="pageFooter">
			<div class="middle">
				<ul>
					<li class="kefu">4008-888-888</li>
					<li>周一至周日8:30-22:00</li>
				</ul>
			</div>
			<div class="right">
				<ul>
					<li class="title">购物指南</li>
					<li>
						<a rel="nofollow" href="#">积分制度</a>
					</li>
					<li>
						<a rel="nofollow" href="#">会员介绍</a>
					</li>
					<li>
						<a rel="nofollow" href="#">购物流程</a>
					</li>
					<li>
						<a rel="nofollow" href="#">常见问题</a>
					</li>
				</ul>
				<ul>
					<li class="title">配送服务</li>
					<li>
						<a rel="nofollow" href="#">配送政策</a>
					</li>
					<li>
						<a rel="nofollow" href="#">开箱验货</a>
					</li>
					<li>
						<a rel="nofollow" href="#">配送运费</a>
					</li>
					<li>
						<a rel="nofollow" href="#">配送范围</a>
					</li>
				</ul>
				<ul>
					<li class="title">支付方式</li>
					<li>
						<a rel="nofollow" href="#">货到付款</a>
					</li>
					<li>
						<a rel="nofollow" href="#">在线支付</a>
					</li>
					<li>
						<a rel="nofollow" href="#">优选卡</a>
					</li>
					<li>
						<a rel="nofollow" href="#">发票制度</a>
					</li>
				</ul>
				<ul>
					<li class="title">售后服务</li>
					<li>
						<a rel="nofollow" href="#">退款说明</a>
					</li>
					<li>
						<a rel="nofollow" href="#">退换货流程</a>
					</li>
					<li>
						<a rel="nofollow" href="#">退换货政策</a>
					</li>
					<li>
						<a rel="nofollow" href="#">隐私条款</a>
					</li>
				</ul>
				<ul class="sj">
					<li class="title">商家中心</li>
					<li>
						<a rel="nofollow" href="#">商家规则</a>
					</li>
				</ul>
			</div>
			<div class="left">
				<ul class="f_ios">
					<li>
						<a href="#">手机客户端</a>
					</li>
					<li>
						<span></span>
					</li>
				</ul>
				<ul class="f_wx">
					<li>官方微信</li>
					<li>
						<span></span>
					</li>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
		<div id="float" style="display: none;"></div>
		<div class="bottom">
			<div class="bottom_kx">
				<!--可信网站图片LOGO安装开始-->
				<a id="cnnic" href="#" rel="nofollow">
					<img onclick="CNNIC_change('cnnic')" src="/images/kxicon.jpg"
						border="0">
				</a>
				<script type="text/JavaScript">
					function CNNIC_change(cnnic) {
						var str = document.getElementById(cnnic).href;
						var str1 = str.substring(0, (str.length - 6));
						str1 += CNNIC_RndNum(6);
						document.getElementById(cnnic).href = str1;
					}
					function CNNIC_RndNum(k) {
						var rnd = "";
						for (var i = 0; i < k; i++)
							rnd += Math.floor(Math.random() * 10);
						return rnd;
					}
				</script>
				<!--可信网站图片LOGO安装结束-->
			</div>
			<div class="bottom_sm">
				<a id="_pingansec_bottomimagesmall_shiming" href="#">
					<img src="/images/bottom_sm.png">
				</a>
			</div>
			<div class="clear1"></div>
			<div class="siteinfo">
				<p>
					<span>
						<a rel="nofollow" href="#">关于我们</a>
					</span>
					<span>
						<a rel="nofollow" href="#">联系我们</a>
					</span>
					<span>
						<a rel="nofollow" href="#">招聘人才</a>
					</span>
					<span>
						<a href="#">友情链接</a>
					</span>
					<span>
						<a rel="nofollow" href="#">供应商申请</a>
					</span>
					<span>Copyright© lixiaozhuo 版权所有</span>
				</p>
				<p>
					<span>京公网安备11010502026831号</span>
					<span>
						<a class="beian" rel="nofollow" href="#">京ICP证150325号</a>
					</span>
					<span>食品流通许可证SP1101131210068671(1-1)号</span>
					<span>
						<a class="beian" rel="nofollow" href="#">企业营业执照</a>
					</span>
				</p>
			</div>
		</div>
	</div>
</div>