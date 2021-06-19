
/*
ID: xinkun.2
LANG: JAVA
TASK: milk
 */

// https://train.usaco.org/usacoprob2?a=9302IKLv7bi&S=milk
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class milk_base {
	public static void main(String[] args) throws IOException {
		String taskName = "milk";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		int amount = reader.nextInt();
		int farmer_nums = reader.nextInt();

		ArrayList<Farmer> all_farmers = new ArrayList<Farmer>();
		for (int i = 0; i < farmer_nums; i++) {
			int price = reader.nextInt();
			int total = reader.nextInt();

			Farmer farmer = new Farmer(price, total);
			all_farmers.add(farmer);
		}

		int cost = solve(amount, all_farmers);
		writter.println(cost);

		writter.close();
		reader.close();
	}

	public static int solve(int total, ArrayList<Farmer> farmers) {
		int cost = 0;

		Collections.sort(farmers);

		// buy

		return cost;
	}

	public static class Farmer implements Comparable<Farmer> {
		public int price;
		public int amount;

		public Farmer(int price, int amount) {
			this.price = price;
			this.amount = amount;
		}

		public int sell(int amount) {
			if (this.amount >= amount) {
				this.amount -= amount;
				return amount * this.price;
			}
			return 0;
		}

		@Override
		public int compareTo(Farmer o) {
			return this.price - o.price;
		}
	}

}
