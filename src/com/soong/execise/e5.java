/**
 * 
 */
package com.soong.execise;

import java.util.Scanner;

/**
 * ������5�� ��Ŀ�����������������Ƕ������ɴ��⣺ѧϰ�ɼ�>=90�ֵ�ͬѧ��A��ʾ��60-89��֮�����B��ʾ��60�����µ���C��ʾ��
 */
public class e5 {
	public static void main(String[] args) {
		System.out.println("������ѧ���ɼ���");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();

		boolean condition = true;
		if (condition) {
			// do1
		} else {
			// do2
		}

		String result = a >= 90 ? "A" : (60 <= a && a < 90 ? "B" : "C");

		System.out.println("��ѧ������������Ϊ��" + result);
	}
}