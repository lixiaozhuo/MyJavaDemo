package com.liixiaozhuo.jQuery;

import lombok.Getter;
import lombok.Setter;

//封装需要返回到前台的json数据对象
@Getter@Setter
public class JSONObject {
	private Boolean success;//是否成功
	private Object data;//返回业务数据
}
