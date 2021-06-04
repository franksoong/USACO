/*
ID: xinkun.2
LANG: JAVA
TASK: palsquare
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class palsquare_v1 {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("palsquare.in"));
		PrintWriter writter = new PrintWriter(new File("palsquare.out"));

		int base = reader.nextInt();
		int start = 1;
		int end = 300;

		ArrayList<String> result = solve(base, start, end);
		result.forEach((item) -> {
			writter.println(item);
		});

		writter.close();
		reader.close();
	}

	public static ArrayList<String> solve(int base, int start, int end) {
		ArrayList<String> result = new ArrayList<String>();

		for (int i = start; i <= end; i++) {
			String square = convert_to_base(i * i, base);
			if (is_palindromic(square)) {
				result.add(convert_to_base(i, base) + " " + square);
			}
		}

		return result;
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
		for (int i = number.length() - 1; i >= 0; i--) {
			int weight = (int) Math.pow(base, i);
			int digit = Integer.valueOf(number.charAt(i));
			weighted_sum += digit * weight;
		}
		return weighted_sum;
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
}
