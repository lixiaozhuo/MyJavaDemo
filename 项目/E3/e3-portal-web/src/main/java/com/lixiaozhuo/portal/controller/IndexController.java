package com.lixiaozhuo.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiaozhuo.content.service.ContentService;
import com.lixiaozhuo.pojo.TbContent;

/**
 * 首页控制器
 * @author lxz
 *
 */
@Controller
public class IndexController {
	/**
	 * 首页轮播图内容分类编号
	 */
	@Value("${CONTENT_LUNBO_ID}")
	private Long CONTENT_LUNBO_ID;
	
	/**
	 * 内容服务
	 */
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String showIndex(Model model){
		//查询内容列表
		List<TbContent> ad1List = contentService.getContentByCid(CONTENT_LUNBO_ID);
		//把结果传递给页面
		model.addAttribute("ad1List", ad1List);
		return "index";
	}
}
