/**
 * 
 */
package com.soong.execise;

import java.util.ArrayList;

/***
 * 【程序3】 题目：打印出所有的”水仙花数”，所谓”水仙花数”是指一个三位数，其各位数字立方和等于该数本身。
 * 
 * 
 * 例如：153是一个”水仙花数”，因为153=1的三次方＋5的三次方＋3的三次方。
 * 
 * 1^3+ 5^3 + 3^3 = 153
 * 
 * 
 * 100-999
 * 
 */
public class e3 {
	public static void main(String[] args) {
		ArrayList<Integer> result = solve(100, 999);

		System.out.println("水仙花数：" + result.toString());
	}

	public static ArrayList<Integer> solve(int a, int b) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = a; i <= b; i++) {
			if (isNarcissus(i)) {
				result.add(i);
			}
		}
		return result;
	}

	public static boolean isNarcissus(int a) {
		int num1 = a % 10; // 个位
		int num2 = (a % 100) / 10; // 十位
		int num3 = (a % 1000) / 100; // 百位

		if (Math.pow(num1, 3) + Math.pow(num2, 3) + Math.pow(num3, 3) == a) {
			return true;
		}
		return false;
	}
}