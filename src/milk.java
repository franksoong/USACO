
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

public class milk {
	public static void main(String[] args) throws IOException {
		String taskName = "milk";
		Scanner reader = new Scanner(new File(taskName + ".in"));
		PrintWriter writter = new PrintWriter(new File(taskName + ".out"));

		int total = reader.nextInt();
		int farmer_count = reader.nextInt();
		ArrayList<Farmer> farmers = new ArrayList<Farmer>();
		for (int i = 0; i < farmer_count; i++) {
			int price = reader.nextInt();
			int amount = reader.nextInt();
			Farmer farmer = new Farmer(price, amount);
			farmers.add(farmer);
		}

		int minimal_cost = solve(total, farmers);

		writter.println(minimal_cost);

		writter.close();
		reader.close();
	}

	public static int solve(int total, ArrayList<Farmer> farmers) {
		int cost = 0;

		// we want to buy from the cheapest
		Collections.sort(farmers);

		// buy until gap == 0
		int gap = total;
		for (Farmer farmer : farmers) {
			// how much need to buy from this farmer
			int buy_amount = farmer.amount;
			if (gap < farmer.amount) {
				buy_amount = gap;
			}

			// then but it
			// and update cost and gap
			cost += farmer.sell(buy_amount);
			gap -= buy_amount;

			// if enough
			if (gap == 0) {
				break;
			}
		}

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
