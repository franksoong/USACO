package com.soong.execise;

/**
 * @author Administrator
 *
 */
public class a1 {

	int i = 1; // 属性名是i
	int j = 2;

	public void print() {
		System.out.println(i);
		System.out.println(j);
	}

	public static void method1(int i) { // 参数也是i
		System.out.println(i);
	}

	public static void method2() {
		int j = 8;
		System.out.println(j);
	}

	public static void main(String[] args) {
		new a1().print();

		method1(5); // 结果打印出来是 1还是5?

		method2(); // 结果打印出来是 2还是8?
	}

}
