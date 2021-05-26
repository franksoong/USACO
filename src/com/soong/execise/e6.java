/**
 * 
 */
package com.soong.execise;

import java.util.Scanner;

/**
 * 【程序6】 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 */
public class e6 {
	public static void main(String[] args) {
		System.out.println("请输入第一个正整数：");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();

		System.out.println("请输入第二个正整数：");
		int b = scanner.nextInt();

		int maxCommonDivisor = maxCommonDivisor(a, b);
		System.out.println("最大公约数：" + maxCommonDivisor);

		int minCommonMultiple = (a * b) / maxCommonDivisor;
		System.out.println("最小公倍数：" + minCommonMultiple);

		scanner.close();
	}

	/**
	 * 获取num1和num2的最大公约数
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int maxCommonDivisor(int num1, int num2) {
		int result = 1;
		int tmp = num1 > num2 ? num2 : num1;
		for (int i = 2; i <= tmp; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				result = i * result;
				num1 = num1 / i;
				num2 = num2 / i;
				i = 1;
			}
		}
		return result;
	}
}