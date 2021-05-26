import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: xinkun.2
LANG: JAVA
TASK: transform
 */

public class transform_v3 {

	/**
	 * @param args
	 * @return
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
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

		int result = solve2(from, to, size);
		writter.println(result);

		writter.close();
		reader.close();
	}

	public static int solve2(char[][] from, char[][] to, int size) {
		int result = 7;
		int s = size - 1;
		char[][] temp = new char[size][size];

		int[] operations = new int[] { 1, 2, 3, 4, 5, 5, 5, 6 };
		for (int op = 0; op < operations.length; op++) {

			for (int x = 0; x < size; x++) {
				for (int y = 0; y < size; y++) {
					char data = from[x][y];

					int[] coorinate_old = new int[] { x, y };
					int[] coorinate_new = apply_transform(coorinate_old, op, s);

					int x_new = coorinate_new[0], y_new = coorinate_new[1];
					temp[x_new][y_new] = data;
				}
			}

			if (is_same_matrix(temp, to, size)) {
				result = operations[op];
				return result;
			}
		}

		return result;
	}

	public static int[] apply_transform(int[] coorinate, int operation, int s) {
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
		int x = coorinate[0], y = coorinate[1];
		int x_new, y_new;

		switch (operation) {
		case 0: {
			x_new = y;
			y_new = s - x;
			break;
		}
		case 1: {
			x_new = s - x;
			y_new = s - y;
			break;
		}
		case 2: {
			x_new = s - y;
			y_new = x;
			break;
		}
		case 3: {
			x_new = x;
			y_new = s - y;
			break;
		}
		case 4: {
			x_new = s - y;
			y_new = s - x;
			break;
		}
		case 5: {
			x_new = s - x;
			y_new = y;
			break;
		}
		case 6: {
			x_new = y;
			y_new = x;
			break;
		}
		default:
			x_new = x;
			y_new = y;
			break;
		}

		int[] coorinate_new = new int[] { x_new, y_new };
		return coorinate_new;
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

	public static int solve(char[][] from, char[][] to, int size) {
		int result = 7;
		int s = size - 1;
		char[][] temp = new char[size][size];

		// don't repeat yourself
		// Ã·»°function

		// test rot90

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 90 - (i, j) -> (j, s-i)
				char data = from[x][y];

				// markdown
				// int[] new_coordinate = transfrom(x, y);
				int x_new = y;
				int y_new = s - x;

				temp[x_new][y_new] = data;
			}
		}

		if (is_same_matrix(temp, to, size)) {
			// operations = []{1,2,3,4,5,5,5,6,7}
			result = 1;
			return result;
		}

		// test rot180
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 90 - (i, j) -> (j, s-i)
				char data = from[x][y];

				int x_new = s - x;
				int y_new = s - y;

				temp[x_new][y_new] = data;
			}
		}

		if (is_same_matrix(temp, to, size)) {
			result = 2;
			return result;
		}

		// test rot270
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 90 - (i, j) -> (j, s-i)
				char data = from[x][y];

				int x_new = s - y;
				int y_new = x;

				temp[x_new][y_new] = data;
			}
		}

		if (is_same_matrix(temp, to, size)) {
			result = 3;
			return result;
		}

		// test reflection
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 90 - (i, j) -> (j, s-i)
				char data = from[x][y];

				int x_new = x;
				int y_new = s - y;

				temp[x_new][y_new] = data;
			}
		}

		if (is_same_matrix(temp, to, size)) {
			result = 4;
			return result;
		}

		// test combination1
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 90 - (i, j) -> (j, s-i)
				char data = from[x][y];

				int x_new = s - y;
				int y_new = s - x;

				temp[x_new][y_new] = data;
			}
		}

		if (is_same_matrix(temp, to, size)) {
			result = 5;
			return result;
		}
		// test combination2
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 90 - (i, j) -> (j, s-i)
				char data = from[x][y];

				int x_new = s - x;
				int y_new = y;

				temp[x_new][y_new] = data;
			}
		}

		if (is_same_matrix(temp, to, size)) {
			result = 5;
			return result;
		}
		// test combination3
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 90 - (i, j) -> (j, s-i)
				char data = from[x][y];

				int x_new = y;
				int y_new = x;

				temp[x_new][y_new] = data;
			}
		}

		if (is_same_matrix(temp, to, size)) {
			result = 5;
			return result;
		}

		// test nop
		if (is_same_matrix(from, to, size)) {
			result = 6;
			return result;
		}

		return result;
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

	public static boolean is_same_matrix(char[][] m1, char[][] m2, int size) {
		boolean result = true;

		loop: for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (m1[x][y] != m2[x][y]) {
					result = false;
					break loop;
				}
			}
		}

		return result;
	}

}
