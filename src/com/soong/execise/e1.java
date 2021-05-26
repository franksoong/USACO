/**
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？ 
 * 
 * 分析
 * 1月 1对， 
 * 2月 1对，
 * 3月 2对，
 * 4月 3对，
 * 5月 5对，
 * 6月 8对，
 * 7月 13对，
 * 8月 21对
 */

package com.soong.execise;

import java.util.HashMap;
import java.util.Scanner;

public class e1 {

	public static void main(String[] args) {
		System.out.print("请输入你想知道的兔子数量的月份：");
		Scanner scanner = new Scanner(System.in);

		int month = scanner.nextInt();// 获取输入的整数

		System.out.println(solve_v0(month));
		scanner.close();
	}

	// recursive
	public static int solve(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return solve(n - 1) + solve(n - 2);
		}
	}

	public static int solve_v0(int n) {
		return solve_v0_with_log(n, 0);
	}

	public static int solve_v0_with_log(int n, int level) {
		System.out.println("->".repeat(level) + "call fn for " + n);

		int value = 0;
		if (n == 1 || n == 2) {
			value = 1;
		} else {
			value = solve_v0_with_log(n - 1, level + 1) + solve_v0_with_log(n - 2, level + 1);
		}

		System.out.println("->".repeat(level) + "return for " + n + "\n");
		return value;
	}

	static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

	public static int solve2(int n) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		int value = 0;
		if (n == 1 || n == 2) {
			value = 1;
		} else {
			value = solve2(n - 1) + solve2(n - 2);
		}
		memo.put(n, value);
		return value;
	}

	public static int solve3(int n) {
		int[] a = new int[n + 1];
		a[0] = 0;
		a[1] = 1;

		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}

		return a[n];
	}

}