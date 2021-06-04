/*
ID: xinkun.2
LANG: JAVA
PROG: skidesign
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class skidesign {

	public static void main(String[] args) throws Exception {
		String taskName = "skidesign";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		int limit = 100;
		int count = reader.nextInt();
		int[] hills = new int[count];
		for (int i = 0; i < count; i++) {
			hills[i] = reader.nextInt();
		}

		int result = solve(hills, limit);

		writter.println(result);

		writter.close();
		reader.close();
	}

	public static int solve(int[] hills, int limit) {
		int total = Integer.MAX_VALUE;
		int rule = 17;

		// loop each case of height
		for (int h = 0; h <= limit - rule; h++) {
			int low_bound = h;
			int high_bound = h + rule;

			// loop each hill
			int cost_for_case = 0;
			int diff = 0;
			for (int hill : hills) {
				if (hill < low_bound) {
					diff = low_bound - hill;
				} else if (hill > high_bound) {
					diff = high_bound - hill;
				} else {
					diff = 0;
				}
				cost_for_case += diff * diff;
			}

			total = Math.min(cost_for_case, total);
		}
		return total;
	}
}
