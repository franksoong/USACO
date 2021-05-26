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

class palsquare {

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
			String square = to_number_of_base(i * i, base);
			if (is_palindromic(square)) {
				result.add(to_number_of_base(i, base) + " " + square);
			}
		}

		return result;
	}

	static String to_number_of_base(int number, int base) {
		StringBuilder res = new StringBuilder();
		while (number > 0) {
			int reminder = number % base;
			if (reminder < 10) {
				res.append((char) ('0' + reminder));
			} else {
				int offset = reminder - 10;
				res.append((char) ('A' + offset));
			}

			number = number / base;
		}
		return res.reverse().toString();
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
