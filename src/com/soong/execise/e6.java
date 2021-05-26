/**
 * 
 */
package com.soong.execise;

import java.util.Scanner;

/**
 * ������6�� ��Ŀ����������������m��n���������Լ������С��������
 */
public class e6 {
	public static void main(String[] args) {
		System.out.println("�������һ����������");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();

		System.out.println("������ڶ�����������");
		int b = scanner.nextInt();

		int maxCommonDivisor = maxCommonDivisor(a, b);
		System.out.println("���Լ����" + maxCommonDivisor);

		int minCommonMultiple = (a * b) / maxCommonDivisor;
		System.out.println("��С��������" + minCommonMultiple);

		scanner.close();
	}

	/**
	 * ��ȡnum1��num2�����Լ��
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