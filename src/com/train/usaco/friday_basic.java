/**
 * 
 */
package com.train.usaco;

/**
 * @author Administrator
 *
 */
public class friday_basic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// print_month();
		// print_each_day_in_month();
		// print_each_day_in_month_year();
		count_days();
		// day_to_weekday();
		// covert_to_weekday(100);
	}

	public static boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			return year % 400 == 0;
		} else {
			return year % 4 == 0;
		}
	}

	public static void print_month() {
		int[] days_in_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int month = 0; month < 12; month++) {
			System.out.println("month " + month + " has days: " + days_in_month[month]);

		}

		System.out.println();
	}

	public static void print_each_day_in_month() {
		int[] days_in_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int month = 0; month < 12; month++) {
			int days = days_in_month[month]; // month 0, days=31

			for (int day = 0; day < days; day++) { // 0
				System.out.println(month + "-" + day); // 0-0 0-1, 0-2
			}
		}
		System.out.println();
	}

	public static void print_each_day_in_month_year() {
		int[] days_in_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int year = 2000; year < 2001; year++) {

			for (int month = 0; month < 12; month++) {
				for (int day = 0; day < days_in_month[month]; day++) {
					System.out.println(year + "-" + month + "-" + day);
				}
			}
		}
		System.out.println();
	}

	public static void count_days() {
		int count = 0;

		int[] days_in_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] days_in_month_leap = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int year = 2000; year < 2010; year++) {

			for (int month = 0; month < 12; month++) {

				int days = days_in_month[month];

				if (isLeapYear(year)) {
					days = days_in_month_leap[month];
				}

				for (int day = 0; day < days; day++) {
					count++;
				}
			}
		}
		System.out.println("Total days: " + count + " from 2000-01-01 to 2009-12-31");
		System.out.println();
	}

	// 2021-3-1 - Monday
	// how about 3 days later
	// how about 7 days later
	// how about 10 days later
	public static void day_to_weekday() {
		int[] distances = { 3, 7, 10, 100, 1000, 100000 };

		String[] labels = { "Mon.", "Tue.", "Wed.", "Thu.", "Fri.", "Sat.", "Sun." };

		System.out.println("Suppose 2021-3-1 is Monday - (Noted as 0)");

		for (int i = 0; i < distances.length; i++) {
			int distance = distances[i];
			int weekday = distance % 7;
			System.out.println(distance + " days later is: " + labels[weekday]);
		}

		System.out.println();
	}

	public static void covert_to_weekday(int calender_day) {
		int count = 0;
		int[] days_in_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int year = 2000; year < 2010; year++) {
			for (int month = 0; month < 12; month++) {
				for (int day = 0; day < days_in_month[month]; day++) {
					if (calender_day == count) {
						int weekday = count % 7;
						System.out.println("Date of calender_day " + calender_day + " is " + year + "-" + month + "-"
								+ day + " weekday is: " + weekday);
					}
					count++;
				}
			}
		}
		System.out.println();
	}

}
