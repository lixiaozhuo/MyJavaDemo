// jdon格式对象
var obj1 = {
	id : 22,
	name : "aaa",
	dept : {
		id : 1,
		name : "dept"
	}
};
console.log(obj1);
// json表示多个对象
var persons = [{
			id : 1,
			name : "aaa"
		}, {
			id : 2,
			name : "bbb"
		}];
console.log(persons);
//获取对象的源代码 Firefox支持
//console.log(persons.toSource());
// 字符串转换为JSON对象
var obj = eval("(" + "{id : 1,name : 'aaa'}" + ")");
console.log(obj);