package com.soong.execise;

/**
 * @author Administrator
 *
 */
public class a1 {

	int i = 1; // ��������i
	int j = 2;

	public void print() {
		System.out.println(i);
		System.out.println(j);
	}

	public static void method1(int i) { // ����Ҳ��i
		System.out.println(i);
	}

	public static void method2() {
		int j = 8;
		System.out.println(j);
	}

	public static void main(String[] args) {
		new a1().print();

		method1(5); // �����ӡ������ 1����5?

		method2(); // �����ӡ������ 2����8?
	}

}
