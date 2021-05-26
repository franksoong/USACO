
/*
ID: xinkun.2
LANG: JAVA
TASK: milk2
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class milk2_back {
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("milk2.in"));
		PrintWriter writter = new PrintWriter(new File("milk2.out"));

		int count = reader.nextInt();
		int[] starts = new int[count];
		int[] ends = new int[count];
		for (int i = 0; i < count; i++) {
			starts[i] = reader.nextInt();
			ends[i] = reader.nextInt();
		}

		String result = (new MilkProblem()).solve0(starts, ends);

		// output result
		writter.println(result);

		writter.close();
		reader.close();

	}

	static class Span implements Comparable<Span> {
		int start;
		int end;

		public Span(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public void merge(Span other) {
			start = Math.min(start, other.start);
			end = Math.max(end, other.end);
		}

		public boolean overlap(Span other) {
			if (other.start >= start && other.start <= end) {
				return true;
			}

			if (start >= other.start && start <= other.end) {
				return true;
			}

			return false;
		}

		public int compareTo(Span o) {
			return start - o.start;
		}

		public int length() {
			return end - start;
		}

		public int distance(Span other) {
			return other.start - end;
		}

		public String toString() {
			return String.format("<%d, %d>", start, end);
		}
	}

	static class MilkProblem {
		public String solve(int[] starts, int[] ends) {
			ArrayList<Span> spans = new ArrayList<Span>();
			for (int i = 0; i < starts.length; i++) {
				spans.add(new Span(starts[i], ends[i]));
			}
			Collections.sort(spans);
			for (int i = 0; i < spans.size() - 1;) {
				Span curr = spans.get(i);
				Span next = spans.get(i + 1);
				if (curr.overlap(next)) {
					curr.merge(next);
					spans.remove(i + 1);
				} else {
					i++;
				}
			}

			int maxWork = 0;
			int maxIdle = 0;

			for (int i = 0; i < spans.size(); i++) {
				maxWork = Math.max(maxWork, spans.get(i).length());
				if (i + 1 < spans.size())
					maxIdle = Math.max(maxIdle, spans.get(i).distance(spans.get(i + 1)));

			}
			return String.format("%d %d", maxWork, maxIdle);
		}

		// solve0 below
		public String solve0(int[] starts, int[] ends) {
			int tmin = starts[0];
			int tmax = ends[0];
			for (int i = 0; i < starts.length; i++) {
				tmin = Math.min(tmin, starts[i]);
				tmax = Math.max(tmax, ends[i]);
			}

			boolean[] milking = new boolean[tmax - tmin];
			for (int i = 0; i < starts.length; i++) {
				for (int j = starts[i] - tmin; j < ends[i] - tmin; j++) {
					milking[j] = true;
				}
			}

			int maxWork = count(milking, true);
			int maxIdle = count(milking, false);
			return String.format("%d %d", maxWork, maxIdle);
		}

		private int count(boolean[] milking, boolean work) {
			int start = 0;
			boolean counting = false;
			for (int i = 0; i < milking.length; i++) {
				if (milking[i] == work) {
					counting = true;
					start = i;
					break;
				}
			}

			if (!counting)
				return 0;

			int res = 0;
			for (int i = start; i < milking.length; i++) {
				if (milking[i] != work && counting) {
					counting = false;
					res = Math.max(res, i - start);
				} else if (milking[i] == work && !counting) {
					counting = true;
					start = i;
				}
			}
			if (counting) {
				res = Math.max(res, milking.length - start);
			}
			return res;
		}
	}
}
