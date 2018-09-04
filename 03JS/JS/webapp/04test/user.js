window.onload = function() {
	// 添加数据
	var btn_submit = document.getElementById("btn_submit");
	btn_submit.onclick = function() {
		
		console.log(document.getElementById("username"));
		//获取输出值
		var usernameValue= document.getElementById("username").value;
		var emailValue = document.getElementById("email").value;
		var telValue = document.getElementById("tel").value;
		//生成id
		var id = new Date().getTime();	
		//构建html
		var tr = document.createElement("tr");
		tr.id=id;
		//构建名称项
		var username = document.createElement("td");
		username.innerHTML=usernameValue;
		//构建email项
		var email = document.createElement("td");
		email.innerHTML=emailValue;
		//构建电话项
		var tel = document.createElement("td");
		tel.innerHTML=telValue;
		//构建删除链接 
		var dele = document.createElement("td");
		var a = document.createElement("a");
		a.href="javascript:delRow('"+id+"')";
		a.innerHTML="删除";
		dele.appendChild(a);
		//将项加入tr
		tr.appendChild(username);
		tr.appendChild(email);
		tr.appendChild(tel);
		tr.appendChild(dele);		
		//加入页面
		var tbody = document.getElementById("userTbody");
		tbody.appendChild(tr);
	}

	// 删除全部
	var btn_removeAll = document.getElementById("btn_removeAll");
	btn_removeAll.onclick = function() {
		var tbody = document.getElementById("userTbody");
		tbody.innerHTML = "";
	}
}
// 单条记录 删除
function delRow(id) {
	var item = document.getElementById(id);
	item.parentNode.removeChild(item);
}
