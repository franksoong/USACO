
/*
ID: xinkun.2
LANG: JAVA
TASK: ride
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ride_20210312 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		String cometName = bf.readLine(); // COMETQ
		String groupName = bf.readLine();

		int cometProduct = 1;
		for (Character c : cometName.toCharArray()) { // ['C', 'O', 'M' ... ]
			int num = 1 + (int) c - (int) 'A';
			cometProduct = cometProduct * num;
		}
		int cometSecret = cometProduct % 47;

		int groupProduct = 1;
		for (Character g : groupName.toCharArray()) {
			int num = 1 + (int) g - (int) 'A';
			groupProduct = groupProduct * num;
		}
		int groupSecret = groupProduct % 47;

		if (cometSecret == groupSecret) {
			out.println("GO");
		} else {
			out.println("STAY");
		}

		out.close();
		bf.close();
	}
}