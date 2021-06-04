/**
 * 
 */
package com.train.usaco;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class utils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		is_narcissistic(132);
	}

	// template start
	public static void template(String[] args) throws IOException {
		String taskName = "template";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		int size = reader.nextInt();
		String data = reader.next();
		reader.next().toCharArray();

		String result = solve(size, data);
		writter.println(result);

		writter.close();
		reader.close();
	}

	private static String solve(int size, String data) {
		// TODO Auto-generated method stub
		return null;
	}
	// template end

	public static ArrayList<String> read_dict() throws IOException {
		Scanner reader = new Scanner(new File("dict.txt"));
		ArrayList<String> dict = new ArrayList<String>();

		while (reader.hasNext()) {
			dict.add(reader.next());
		}

		return dict;

	}

	public static boolean DEBUG = true;

	public static void log(String label, long start) {
		if (DEBUG) {
			long end = System.currentTimeMillis();
			System.out.println(label + ": " + (end - start));
		}
	}

	public static ArrayList<String> generate_combination(String num, HashMap<Character, char[]> keypad) {
		ArrayList<String> names = new ArrayList<String>();

		int len = num.length();

		// problem1: 1
		char key = num.charAt(0);
		char[] problem1 = keypad.get(key);
		ArrayList<String> problem1_result = new ArrayList<String>();
		for (char c : problem1) {
			problem1_result.add(String.valueOf(c));
		}

		// basic
		if (len == 1) {
			return problem1_result;
		}

		// problem2: len-1
		String sub_num = num.substring(1);
		ArrayList<String> problem2 = generate_combination(sub_num, keypad);

		for (String p1 : problem1_result) {
			for (String p2 : problem2) {
				String item = p1 + p2;
				names.add(item);
			}
		}

		return names;
	}

	public static boolean is_same_matrix(char[][] m1, char[][] m2, int size) {
		boolean result = true;

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (m1[x][y] != m2[x][y]) {
					// early return
					return false;
				}
			}
		}

		return result;
	}

	// fib start
	public static int fib_naive(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fib_naive(n - 1) + fib_naive(n - 2);
		}
	}

	static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

	public static int fib(int n) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		int value = 0;
		if (n == 1 || n == 2) {
			value = 1;
		} else {
			value = fib(n - 1) + fib(n - 2);
		}
		memo.put(n, value);
		return value;
	}

	public static int fib_v2(int n) {
		int[] a = new int[n + 1];
		a[0] = 0;
		a[1] = 1;

		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}

		return a[n];
	}
	// fib end

	// narcissistic start
	public static int get_digit(int number, int weight) {
		return number % (weight * 10) / weight;
	}

	public static int[] convert_to_array(int number) {

		char[] temp = String.valueOf(number).toCharArray();
		int[] result = new int[temp.length];

		for (int i = 0; i < temp.length; i++) {
			result[i] = Integer.valueOf(String.valueOf(temp[i]));
		}

		return result;
	}

	public static boolean is_narcissistic(int number) {
		boolean result = false;

		int value = 0;
		int[] digits = convert_to_array(number);
		for (int i : digits) {
			value += Math.pow(i, 3);
		}
		if (value == number) {
			result = true;
		}

		return result;
	}

	// narcissistic end

	public static boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			return year % 400 == 0;
		} else {
			return year % 4 == 0;
		}
	}

	// 给定数组，生成两两组合
	public static ArrayList<Tuple2<Integer>> generate_wormhole_combinations(int count) {
		ArrayList<Tuple2<Integer>> result = new ArrayList<Tuple2<Integer>>();

		ArrayList<Integer> indexes = new ArrayList<Integer>() {
			{
				for (int i = 0; i < count; i++) {
					add(i);
				}
			}
		};

		if (indexes.size() >= 2) {
			for (int i = 0; i < indexes.size(); i++) {
				result.addAll(generate_subset(indexes.subList(i, indexes.size())));
			}
		}

		return result;
	}

	public static ArrayList<Tuple2<Integer>> generate_subset(List<Integer> list) {
		ArrayList<Tuple2<Integer>> result = new ArrayList<Tuple2<Integer>>();

		for (int j = 1; j < list.size(); j++) {
			result.add(new Tuple2<Integer>(list.get(0), list.get(j)));
		}

		return result;
	}

	public static class Tuple2<T1> {
		public final T1 item1;
		public final T1 item2;

		public Tuple2(T1 item1, T1 item2) {
			this.item1 = item1;
			this.item2 = item2;
		}
	}

	public static int get_offset(int start, int shift, int length) {
		int result = (start + shift) % length;
		if (result < 0) {
			result += length;
		}
		return result;
	}

	// 给定数组，生成两两配对

}
