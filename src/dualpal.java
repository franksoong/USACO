/*
ID: xinkun.2
LANG: JAVA
TASK: dualpal
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class dualpal {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("dualpal.in"));
		PrintWriter writter = new PrintWriter(new File("dualpal.out"));

		int count = reader.nextInt();
		int start = reader.nextInt() + 1;

		ArrayList<Integer> result = solve(start, count);
		result.forEach((item) -> {
			writter.println(item);
		});

		writter.close();
		reader.close();
	}

	public static ArrayList<Integer> solve(int start, int count) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int number = start; result.size() < count; number++) {

			int palindromic_cases = 0;
			for (int base = 2; base <= 10 && palindromic_cases < 2; base++) {
				String number2 = to_number_of_base(number, base);
				if (is_palindromic(number2)) {
					palindromic_cases++;
				}
			}
			if (palindromic_cases == 2) {
				result.add(number);
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
