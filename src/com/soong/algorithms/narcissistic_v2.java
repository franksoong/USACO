package com.soong.algorithms;

/**
Narcissistic number
1^3 + 5^3+ 3^3 = 153

Conditions
the number is between 99 and 1000
get the number on its ones place, tens place and hundreds place
if the sum of the cube of each place is equal to the number itself, print the number


Write a program to find out all the narcissistic number
 */

import java.util.ArrayList;

public class narcissistic_v2 {

	public static void main(String[] args) {
		ArrayList<Integer> result = get_narcissistic_number_v2(89, 500);

		print_list(result);

		result = get_narcissistic_number_v3(89, 500);

		print_list(result);
	}

	public static int get_digit(int number, int flag) {
		return number % (flag * 10) / flag;
	}

	private static void print_list(ArrayList list) {
		list.forEach(item -> System.out.println(item));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// }
	}

	public static int[] convert_to_array(int number) {
		String item_string = String.valueOf(number);
		int len = item_string.length();
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = Integer.valueOf(String.valueOf(item_string.charAt(i)));
		}
		return result;
	}

	public static ArrayList<Integer> get_narcissistic_number_v3(int from, int to) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int item = from; item < to; item++) {
			int[] digits = convert_to_array(item);

			int sum = 0;
			for (int i = 0; i < digits.length; i++) {
				sum += (int) (Math.pow(digits[i], 3));
			}

			if (sum == item) {
				result.add(item);
			}
		}

		return result;
	}

	// 重构和泛化
	public static ArrayList<Integer> get_narcissistic_number_v2(int from, int to) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int item = from; item < to; item++) {
			int a = get_digit(item, 1);
			int b = get_digit(item, 10);
			int c = get_digit(item, 100);
			int d = get_digit(item, 1000);

			int sum = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) + +Math.pow(d, 3));
			if (sum == item) {
				result.add(item);
			}
		}

		return result;
	}

	public static void get_narcissistic_number_v0() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int item = 99; item < 1000; item++) {
			int a = (item % 10) / 1;
			int b = (item % 100) / 10;
			int c = (item % 1000) / 100;

			int sum = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
			if (sum == item) {
				result.add(item);
			}
		}

		result.forEach(item -> System.out.println(item));
	}

}
