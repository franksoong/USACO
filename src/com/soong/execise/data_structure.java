/**
 * 
 */
package com.soong.execise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// array
// list
// map
public class data_structure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// list_test();
		map_test();
	}

	public static void map_test() {
		// Linna, Tina, Bill, Terry
		// 90, 65, 30, 100

		HashMap<String, Integer> test_data = new HashMap<String, Integer>();
		test_data.put("Linna", 90);
		test_data.put("Tina", 65);
		test_data.put("Bill", 30);
		test_data.put("Terry", 100);
		test_data.put("Terry2", 20);
		test_data.put("Terry3", 0);
		test_data.put("Terry4", 69);

		System.out.println(test_data);

		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
		result.put("A", new ArrayList<String>());
		result.put("B", new ArrayList<String>());
		result.put("C", new ArrayList<String>());

		// Anonymous
		test_data.forEach((name, score) -> {
			String grade = "C";
			if (score > 89) {
				grade = "A";
			} else if (score > 59) {
				grade = "B";
			}

			result.get(grade).add(name);
		});
		System.out.println("A " + result.get("A"));
		System.out.println(result);

		// test_data.remove("Terry");
		// System.out.println(test_data);
		//
		// test_data.put("Bill", 50);
		// System.out.println(test_data);

	}

	//

	// 1...100
	public static void array_test() {
		int length = 10;

		int[] array = new int[length]; // 0-length-1
		for (int i = 0; i < length; i++) {
			array[i] = i * 2;
		}

		for (int i = 0; i < length; i++) {
			System.out.println(array[i]);
		}

		for (int i = length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
		//
		array[5 - 1] = 100;
		array[7 - 1] = 700;
		System.out.println(Arrays.toString(array));

		// add element
		// array[length] = 100;
		// array[length + 1] = 200;

		array = new int[15];
		array[length] = 100;
		array[length + 1] = 200;
		System.out.println(Arrays.toString(array));

	}

	public static void list_test() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		int length = 10;
		for (int i = 0; i < length; i++) {
			list.add(i);
		}

		for (int i = 0; i < length; i++) {
			System.out.println(list.get(i));
		}

		for (int i = length - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}

		for (int i = 0; i < 5; i++) {
			list.add(i * 8);
		}
		System.out.println(list.toString());

		for (int i = 15 - 1; i >= 10; i--) {
			list.remove(i);
		}

		System.out.println(list.toString());
	}

}
