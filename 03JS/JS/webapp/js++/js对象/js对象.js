/**
 * 创建对象
 */
//new 关键字方式创建对象
var obj = new Object();

obj.name = "lucy";
obj["dept"] = new Object();
obj["dept.m"] = "aaa";
console.log(obj);

// json方式创建对象
var newObj = {}
//对象的克隆
for ( var temp in obj) {
	newObj[temp] = obj[temp];
}
console.log(newObj);
console.log("===========================================")
/**
 * function对象
 */
var temp = 1;
function fn(){
	var temp = 2;
	console.log(temp);
	console.log(window.temp);
	console.log(this.temp);
}

//使用call和apply调用方法,可以设置调用者是谁
//fn.call(obj,8,9);
//fn.apply(obj,[8,9]);
console.log("===========================================")
/**
 * 类
 */
function Person(name,age){
	this.name = name;
	this.age = age;
}
//给类添加统一的方法
/*Person.prototype.showName = function(){
	return this.name;
}*/
console.log(Person);
console.log(Person.prototype);

var p = new Person("bbb",18);
console.log(p);
console.log(p.__proto__);
console.log("===========================================")
/**
 * 继承
 * 
 */
//简单继承
function Student(sn,name,age){
	//拷贝原声区域数据
	Person.call(this,name,age);
	this.sn = sn;
}
Student.prototype = new Person();
console.log(Student);
var s = new Student(1,"wang",19);
console.log(s)
console.log(s.__proto__ == Student.prototype);
console.log(s.__proto__.__proto__ == Person.prototype);
console.log(s.__proto__.__proto__.__proto__ == Object.prototype);

