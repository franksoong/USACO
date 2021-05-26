
/*
ID: xinkun.2
LANG: JAVA
TASK: milk2
 */

// https://train.usaco.org/usacoprob2?a=9302IKLv7bi&S=milk2
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class milk2 {
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

		String result = solve_v2(starts, ends);

		writter.println(result);

		writter.close();
		reader.close();
	}

	public static String solve_v2(int[] starts, int[] ends) {
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
			Span curr = spans.get(i);
			maxWork = Math.max(maxWork, curr.length());

			if (i + 1 < spans.size()) {
				Span next = spans.get(i + 1);
				maxIdle = Math.max(maxIdle, curr.distance(next));
			}
		}

		return String.format("%d %d", maxWork, maxIdle);
	}

	public static class Span implements Comparable<Span> {
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

	private static String solve(int[] starts, int[] ends) {
		// private static String solve_backup(int[] starts, int[] ends) {
		// sort
		int length = starts.length;
		int[] starts_sorted = new int[length];
		int[] ends_sorted = new int[length];

		Integer[] indices = sort_index(starts);
		for (int i = 0; i < indices.length; i++) {
			int j = indices[i];
			starts_sorted[i] = starts[j];
			ends_sorted[i] = ends[j];
		}

		// merge
		int merged_last = 0;
		ArrayList<Integer> starts_merged = new ArrayList<Integer>();
		ArrayList<Integer> ends_merged = new ArrayList<Integer>();

		starts_merged.add(starts_sorted[0]);
		ends_merged.add(ends_sorted[0]);

		for (int i = 1; i < length; i++) {
			int e = ends_merged.get(merged_last);

			int s1 = starts_sorted[i];
			int e1 = ends_sorted[i];

			// if overlap
			if (s1 <= e) {
				int merged_end = Math.max(e1, e);

				ends_merged.set(merged_last, merged_end);
			} else {
				// we find a new span without overlap
				starts_merged.add(s1);
				ends_merged.add(e1);
				merged_last++;
			}
		}

		// max
		int max_span_length = 0;
		int max_gap_length = 0;

		if (starts_merged.size() == 1) {
			max_span_length = ends_merged.get(0) - starts_merged.get(0);
		} else {
			for (int i = 0; i < starts_merged.size() - 1; i++) {
				int s = starts_merged.get(i);
				int e = ends_merged.get(i);

				int s2 = starts_merged.get(i + 1);
				int e2 = ends_merged.get(i + 1);

				int span1_length = e - s;
				int span2_length = e2 - s2;
				int gap_length = s2 - e;

				max_span_length = Math.max(max_span_length, Math.max(span1_length, span2_length));
				max_gap_length = Math.max(max_gap_length, gap_length);
			}
		}

		String result = String.format("%d %d", max_span_length, max_gap_length);
		return result;
	}

	public static Integer[] sort_index(int[] values) {
		int length = values.length;
		Integer[] indices = new Integer[length];
		for (int i = 0; i < length; i++) {
			indices[i] = i;
		}
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return values[arg0] - values[arg1];
			}
		};
		Arrays.sort(indices, comparator);
		return indices;

		// System.out.println(Arrays.toString(indices));
		// return Arrays.stream(indices).mapToInt(Integer::valueOf).toArray();
	}

	//
	public static String solve2(int[] starts, int[] ends) {
		// sort
		// merge
		// search max - loop

		int length = starts.length;
		ArrayList<Integer> starts_sorted = new ArrayList<Integer>();
		ArrayList<Integer> ends_sorted = new ArrayList<Integer>();
		ArrayList<Integer> merged_spans = new ArrayList<Integer>();

		// sort
		Integer[] indices = sort_index(starts);
		for (int i = 0; i < length; i++) {
			int indice = indices[i];
			starts_sorted.add(starts[indice]);
			ends_sorted.add(ends[indice]);
		}

		// merge
		int current_span = 0;
		merged_spans.add(current_span);
		for (int i = 1; i < length; i++) {
			int e1 = ends_sorted.get(current_span);

			int s2 = starts_sorted.get(i);
			int e2 = ends_sorted.get(i);

			// if has overlap on current_span
			if (s2 <= e1) {
				int max_end = Math.max(e1, e2);
				// merge into current_span
				ends_sorted.set(current_span, max_end);
			} else {
				// we find a new span without overlap
				current_span = i;
				merged_spans.add(current_span);
			}
		}

		ArrayList<Integer> starts_merged = new ArrayList<Integer>();
		ArrayList<Integer> ends_merged = new ArrayList<Integer>();
		for (int i = 0; i < merged_spans.size(); i++) {
			int j = merged_spans.get(i);
			starts_merged.add(starts_sorted.get(j));
			ends_merged.add(ends_sorted.get(j));
		}

		// max span / max work - for loop
		// max space / max idle - for loop
		int max_span = ends_merged.get(0) - starts_merged.get(0);
		int max_space = 0;
		for (int i = 0; i < starts_merged.size() - 1; i++) {
			int s1 = starts_merged.get(i);
			int e1 = ends_merged.get(i);

			int s2 = starts_merged.get(i + 1);
			int e2 = ends_merged.get(i + 1);

			max_span = Math.max(max_span, Math.max(e1 - s1, e2 - s2));
			max_space = Math.max(max_space, s2 - e1);
		}

		return String.format("%d %d", max_span, max_space);
	}
}
