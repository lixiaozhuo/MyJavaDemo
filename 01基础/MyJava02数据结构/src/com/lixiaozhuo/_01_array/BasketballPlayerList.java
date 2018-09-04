package com.lixiaozhuo._01_array;

//安排篮球运动员上场
public class BasketballPlayerList {

	public static void main(String[] args) {
		//1):初始容量为5的线性列表
		PlayList.init(5);
		//2):安排5个球员上场:[11,22,33,44,55].
		PlayList.add(11);
		PlayList.add(22);
		PlayList.add(33);
		PlayList.add(44);
		PlayList.add(55);
		PlayList.print();
		//3):查询索引位置为2的球衣号码是:33.
		Integer num = PlayList.get(2);
		System.out.println(num);
		//4):44球衣号的球员在场上的索引位置是:3.
		Integer index = PlayList.getIndexByPlayerNum(44);
		System.out.println(index);
		//5):333替换场上索引位置为2的球员
		/*PlayList.set(2, 333);
		PlayList.print();*/
		//6):222替换球衣号码为22的球员
		/*PlayList.update(22, 222);
		PlayList.print();*/
		//7):把场上索引位置为2的球衣罚下场(注意:罚下,没有补位.).
		PlayList.delete(2);
		//8):按照球员在场上的位置,打印出球衣号码
		PlayList.print();
	}

}
