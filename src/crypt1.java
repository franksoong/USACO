
/*
ID: xinkun.2
LANG: JAVA
TASK: crypt1
 */

// https://train.usaco.org/usacoprob2?a=VS38zBrULrH&S=crypt1
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class crypt1 {
	public static void main(String[] args) throws IOException {
		String taskName = "crypt1";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		int count = reader.nextInt();
		int[] numbers = new int[count];
		for (int i = 0; i < count; i++) {
			numbers[i] = reader.nextInt();
		}

		int result = solve(numbers);

		writter.println(result);

		writter.close();
		reader.close();
	}

	public static int solve(int[] numbers) {
		ArrayList<String> result = new ArrayList<String>();
		HashSet<Integer> sets = convert_to_set(numbers);
		Range range = new Range(numbers);

		for (int i = range.min_3bit; i <= range.max_3bit; i++) {
			for (int j = range.min_2bit; j <= range.max_2bit; j++) {
				int product_p1 = i * (j % 10);
				int product_p2 = i * (j / 10);
				int product = i * j;

				// condition1: only allow three digit partial-products
				// condition2: all digits should be contained in sets
				if (product_p1 < 1000 && product_p2 < 1000 && check(i, sets) && check(j, sets)
						&& check(product_p1, sets) && check(product_p2, sets) && check(product, sets)) {
					result.add(" " + i + " " + j + " " + product_p1 + " " + product_p2 + " " + product);
				}
			}
		}
		System.out.println(result);
		return result.size();
	}

	public static boolean check(int product, HashSet<Integer> sets) {
		boolean result = true;

		// if (product > 999) {
		// return false;
		// }

		for (char c : String.valueOf(product).toCharArray()) {
			if (!sets.contains(Integer.valueOf(String.valueOf(c)))) {
				result = false;
				break;
			}
		}

		return result;
	}

	public static HashSet<Integer> convert_to_set(int[] numbers) {
		HashSet<Integer> sets = new HashSet<Integer>();
		for (int item : numbers) {
			sets.add(item);
		}
		return sets;
	}

	public static class Range {
		public int max_3bit;
		public int min_3bit;
		public int max_2bit;
		public int min_2bit;

		public Range(int[] numbers) {
			Arrays.sort(numbers);

			int len = numbers.length - 1;
			int min = numbers[0];
			int max = numbers[len];
			this.min_3bit = Integer.valueOf("" + min + min + min);
			this.max_3bit = Integer.valueOf("" + max + max + max);
			this.min_2bit = Integer.valueOf("" + min + min);
			this.max_2bit = Integer.valueOf("" + max + max);
		}
	}
}
