/**
 * 
 */
package com.soong.execise;

import java.util.Scanner;

/**
 * ������10�� ��Ŀ��һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룻
 * 
 * ���n�����ʱ ����·���ܳ��Ⱥ��´η����ĸ߶ȡ�
 */
public class e7 {

	public static void main(String[] args) {
		System.out.println("��ѡ��ڼ�����أ�");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		solve(n);
	}

	public static void solve(int n) {
		double height = 100;
		double sumLength = 0;
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				sumLength = sumLength + height;
			} else {
				sumLength = sumLength + height * 2;
			}
			height = height / 2;
		}
		System.out.println("���˶�����Ϊ��" + sumLength);
		System.out.println("�����߶�Ϊ��" + height);
	}
}
