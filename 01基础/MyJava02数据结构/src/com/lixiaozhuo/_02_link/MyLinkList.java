package com.lixiaozhuo._02_link;

//双向链表
public class MyLinkList {
	private Node first;//头节点
	private Node last;//尾节点
	private int size = 0;//节点数量

	public void addFirst(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.first = node;
			this.last = node;
		} else {
			//新节点的下一个节点为头节点
			node.next = this.first;
			//头节点上一个节点为新节点
			this.first.prev = node;
			//头节点更新为新节点
			this.first = node;
		}
		size++;
	}

	public void addLast(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.first = node;
			this.last = node;
		} else {
			//把新增节点作为尾节点的下一个节点
			this.last.next = node;
			//新增节点的上一个节点为尾节点
			node.prev = this.last;
			//新增节点为新尾节点
			this.last = node;
		}
		size++;
	}

	public void remove(Object ele) {
		Node current = this.first;
		for (int i = 0; i < size; i++) {
			if (!current.ele.equals(ele)) {
				if(current.next == null){
					return ;
				}
				current = current.next;
			} else {
				break;
			}
		}
		if(current == first){
			this.first = this.first.next;
			this.first.prev = null;
		}else if(current == last){
			this.last = this.last.prev;
			this.last.next = null;
		}else{
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
		size--;
		
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder strb = new StringBuilder(size * 2 + 1);
		Node current = this.first;
		strb.append("[");
		for (int i = 0; i < size; i++) {
			strb.append(current.ele);
			if (i == size - 1) {
				strb.append("]");
			} else {
				strb.append(",");
			}
			current = current.next;
		}
		return strb.toString();

	}

	class Node {
		Node prev;//上一个节点
		Node next;//下一个节点
		Object ele;//节点存储的数据

		public Node(Object ele) {
			this.ele = ele;
		}
	}

}
