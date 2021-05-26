/*
 ID: xinkun.2
 LANG: JAVA
 TASK: friday
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class friday {

	public static void main(String[] args) throws IOException {

		Scanner reader = new Scanner(new File("friday.in"));
		PrintWriter writer = new PrintWriter(new File("friday.out"));

		int years_to_count = reader.nextInt();

		int year_start = 1900;
		int year_end = year_start + years_to_count;

		int[] days_in_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] days_in_month_leap = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int[] frequency = new int[7];
		Arrays.fill(frequency, 0);

		int distance = 0;

		for (int year = year_start; year < year_end; year++) {
			for (int month = 0; month < 12; month++) {
				int days = isLeapYear(year) ? days_in_month_leap[month] : days_in_month[month];
				for (int day = 0; day < days; day++) {

					// the 13th in this month
					if (day == 12) {

						int relative_to_monday = distance % 7;

						// System.out.println("calendar_day:" + calendar_day);
						// System.out.println("week_day:" + week_day);
						frequency[relative_to_monday]++;
						// 0 -> Monday
						// 1 -> Tuesday
						// 2 -> Wednesday
						// 3 -> Thursday
						// 4 -> Friday
						// 5 -> Saturday
						// 6 -> Sunday
					}

					distance++;
				}

			}
		}

		print_result(frequency, writer);

		// writer.print(frequency[5]);
		// writer.print(' ');
		// writer.print(frequency[6]);
		// writer.print(' ');
		// writer.print(frequency[0]);
		// writer.print(' ');
		// writer.print(frequency[1]);
		// writer.print(' ');
		// writer.print(frequency[2]);
		// writer.print(' ');
		// writer.print(frequency[3]);
		// writer.print(' ');
		// writer.println(frequency[4]);

		writer.close();
		reader.close();

	}

	private static void print_result(int[] frequency, PrintWriter writer) {
		// start from Saturday, end at Friday
		int[] print_order = { 5, 6, 0, 1, 2, 3, 4 };
		for (int i : print_order) {
			writer.print(frequency[i]);

			// last item
			if (i == 4) {
				writer.println();
			} else {
				writer.print(' ');
			}
		}
	}

	public static boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			return year % 400 == 0;
		} else {
			return year % 4 == 0;
		}
	}

}
