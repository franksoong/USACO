/**
 * 
 */
package com.soong.execise;

import java.util.Scanner;

/**
 * ������4�� ��Ŀ����һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
 */
public class e4 {
	public static void main(String[] args) {
		System.out.print("��������Ҫ�ֽ�������������");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();// ��ȡ���������
		decompose(a);
	}

	/**
	 * �ֽ�������
	 * 
	 * @param num
	 * @return
	 */
	public static void decompose(int num) {
		int tmp = num / 2;
		for (int i = 2; i <= tmp; i++) {
			if (num % i == 0) {
				num = num / i;
				System.out.println("������Ϊ��" + i);
				i = 1;
				continue;
			}
		}
	}
}
