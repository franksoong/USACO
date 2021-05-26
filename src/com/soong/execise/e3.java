/**
 * 
 */
package com.soong.execise;

import java.util.ArrayList;

/***
 * ������3�� ��Ŀ����ӡ�����еġ�ˮ�ɻ���������ν��ˮ�ɻ�������ָһ����λ�������λ���������͵��ڸ�������
 * 
 * 
 * ���磺153��һ����ˮ�ɻ���������Ϊ153=1�����η���5�����η���3�����η���
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

		System.out.println("ˮ�ɻ�����" + result.toString());
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
		int num1 = a % 10; // ��λ
		int num2 = (a % 100) / 10; // ʮλ
		int num3 = (a % 1000) / 100; // ��λ

		if (Math.pow(num1, 3) + Math.pow(num2, 3) + Math.pow(num3, 3) == a) {
			return true;
		}
		return false;
	}
}