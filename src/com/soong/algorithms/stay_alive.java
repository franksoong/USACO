/**
Stay Alive
A group of people are in one boat, whereas there are not enough place for all of them, so they have to kill one person in each round of a survival game...


Conditions：
a data structure to store the survivors and the died.
input/arguments of total number and game rule
return the survival positions


Write a program to find out all positions that could stay alive in the end.
*/

package com.soong.algorithms;

import java.util.Arrays;

/**
 * @author Administrator
 *
 */
public class stay_alive {
	public static void alive(int total, int rule, int res) {
		boolean[] all = new boolean[total];
		int count = 0;
		int index = 0;
		int num = 0;
		while (count < total - res) {
			if (!all[index]) {
				num++;
				if (num == rule) {
					all[index] = true;
					count++;
					num = 0;
				}
			}
			index++;
			index %= total;
		}

		System.out.println(Arrays.toString(all));
	}

	public static void alive2(int total, int rule, int res) {
		// 所有人默认false - not alive
		boolean[] all = new boolean[total];

		int alive_count = 0; // 当前alive人数
		int call_number = 0; // 当前报号
		for (int index = 0;; index++) {
			// 圆周运动
			index %= total;

			// 终止条件
			if (total - alive_count == res) {
				break;
			}

			// 报号 - 已经alive的人不参与报号
			if (!all[index]) {
				call_number++;
			}

			// 中签 - set alive
			if (call_number == rule) {
				all[index] = true;
				alive_count++;

				// 重设报号
				call_number = 0;
			}
		}

		System.out.println(Arrays.toString(all));
	}

	public static void main(String[] args) {
		alive(10, 3, 2);
		alive2(10, 3, 2);

		alive(15, 4, 2);
		alive2(15, 4, 2);

		alive(100, 5, 10);
		alive2(100, 5, 10);
	}

}
