/*
ID: xinkun.2
LANG: JAVA
TASK: palsquare
*/

import java.io.IOException;
import java.util.HashMap;

class palsquare_prepare {

	public static void main(String[] args) throws IOException {
		// test();
		test_char_int_string_conversion();
		// notation();
	}

	public static void test_char_int_string_conversion() {
		// string -> int
		String my_string1 = "5678";
		int my_res1 = Integer.valueOf(my_string1);
		System.out.println("my_res1: " + my_res1);

		// int->String
		int my_int = 789;
		String my_string = String.valueOf(my_int);
		System.out.println("my_string: " + my_string);

		// char ->int
		char my_char = 'A';
		char my_char2 = '5';

		int my_int1 = Integer.valueOf(my_char);
		System.out.println("my_int1: " + my_int1);

		int my_int2 = Integer.valueOf(my_char2);
		System.out.println("my_int2: " + my_int2);

		// char->string->int
		int my_int3 = Integer.valueOf(String.valueOf(my_char2));
		System.out.println("my_int3: " + my_int3);

		// int->char
		int int_a = 65;
		char a = (char) int_a;
		System.out.println("a: " + a);
	}

	public static void name() {
		HashMap<String, String> map = new HashMap<String, String>() {
			{
				put("name", "test");
				put("age", "20");
			}
		};
		System.out.println(map);
	}

	public static void test() {
		int data = 5123; // 512
		int[] bases = new int[] { 2, 8, 16, 20 };
		String[] converted = new String[4];

		System.out.println(data);
		for (int i = 0; i < bases.length; i++) {
			int base = bases[i];
			String item = convert_to_base(data, base);
			converted[i] = item;

			System.out.println("base " + base + ": " + item);
		}

		System.out.println();
		for (int i = 0; i < converted.length; i++) {
			String item = converted[i];
			int num = convert_back(item, bases[i]);

			System.out.println(item + ": " + num);
		}
	}

	static String convert_to_base(int number, int base) {
		StringBuilder res = new StringBuilder();
		for (int current = number; current > 0; current = current / base) {
			int reminder = current % base;
			String part = String.valueOf(reminder);
			if (reminder >= 10) {
				part = String.valueOf((char) ('A' + reminder - 10));
			}

			res.append(part);
		}
		return res.reverse().toString();
	}

	static int convert_back(String number, int base) {
		int weighted_sum = 0;
		for (int i = 0; i < number.length(); i++) {
			int digit = convert_char_to_number(number.charAt(i));
			if (digit > 0) {
				int weight = (int) Math.pow(base, number.length() - 1 - i);
				weighted_sum += digit * weight;
			}
		}
		return weighted_sum;
	}

	public static int convert_char_to_number(char c) {
		int digit = 0;
		if (c > 'A') {
			digit = c - 'A' + 10;
		} else {
			digit = Integer.valueOf(String.valueOf(c));
		}
		return digit;
	}

	static boolean is_palindromic(String string) {
		int len = string.length();
		for (int i = 0; i < len / 2; i++) {
			if (string.charAt(i) != string.charAt(len - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void notation() {
		int normal = 10;
		int base_8 = 012;
		int base_16 = 0xA;

		System.out.println("normal: " + normal);
		System.out.println("base_8: " + base_8);
		System.out.println("base_16: " + base_16);

	}

}
