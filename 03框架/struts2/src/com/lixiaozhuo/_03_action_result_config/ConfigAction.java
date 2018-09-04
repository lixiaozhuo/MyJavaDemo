package com.lixiaozhuo._03_action_result_config;


//action配置测试
public class ConfigAction {
	public String execute(){
		System.out.println("ConfigAction==>execute");
		return "success";
	}
	public String save(){
		System.out.println("ConfigAction==>save");
		return "success";
	}
	public void delete(){
		System.out.println("ConfigAction==>delete");
	}
	public void update(){
		System.out.println("ConfigAction==>update");
	}
}
