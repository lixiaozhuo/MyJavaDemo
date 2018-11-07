package com.lixiaozhuo.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lixiaozhuo.pojo.SearchResult;
import com.lixiaozhuo.search.service.SearchService;

/**
 * 商品搜索Controller
 * 
 * @author lxz
 *
 */
@Controller
public class SearchController {
	/**
	 * 搜索服务
	 */
	@Autowired
	private SearchService searchService;
	
	/**
	 * 搜索结果每页显示记录数
	 */
	@Value("${SEARCH_RESULT_ROWS}")
	private Integer SEARCH_RESULT_ROWS;

	@RequestMapping("search")
	public String searchItemList(String keyword,
			@RequestParam(defaultValue = "1") Integer page, Model model)
			throws Exception {
		// 转码
		keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		
		// 查询商品列列表
		SearchResult searchResult = searchService.search(keyword, page,
				SEARCH_RESULT_ROWS);
		// 把结果传递给页面
		model.addAttribute("query", keyword);
		model.addAttribute("totalPages", searchResult.getTotalPages());
		model.addAttribute("recourdCount", searchResult.getRecourdCount());
		model.addAttribute("page", page);
		model.addAttribute("itemList", searchResult.getItemList());
		//转到页面
		return "search";
	}
}
