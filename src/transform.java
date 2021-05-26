import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: xinkun.2
LANG: JAVA
TASK: transform
 */

public class transform {

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

		int result = solve(from, to, size);
		writter.println(result);

		writter.close();
		reader.close();
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
		int id = 7;

		char[][] temp = new char[size][size];

		// don't repeat yourself
		int[] operations = new int[] { 1, 2, 3, 4, 5, 5, 5, 6 };
		for (int index = 0; index < operations.length; index++) {

			transfrom_pattern(from, temp, size, index);

			if (is_same_matrix(temp, to, size)) {
				// operations = []{1,2,3,4,5,5,5,6,7}
				id = operations[index];
				return id;
			}
		}

		return id;
	}

	public static void transfrom_pattern(char[][] from, char[][] to, int size, int operation_id) {
		int s = size - 1;

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				char data = from[x][y];

				int[] new_coordinate = transfrom_point(x, y, operation_id, s);
				int x_new = new_coordinate[0];
				int y_new = new_coordinate[1];

				to[x_new][y_new] = data;
			}
		}
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
	public static int[] transfrom_point(int x, int y, int operation, int s) {
		int[] new_coordinate = new int[2];
		switch (operation) {
		case 0:
			new_coordinate[0] = y;
			new_coordinate[1] = s - x;
			break;
		case 1:
			new_coordinate[0] = s - x;
			new_coordinate[1] = s - y;
			break;
		case 2:
			new_coordinate[0] = s - y;
			new_coordinate[1] = x;
			break;
		case 3:
			new_coordinate[0] = x;
			new_coordinate[1] = s - y;
			break;
		case 4:
			new_coordinate[0] = s - y;
			new_coordinate[1] = s - x;
			break;
		case 5:
			new_coordinate[0] = s - x;
			new_coordinate[1] = y;
			break;
		case 6:
			new_coordinate[0] = y;
			new_coordinate[1] = x;
			break;
		case 7:
			new_coordinate[0] = x;
			new_coordinate[1] = y;
			break;
		default:
			break;
		}

		return new_coordinate;
	}

	public static boolean is_same_matrix(char[][] m1, char[][] m2, int size) {
		boolean result = true;

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (m1[x][y] != m2[x][y]) {
					// early return
					return false;
				}
			}
		}

		return result;
	}

}
