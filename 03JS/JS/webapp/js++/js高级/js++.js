
// js没有参数重载,参数个数不同时可通过arguments.length判断参数个数
function coding(){	
	if(arguments.length==1){
		console.log(arguments[0] )
	}else if(arguments.length==2){
		console.log(arguments[0]+","+arguments[1]);
	}	
}
// 参数类型不同,通过instanceof和typeof解决
function fn(){
	if(typeof data='string' || data instanceof String){
		console.log("字符串");
	}	
}
//函数参数错位问题
function post(url,data,callback,type){
	//判断data是否是一个函数
	if(data instanceof Fuction){
		type = callback;
		callback = data;
		data = undefined;
	}	
}
//将数据中的所有name替换成text属性
function fn(args){	
	for(var i = 0;i<args.length;i++){
		args[i].text = args[i].name;
		delete args[i].name;
		if(args[i].children){
			//递归调用
			//fn(args[i].childern)
			arguments.callee(args[i].children);
		}
	}	
}
//匿名函数,只执行一次
(function(){
	alert(1);	
})();

//计数器(闭包)
(function(){
	//防止外界调用
	var count = 1;
	window.getCount = function(){
		return count++;
	}
})();



