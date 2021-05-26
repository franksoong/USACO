/*
 ID: xinkun.2
 LANG: JAVA
 TASK: gift1
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class gift1 {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner((new File("gift1.in")));
		PrintWriter writter = new PrintWriter(new File("gift1.out"));

		// read count and all names in this group
		int np = reader.nextInt();
		String[] group = new String[np];
		for (int i = 0; i < np; i++) {
			group[i] = reader.next();
		}

		// maps to store initial money and received money respectively
		HashMap<String, Integer> initial = new HashMap<String, Integer>();
		HashMap<String, Integer> received = new HashMap<String, Integer>();
		// Initialization
		for (String name : group) {
			initial.put(name, 0);
			received.put(name, 0);
		}

		// loop all givers
		for (int i = 0; i < np; i++) {
			// the giver name
			String giver = reader.next();

			// the initial money - read and store
			int amount = reader.nextInt();
			initial.put(giver, amount);

			// do the gift distribution
			int recipients_count = reader.nextInt();
			if (recipients_count > 0) {
				int gift_each = amount / recipients_count;
				int gift_left = amount % recipients_count;

				for (int j = 0; j < recipients_count; j++) {
					String recipient = reader.next();
					received.put(recipient, received.get(recipient) + gift_each);
				}

				received.put(giver, received.get(giver) + gift_left);
			}
		}

		// calculate net_gain for each people
		for (String person : group) {
			int net_gain = received.get(person) - initial.get(person);
			writter.println(person + " " + net_gain);
		}

		reader.close();
		writter.close();
	}

}
