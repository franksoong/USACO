/**
 * 
 */
package com.soong.execise;

import java.util.ArrayList;

/**
 * ������2�� ��Ŀ���ж�101-200֮���ж��ٸ����������������������
 * 
 * ������ ʲô��������ֻ�ܱ��Լ���1����������
 * 
 * 1, func - �ж�����
 * 
 * 2, for loop
 * 
 * 3, result - arraylist
 * 
 */

public class e2 {
	public static void main(String[] args) {
		ArrayList<Integer> result = solve(101, 200);

		ArrayList<Integer> result2 = solve_v2(101, 200);

		System.out.println(result.toString());

		System.out.println(result2.toString());
	}

	/**
	 * @param i
	 * @param j
	 */
	private static ArrayList<Integer> solve(int i, int j) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int j2 = i; j2 <= j; j2++) {
			if (isPrime(j2)) {
				list.add(j2);
			}
		}

		return list;
	}

	private static ArrayList<Integer> solve_v2(int i, int j) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int j2 = i; j2 <= j; j2++) {
			if (isPrime_v2(j2)) {
				list.add(j2);
			}
		}

		return list;
	}

	private static boolean isPrime_v2(int number) {
		boolean result = true;

		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				result = false;
				break;
			}
		}

		return result;
	}

	private static boolean isPrime(int number) {
		boolean result = true;

		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				result = false;
				break;
			}
		}

		return result;
	}
}

// public class e2 {
// public static void main(String[] args) {
// solve(101, 200);
// }
//
// public static void solve(int a, int b) {
// int sum = 0;
// if (a >= b) {
// System.out.println("a���ܴ��ڵ���b��");
// }
// System.out.print("������");
// for (int i = a; i < b; i++) {
// if (isPrimeNumber(i)) {
// sum += 1;
// System.out.print(i + " ");
// }
// }
// System.out.println();
// System.out.println("��������������" + sum);
// }
//
// public static boolean isPrimeNumber(int i) {
// boolean flag = true;
// for (int j = 2; j <= i / 2; j++) {
// if (i % j == 0) {
// flag = false;
// break;
// }
// }
// return flag;
// }
// }