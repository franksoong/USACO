/*
ID: xinkun.2
LANG: JAVA
PROG: ariprog
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ariprog {

	public static void main(String[] args) throws Exception {
		String taskName = "ariprog";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		// length of arithmetic progressions to search
		int length = reader.nextInt();
		// upper bound for bisquares (p^2+q^2) with p and q being less than M
		int bound = reader.nextInt();

		ArrayList<Tuple> results = solve(bound, length);
		if (results.size() == 0) {
			writter.println("NONE");
		} else {
			for (Tuple item : results) {
				writter.println(item.item1 + " " + item.item2);
			}
		}

		writter.close();
		reader.close();
	}

	public static ArrayList<Tuple> solve(int bound, int length) {
		int max = bound * bound * 2;

		// generate set
		boolean[] bisquares = new boolean[max + 1];
		for (int p = 0; p <= bound; p++) {
			for (int q = 0; q <= bound; q++) {
				bisquares[p * p + q * q] = true;
			}
		}

		ArrayList<Tuple> results = new ArrayList<Tuple>();
		for (int a = 0; a < max; a++) {
			if (!bisquares[a]) {
				continue;
			}

			// for case region: bisquares[a] - bisquares[a + b * k]
			arithmetic_progression_detect: for (int b = 1; b <= (max - a) / (length - 1); b++) {
				// do arithmetic progression
				for (int k = 1; k < length; k++) {
					if (!bisquares[a + b * k]) {
						continue arithmetic_progression_detect;
					}
				}

				// we hit one
				Tuple arithmetic_progression = new Tuple(a, b);
				results.add(arithmetic_progression);
			}
		}

		// sort based on b
		Collections.sort(results);

		return results;
	}

	public static class Tuple implements Comparable<Tuple> {
		public final int item1;
		public final int item2;

		public Tuple(int item1, int item2) {
			this.item1 = item1;
			this.item2 = item2;
		}

		@Override
		public int compareTo(Tuple o) {
			return this.item2 - o.item2;
		}
	}

}
