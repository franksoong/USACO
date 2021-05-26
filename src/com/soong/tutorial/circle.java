/**
 * 
 */
package com.soong.tutorial;

/**
 * @author Administrator
 *
 */
public class circle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int result1 = get_offset(9, 100, 24);
		int result2 = get_offset(9, -100, 24);

		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);

		temp();
	}

	public static int get_offset(int start, int shift, int length) {
		int result = (start + shift) % length;
		if (result < 0) {
			result += length;
		}
		return result;
	}

	public static void temp() {
		// TODO Auto-generated method stub
		int current_time = 9;

		int offset = 100;

		int length = 24;

		int result = (current_time + offset) % length;

		System.out.println("result: " + result);

		int offset2 = 100;
		int result2 = (current_time - offset2) % length;
		if (result2 < 0) {
			result2 += length;
		}
		System.out.println("result2: " + result2);

	}

}
