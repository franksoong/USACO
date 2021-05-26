import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.function.Function;

/*
ID: xinkun.2
LANG: JAVA
TASK: transform
 */

public class transform_v2 {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("transform.in"));
		PrintWriter writter = new PrintWriter(new File("transform.out"));

		int size = reader.nextInt();

		char[][] from = new char[size][size];
		for (int i = 0; i < size; i++) {
			from[i] = reader.next().toCharArray();
		}

		char[][] to = new char[size][size];
		for (int i = 0; i < size; i++) {
			to[i] = reader.next().toCharArray();
		}

		int result = solve2(size, from, to);

		writter.println(result);

		writter.close();
		reader.close();
	}

	public static int[] coordinate(int x, int y) {
		return new int[] { x, y };
	}

	// size = n-1
	// 0) 1, rot90: (i, j) -> (j, size-i)
	// 1) 2, rot180: (i, j) -> (j, size-i) -> (size-i, size-j)
	// 2) 3, rot270: (i, j) -> (j, size-i) -> (size-i, size-j) -> (size-j, i)
	// 3) 4, reflection: (i, j) -> (i, size - j)
	// 4) 5, 4 + [1..3] (i, j) -> (i, size-j) -> size-j, size-i
	// 5) 5, 4 + [1..3] (i, j) -> (i, size-j) -> size-i, j
	// 6) 5, 4 + [1..3] (i, j) -> (i, size-j) -> j, i
	// 7) 6, nop: (i, j) -> (i, j)
	// 8) 7, Invalid
	public static int solve2(int n, char[][] from, char[][] to) {
		// loop each solution from 0-8, early return

		// default
		int solution = 8;

		// define the rules and labels
		int size = n - 1;
		HashMap<Integer, Function<int[], int[]>> solutions = new HashMap<Integer, Function<int[], int[]>>();
		int[] labels = new int[] { 1, 2, 3, 4, 5, 5, 5, 6, 7 };
		solutions.put(0, (int[] pos) -> coordinate(pos[1], size - pos[0]));
		solutions.put(1, (int[] pos) -> coordinate(size - pos[0], size - pos[1]));
		solutions.put(2, (int[] pos) -> coordinate(size - pos[1], pos[0]));
		solutions.put(3, (int[] pos) -> coordinate(pos[0], size - pos[1]));
		solutions.put(4, (int[] pos) -> coordinate(size - pos[1], size - pos[0]));
		solutions.put(5, (int[] pos) -> coordinate(size - pos[0], pos[1]));
		solutions.put(6, (int[] pos) -> coordinate(pos[1], pos[0]));
		solutions.put(7, (int[] pos) -> coordinate(pos[0], pos[1]));

		// check each solution
		for (Entry<Integer, Function<int[], int[]>> entry : solutions.entrySet()) {
			int id = entry.getKey();
			Function<int[], int[]> transform_fn = entry.getValue();

			boolean matched = true;

			// for this solution id,
			// -- check the square are same? from <-> to
			// loop label, used for break
			lable_check_square_match: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int[] coordinate = new int[] { i, j };
					int[] coordinate_new = transform_fn.apply(coordinate);

					if (from[i][j] != to[coordinate_new[0]][coordinate_new[1]]) {
						matched = false;
						// break the loop with this label
						break lable_check_square_match;
					}
				}
			}

			if (matched) {
				solution = id;
				break;
			}
		}

		int solution_lable = labels[solution];
		return solution_lable;
	}
}