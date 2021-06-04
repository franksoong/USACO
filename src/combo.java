
/*
ID: xinkun.2
LANG: JAVA
TASK: combo
 */

// https://train.usaco.org/usacoprob2?a=VS38zBrULrH&S=combo
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class combo {
	public static void main(String[] args) throws IOException {
		String taskName = "combo";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		int limit = reader.nextInt();
		int count = 3;
		ArrayList<int[]> combinations = new ArrayList<int[]>();
		for (int i = 0; i < 2; i++) {
			int[] comb = new int[count];
			for (int j = 0; j < count; j++) {
				comb[j] = reader.nextInt();
			}
			combinations.add(comb);
		}

		int result = solve(limit, combinations);

		writter.println(result);

		writter.close();
		reader.close();
	}

	public static int solve(int limit, ArrayList<int[]> combination) {
		ArrayList<String> result = new ArrayList<String>();

		for (int[] comb : combination) {

			ArrayList<Integer> digit1 = get_neighbours(comb[0], limit);
			ArrayList<Integer> digit2 = get_neighbours(comb[1], limit);
			ArrayList<Integer> digit3 = get_neighbours(comb[2], limit);

			for (int d1 : digit1) {
				for (int d2 : digit2) {
					for (int d3 : digit3) {
						String item = d1 + "," + d2 + "," + d3;
						if (!result.contains(item)) {
							result.add(item);
						}
					}
				}
			}
		}

		System.out.println(result);
		return result.size();
	}

	public static ArrayList<Integer> get_neighbours(int digit, int limit) {
		int distance = 2;
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		// circle move
		for (int d = -distance; d <= distance; d++) {
			int item = get_offset(digit - 1, d, limit) + 1;
			if (!neighbours.contains(item)) {
				neighbours.add(item);
			}
		}

		return neighbours;
	}

	public static int get_offset(int start, int shift, int length) {
		int result = (start + shift) % length;
		if (result < 0) {
			result += length;
		}
		return result;
	}
}
