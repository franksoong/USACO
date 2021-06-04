
/*
ID: xinkun.2
LANG: JAVA
TASK: barn1
 */

// https://train.usaco.org/usacoprob2?a=HNeuVL2a5mW&S=barn1
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class barn1 {
	public static void main(String[] args) throws IOException {
		String taskName = "barn1";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		int m_boards = reader.nextInt();
		int s_stalls = reader.nextInt();
		int c_cows = reader.nextInt();

		int[] occupied_stalls = new int[c_cows];
		for (int i = 0; i < c_cows; i++) {
			occupied_stalls[i] = reader.nextInt();
		}

		int minimal_board_total_length = solve(m_boards, s_stalls, occupied_stalls);

		writter.println(minimal_board_total_length);

		writter.close();
		reader.close();
	}

	public static int solve(int m_boards, int s_stalls, int[] occupied_stalls) {
		// same question:
		// maximum the cut
		int len = occupied_stalls.length;
		Arrays.sort(occupied_stalls);

		// by default
		int total_length = occupied_stalls[len - 1] - occupied_stalls[0] + 1;
		int boards_count = 1;

		// 1, calculate intervals(gap)
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		for (int i = 0; i < len - 1; i++) {
			// we find a interval when distance >1
			if (occupied_stalls[i + 1] - occupied_stalls[i] > 1) {
				intervals.add(new Interval(occupied_stalls[i], occupied_stalls[i + 1]));
			}
		}

		// 2, cut
		Collections.sort(intervals, Collections.reverseOrder());
		for (int i = 0; i < intervals.size() && boards_count < m_boards; i++) {
			total_length -= intervals.get(i).lenght();
			boards_count++;
		}

		return total_length;
	}

	public static class Interval implements Comparable<Interval> {
		public int start;
		public int end;

		public Interval(int start, int end) {
			if (this.start > this.end) {
				// throw new Exception("Invalid");
				System.err.println("Invalid");
			}
			this.start = start;
			this.end = end;
		}

		public int lenght() {
			return this.end - this.start - 1;
		}

		@Override
		public int compareTo(Interval o) {
			return this.lenght() - o.lenght();
		}
	}

}
