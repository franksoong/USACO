
/*
ID: xinkun.2
LANG: JAVA
TASK: ride
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class ride {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("ride.in"));
		PrintWriter writer = new PrintWriter(new File("ride.out"));

		String cometName = reader.next(); // COMETQ
		String groupName = reader.next(); // USACOP

		if (getSecret(cometName) == getSecret(groupName)) {
			writer.println("GO");
		} else {
			writer.println("STAY");
		}

		writer.close();
		reader.close();
	}

	public static int getSecret(String name) {
		int product = 1;
		for (Character c : name.toCharArray()) {
			int num = 1 + (int) c - (int) 'A';
			product = product * num;
		}
		return product % 47;
	}
}