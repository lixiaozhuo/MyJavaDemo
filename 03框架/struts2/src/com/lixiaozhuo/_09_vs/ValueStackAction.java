package com.lixiaozhuo._09_vs;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import lombok.Getter;

public class ValueStackAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	@Getter
	private String type3 = "type3";

	@Override
	public String execute() throws Exception {
		// 获取值栈对象
		// 方式1:从请求中获取
		Object obj = ServletActionContext.getRequest()
				.getAttribute("struts.valueStack");
		System.out.println("方式1 = " + obj);
		//方式2:从请求中使用常量获取
		obj = ServletActionContext.getRequest()
				.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		System.out.println("方式2 = " + obj);
		//方式3:通过ActionContext对象获取
		ValueStack stack = ActionContext.getContext().getValueStack();
		System.out.println("方式3 = " + stack);
		
		stack.set("type2", "type2");
		
		stack.getRoot().push("type1");
		
		List<String> list = Arrays.asList("a","b","c");
		stack.getContext().put("list", list);
		
		return SUCCESS;
	}

}
