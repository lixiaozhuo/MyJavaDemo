<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="ui_tb_h30">
	<div class="ui_flt" style="height: 30px; line-height: 30px;">
		共有
		<span class="ui_txt_bold04"> ${pageResult.totalCount} </span>
		条记录，当前第
		<span class="ui_txt_bold04"> ${pageResult.currentPage} /
			${pageResult.totalPage} </span>
		页
	</div>
	<div class="ui_frt">
		<input type="button" value="首页" class="ui_input_btn01 btn_page"
			data-page="1" />
		<input type="button" value="上一页" class="ui_input_btn01 btn_page"
			data-page='${pageResult.prevPage}' />
		<input type="button" value="下一页" class="ui_input_btn01 btn_page"
			data-page='${pageResult.nextPage}' />
		<input type="button" value="尾页" class="ui_input_btn01 btn_page"
			data-page='${pageResult.totalPage}' />
		<select name="pageSize" cssClass="ui_select02">
			<option value="5" ${pageResult.pageSize==5?'selected':''}>5</option>
			<option value="10" ${pageResult.pageSize==10?'selected':''}>10</option>
			<option value="20" ${pageResult.pageSize==20?'selected':''}>20</option>
		</select>
		转到第
		<input type="text" name="currentPage" cssClass="ui_input_txt01" />
		页
		<input type="button" class="ui_input_btn01 btn_page" value="跳转" />
	</div>
</div>