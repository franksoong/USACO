/*
ID: xinkun.2
LANG: JAVA
TASK: palsquare
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */

public class palsquare {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("palsquare.in"));
		PrintWriter writter = new PrintWriter(new File("palsquare.out"));

		int base = reader.nextInt();
		int start = 1;
		int end = 300;

		for (int i = start; i <= end; i++) {
			int square = i * i;
			String square_b = convert_to_base(square, base);
			if (is_huiwen(square_b)) {
				String i_base = convert_to_base(i, base);

				writter.println(i_base + " " + square_b);
			}
		}

		writter.close();
		reader.close();

	}

	public static String convert_to_base(int num, int base) {
		StringBuilder s = new StringBuilder();
		for (int current = num; current > 0; current /= base) {
			int reminder = current % base;

			String to_str = String.valueOf(reminder);
			if (reminder >= 10) {
				char c = (char) ('A' + (reminder - 10));
				to_str = String.valueOf(c);
			}

			s.append(to_str);
		}

		return s.reverse().toString();
	}

	public static boolean is_huiwen(String input) {
		boolean result = true;

		int len = input.length();
		for (int i = 0; i < len / 2; i++) {
			char first = input.charAt(i);
			char last = input.charAt(len - 1 - i);
			if (first != last) {
				result = false;
				break;
			}
		}

		return result;
	}

}
