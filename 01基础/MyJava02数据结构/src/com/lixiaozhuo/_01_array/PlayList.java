package com.lixiaozhuo._01_array;

import java.util.Arrays;

public class PlayList {
	//存储场上球员的球衣号码
	private static Integer[] players = null;
	//场上球员的个数
	private static int size = 0;

	//1):初始化线性列表
	public static void init(Integer initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("容量不可小于0");
		}
		players = new Integer[initialCapacity];
	}

	//2):安排球员上场.
	public static void add(Integer playerNum) {
		if (size == players.length) {
			players = Arrays.copyOf(players, players.length * 2);
			;
		}
		players[size] = playerNum;
		size++;
	}

	//3):查询指定位置的球员的球衣号码是多少.
	public static Integer get(Integer index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		return players[index];
	}

	//4):根据球衣号码查询该球员在场上的索引位置.
	public static Integer getIndexByPlayerNum(Integer playNum) {
		for (int i = 0; i < size; i++) {
			if (players[i].equals(playNum)) {
				return i;
			}
		}
		return -1;
	}

	//5):替换场上索引位置为2的球员
	public static void set(Integer index, Integer newPlayNum) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		players[index] = newPlayNum;
	}

	//6):替换球衣号码为22的球员.
	public static void update(Integer oldPlayNum, Integer newPlayNum) {
		Integer index = getIndexByPlayerNum(oldPlayNum);
		if (index >= 0) {
			set(index, newPlayNum);
		}
	}

	//7):把场上索引位置为2的球衣罚下场(注意:罚下,没有补位.).
	public static void delete(Integer index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		for (int i = index; i < size - 1; i++) {
			players[i] = players[i + 1];
		}
		players[size - 1] = null;
		size--;
	}

	//8):按照球员在场上的位置,打印出球衣号码,打印风格:[11,22,33,44,55].
	public static void print() {
		if (players == null) {
			System.out.println("null");
			return;
		}
		if (size == 0) {
			System.out.println("[]");
			return;
		}
		StringBuilder strb = new StringBuilder(size * 2 + 1);
		strb.append("[");
		for (int i = 0; i < size; i++) {
			strb.append(players[i]);
			if (i == size - 1) {
				strb.append("]");
			} else {
				strb.append(",");
			}
		}
		System.out.println(strb);
	}
}
