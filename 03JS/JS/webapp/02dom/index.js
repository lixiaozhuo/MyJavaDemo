window.onload = function() {
	/**
	 * 获取对象
	 */
	// 通过指定id获取对象
	var div1El = document.getElementById("div1");
	console.log(div1El);
	console.log(div1El.innerText);
	// 通过name获取对象集合
	var chkEl = document.getElementsByName("chk");
	console.log(chkEl);
	// 通过标签类型获取对象结合
	console.log(document.getElementsByTagName("div"));
	console.log("========================================================================")
	/**
	 * 节点属性
	 */
	var div2El = document.getElementById("div2");
	console.log(div2El);
	console.log("元素节点Nodetype : " + div2El.nodeType);
	console.log("元素节点nodeName : " + div2El.nodeName);
	console.log("元素节点nodeValue : " + div2El.nodeValue);
	var attrNode = div2El.getAttributeNode("id")
	console.log(attrNode);
	console.log("属性节点Nodetype : " + attrNode.nodeType);
	console.log("属性节点nodeName : " + attrNode.nodeName);
	console.log("属性节点nodeValue : " + attrNode.nodeValue);
	var textNode = div2El.firstChild.nextSibling.firstChild;
	console.log(textNode);
	console.log("文本节点Nodetype : " + textNode.nodeType);
	console.log("文本节点nodeName : " + textNode.nodeName);
	console.log("文本节点nodeValue : " + textNode.nodeValue);
	console.log("========================================================================")
	/**
	 * Node对象操作
	 */
	console.log("是否有子节点 : " + div2El.hasChildNodes());
	console.log("所有子节点: ");
	console.log(div2El.childNodes);
	console.log("子节点个数 : " + div2El.childNodes.length);
	console.log("最后一个子节点 : ");
	console.log(div2El.lastChild);
	console.log("第一个子节点 : ");
	console.log(div2El.firstChild);
	console.log("父节点 : ");
	console.log(div2El.parentNode);
	console.log("最后一个子节点的上一个节点  : ");
	console.log(div2El.lastChild.previousSibling);
	console.log("第一个子节点的下一个节点  : ");
	console.log(div2El.firstChild.nextSibling);
	console.log("==========================================================================")
	/**
	 * 节点属性操作
	 */
	var mynode = document.getElementById("node");
	console.log(mynode);
	//系统默认属性
	mynode.value="自定义node";
	console.log(mynode.value);
	console.log(mynode["value"]);
	//自定义属性
	console.log(mynode.getAttribute("aaa"));
	mynode.setAttribute("aaa","bbb");
	//readonly
	mynode.readOnly=true;
	//style
	mynode.style.backgroundColor="gray";
	//class
	mynode.className="";
	console.log(mynode);
}

/**
 * span添加和移动
 * @param {} target
 */
// 添加span到div中
function add(target) {
	var spEl = document.createElement("span");
	spEl.style.backgroundColor = "lightgray";
	spEl.innerText = "span";
	var targetEl = document.getElementById(target);
	targetEl.appendChild(spEl);
}
// 移动span到div
function moveSpanToDiv(target) {
	var spEl = document.getElementById("sp");
	var targetEl = document.getElementById(target);
	targetEl.appendChild(spEl);
}
/**
 * 节点插入删除替换
 * 
 * @param
 */
// 在最后插入节点
function insertItemInLast(item) {
	if (!document.getElementById(item)) {
		var itemsEl = document.getElementById("items");
		var itemEl = document.createElement("option");
		itemEl.id = item;
		itemEl.innerText = item;
		itemsEl.appendChild(itemEl);
	}

}
// 插入节点
function insertItem(item) {
	if (!document.getElementById(item)) {
		var item3 = document.getElementById("item3");
		var itemEl = document.createElement("option");
		itemEl.id = item;
		itemEl.innerText = item;
		item3.parentNode.insertBefore(itemEl,item3.nextSibling);
	}
}
// 删除节点
function deleteItem(item) {
	// 存在节点则删除
	if (document.getElementById(item)) {
		var itemEl = document.getElementById(item);
		itemEl.parentNode.removeChild(itemEl);
	}
}
// 替换节点
function replace(newItem, refItem) {
	if (document.getElementById(refItem) && !document.getElementById(newItem)) {
		var item1 = document.getElementById(refItem);
		var item2 = document.createElement("option");
		item2.id = newItem;
		item2.innerText = newItem;
		item1.parentNode.replaceChild(item2, item1);
	}
}