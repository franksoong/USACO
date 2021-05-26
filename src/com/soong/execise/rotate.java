/**
 * 
 */
package com.soong.execise;

import java.util.Arrays;

/**
 * @author Administrator
 *
 */
public class rotate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 5;
		int s = size - 1;
		int[][] matrix = new int[size][size];

		int value = 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = value;
				value++;
			}
		}

		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

		int[][] rotate90 = new int[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 90 - (i, j) -> (j, s-i)
				int data = matrix[x][y];

				int x_new = y;
				int y_new = s - x;

				rotate90[x_new][y_new] = data;
			}
		}

		System.out.println("");
		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(rotate90[i]));
		}

		int[][] rotate180 = new int[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 180 - (x, y) -> (s-x, s-y)
				int data = matrix[x][y];

				int x_new = s - x;
				int y_new = s - y;

				rotate180[x_new][y_new] = data;
			}
		}

		System.out.println("");
		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(rotate180[i]));
		}

		int[][] rotate270 = new int[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// 270 - (x, y) -> (s-y, x)
				int data = matrix[x][y];

				int x_new = s - y;
				int y_new = x;

				rotate270[x_new][y_new] = data;
			}
		}

		System.out.println("");
		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(rotate270[i]));
		}

		int[][] refection = new int[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// refection - (x, y) -> (s-x, y)
				int data = matrix[x][y];

				int x_new = s - x;
				int y_new = y;

				refection[x_new][y_new] = data;
			}
		}

		System.out.println("");
		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(refection[i]));
		}
	}

}
