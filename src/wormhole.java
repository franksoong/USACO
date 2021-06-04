
/*
ID: xinkun.2
LANG: JAVA
PROG: wormhole
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//TODO
// https://ac.nowcoder.com/acm/contest/view-submission?submissionId=47918257
public class wormhole {
	public static void main(String[] args) throws Exception {
		String taskName = "wormhole";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		int count = reader.nextInt();
		ArrayList<Point> coordinates = new ArrayList<Point>();
		for (int i = 0; i < count; i++) {
			double x = reader.nextInt();
			double y = reader.nextInt();

			Point p = new Point(x, y);
			coordinates.add(p);
		}

		int result = solve(coordinates, count);

		writter.println(result);

		writter.close();
		reader.close();
	}

	public static int solve(ArrayList<Point> coordinates, int count) {
		// 2 <= N <= 12
		int MAX = 20;

		int result = 0;
		Collections.sort(coordinates);

		ArrayList<Integer> indexes = new ArrayList<Integer>() {
			{
				for (int i = 0; i < count; i++) {
					add(i);
				}
			}
		};

		// generate all possibilities of wormholes
		ArrayList<ArrayList<Tuple2<Integer>>> wormholes = generate_wormholes(indexes);
		System.out.println(wormholes);

		// walk along x+
		// generate right array
		int[] next_on_right = new int[MAX];
		for (int i = 0; i < MAX; i++) {
			next_on_right[i] = -1;
		}

		for (int i = 0; i < count; i++) {
			Point p1 = coordinates.get(i);
			for (int j = 0; j < count; j++) {
				Point p2 = coordinates.get(j);
				if (p2.x - p1.x > 0 && p2.y == p1.y) {
					if (p2.x - p1.x < coordinates.get(next_on_right[i]).x - p1.x) {
						next_on_right[i] = j;
					}
				}
			}
		}

		for (ArrayList<Tuple2<Integer>> combination : wormholes) {
			// enumerate all wormhole as startpoints

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			combination.forEach((item) -> {
				map.put(item.item1, item.item2);
				map.put(item.item2, item.item1);
			});

			// hasCycle?

		}

		return result;
	}

	public static boolean has_cycle(ArrayList<Tuple2<Integer>> combination, ArrayList<Point> coordinates) {
		boolean result = false;

		HashSet<Integer> used = new HashSet<Integer>();
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < coordinates.size(); i++) {
			ArrayList<Integer> value = new ArrayList<Integer>();
			graph.put(i, value);
			for (int j = 0; j < coordinates.size(); j++) {
				// walk along x+
				if (i != j && coordinates.get(i).can_walk_to(coordinates.get(j))) {
					value.add(j);
				}
			}
			// walk through wormhole
			for (Tuple2<Integer> tuple : combination) {
				if (tuple.item1 == i && !used.contains(tuple.item2)) {
					value.add(tuple.item2);
					if (coordinates.get(i).y == coordinates.get(tuple.item2).y) {
						used.add(tuple.item1);
						used.add(tuple.item2);
					}
				}

				// add only once if same y
				if (tuple.item2 == i && !used.contains(tuple.item1)) {
					value.add(tuple.item1);
					if (coordinates.get(i).y == coordinates.get(tuple.item1).y) {
						used.add(tuple.item1);
					}
				}
			}
		}
		System.out.println(graph);

		int[] visited = new int[graph.keySet().size()];
		result = findCycle(graph, visited, 0, 0);

		return result;
	}

	public static boolean findCycle(HashMap<Integer, ArrayList<Integer>> graph, int[] visited, int node, int parent) {
		visited[node] = 1;

		boolean result = false;
		for (int w : graph.get(node)) {
			if (visited[w] == 0) {
				visited[w] = 1;
				result = findCycle(graph, visited, w, node);
			} else if (node != parent) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static int get_offset(int start, int shift, int length) {
		int result = (start + shift) % length;
		if (result < 0) {
			result += length;
		}

		return result;
	}

	public static ArrayList<ArrayList<Tuple2<Integer>>> generate_wormholes(List<Integer> indexes) {
		ArrayList<ArrayList<Tuple2<Integer>>> result = new ArrayList<ArrayList<Tuple2<Integer>>>();

		int len = indexes.size();
		int half = len / 2;
		ArrayList<Tuple2<Integer>> sub0 = new ArrayList<Tuple2<Integer>>();
		for (int i = 0; i < half; i++) {
			int first = 2 * i;
			int second = first + 1;
			sub0.add(new Tuple2<Integer>(indexes.get(first), indexes.get(second)));
		}
		result.add(sub0);

		for (int shift = 0; shift < half; shift++) {
			ArrayList<Tuple2<Integer>> sub = new ArrayList<Tuple2<Integer>>();

			for (int i = 0; i < half; i++) {
				int first = i;
				int second = half + get_offset(first + half + shift, 0, half);

				int item1 = indexes.get(first);
				int item2 = indexes.get(second);
				sub.add(new Tuple2<Integer>(item1, item2));
			}

			result.add(sub);
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

	public static class Point implements Comparable<Point> {
		public double x;
		public double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public boolean can_walk_to(Point o) {
			return this.y == o.y && this.x < o.x;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y == o.y) {
				return (int) (this.x - o.x);
			} else {
				return (int) (this.y - o.y);
			}
		}
	}
}
