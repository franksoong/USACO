package com.soong.starter;

import java.util.Scanner;

public class A6_BinarySearch {
    public static void main(String[] args) {
	runBinarySearch1();
    }

    public static void runDummySearch() {
	int[] array = { 1, 9, 10, 20 };

	System.out.println(dummySearch(array, 10));
    }

    public static int dummySearch(int[] a, int key) {
	for (int index = 0; index < a.length; index++) {
	    if (a[index] == key) {
		return index;
	    }
	}
	return -1;
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int search(int[] a, int key) {

	int lower_bound = 0;
	int high_bound = a.length - 1;

	System.out.println("initial bound: " + lower_bound + "->" + high_bound);

	while (lower_bound <= high_bound) {
	    // Key is in a[lower_bound..lower_bound] or not present.
	    int middle = lower_bound + (high_bound - lower_bound) / 2;
	    System.out.println("\ncheck middle: " + a[middle]);

	    if (key < a[middle]) {
		high_bound = middle - 1;
		System.out.println("update high_bound: " + lower_bound + "->" + high_bound);
	    } else if (key > a[middle]) {
		lower_bound = middle + 1;
		System.out.println("update lower_bound: " + lower_bound + "->" + high_bound);
	    } else {
		System.out.println("Bingo, find the key!");
		return middle;
	    }

	}

	return -1;
    }

    public static int search_v2(int[] a, int key) {
	int lower_bound = 0;
	int high_bound = a.length - 1;

	// 当还有搜索空间
	while (lower_bound <= high_bound) {
	    int middle = lower_bound + (high_bound - lower_bound) / 2;
	    // 正好找到
	    if (key == a[middle]) {
		return middle;
		// 在左边
	    } else if (key < a[middle]) {
		high_bound = middle - 1;
		// 在右边
	    } else {
		lower_bound = middle + 1;
	    }
	}

	return -1;
    }

    public static int search_v3(int[] a, int key) {
	int lower_bound = 0;
	int high_bound = a.length - 1;

	// 当还有搜索空间
	while (lower_bound <= high_bound) {
	    int middle = lower_bound + (high_bound - lower_bound) / 2;
	    // 正好找到
	    if (key == a[middle]) {
		return middle;
		// 在左边
	    } else if (key < a[middle]) {
		high_bound = middle - 1;
		// 在右边
	    } else {
		lower_bound = middle + 1;
	    }
	}

	return -1;
    }

    public static void runBinarySearch1() {
	int[] array = { 1, 9, 10, 20, 25, 26, 29 };

	// sort the array
	// Arrays.sort(array);

	System.out.println(search(array, 26));
    }

    public static void runBinarySearch2() {
	int[] array = { 1, 9, 10, 20, 25, 26, 29, 30 };
	String prompt = "Input the number you want to query >>>";

	// sort the array
	// Arrays.sort(array);

	Scanner sc = new Scanner(System.in);

	System.out.println(prompt);
	int key = sc.nextInt();
	while (key > 0) {
	    int index = search(array, key);
	    if (index != -1) {
		System.out.println("find key " + key + " with index " + index);
	    } else {
		System.out.println("key " + key + " is not exist in array");
	    }

	    System.out.println(prompt);
	    key = sc.nextInt();
	}
    }
}