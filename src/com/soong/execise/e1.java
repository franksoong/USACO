/**
 * ��Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ����Ӷ���Ϊ���٣� 
 * 
 * ����
 * 1�� 1�ԣ� 
 * 2�� 1�ԣ�
 * 3�� 2�ԣ�
 * 4�� 3�ԣ�
 * 5�� 5�ԣ�
 * 6�� 8�ԣ�
 * 7�� 13�ԣ�
 * 8�� 21��
 */

package com.soong.execise;

import java.util.HashMap;
import java.util.Scanner;

public class e1 {

	public static void main(String[] args) {
		System.out.print("����������֪���������������·ݣ�");
		Scanner scanner = new Scanner(System.in);

		int month = scanner.nextInt();// ��ȡ���������

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