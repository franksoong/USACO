package com.soong.algorithms;

import java.util.ArrayList;

public class narcissistic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList result = new ArrayList();
		for (int item = 99; item < 1000; item++) {
			int a = item % 10;
			int b = item % 100 / 10;
			int c = item / 100;

			int sum = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
			if (sum == item) {
				result.add(item);
			}
		}

		result.forEach(item -> System.out.println(item));
	}

}
