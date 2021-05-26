package com.train.usaco;

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

class ride {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new FileReader("ride.in"));

	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

	String cometName = reader.readLine(); // COMETQ
	String groupName = reader.readLine();

	if (getSecret(cometName) == getSecret(groupName)) {
	    out.println("GO");
	} else {
	    out.println("STAY");
	}

	out.close();
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