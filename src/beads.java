/*
 ID: xinkun.2
 LANG: JAVA
 TASK: beads
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class beads {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("beads.in"));
		PrintWriter writter = new PrintWriter(new File("beads.out"));

		int beads_count = reader.nextInt();
		String necklace = reader.next();
		System.out.println("necklace: " + necklace);

		int max_collect_beads = 0;
		for (int i = 0; i < beads_count; i++) {
			int collect_from_left = countLeft(necklace, i);
			int collect_from_right = countRight(necklace, i + 1);

			System.out.println("if break at position " + i);
			System.out.println("left " + collect_from_left);
			System.out.println("right " + collect_from_right);
			System.out.println();

			int collect_beads = collect_from_left + collect_from_right;
			if (collect_beads > max_collect_beads) {
				max_collect_beads = collect_beads;
				if (max_collect_beads > beads_count) {
					max_collect_beads = beads_count;
				}
			}
		}

		writter.println(max_collect_beads);

		writter.close();
		reader.close();
	}

	public static int get_offset(int start, int shift, int length) {
		int result = (start + shift) % length;
		if (result < 0) {
			result += length;
		}
		return result;
	}

	public static int countLeft(String necklace, int start) {
		int length = necklace.length();
		int end = start - length;

		int count = 0;

		// remember which color to collect
		// we don't know yet
		char bead_color = ' ';
		for (int position = start; position > end; position--) {

			// rotate cycle, position maybe negative
			// int index = position >= 0 ? position : position + length;
			int index = get_offset(position, 0, length);

			char current_bead = necklace.charAt(index);

			// initialize bead_color when encounter a bead not in white
			// will be initialized only once
			if (bead_color == ' ' && current_bead != 'w') {
				bead_color = current_bead;
			}

			// do the counter
			if (current_bead == bead_color || current_bead == 'w') {
				count++;
			} else {
				break;
			}
		}

		return count;
	}

	public static int countRight(String necklace, int start) {
		int length = necklace.length();

		// rewind if start exceed length
		if (start == length) {
			start = 0;
		}

		int end = start + length;

		int count = 0;

		// remember which color to collect
		// we don't know yet
		char bead_color = ' ';
		for (int position = start; position < end; position++) {

			// rotate cycle, position may be greater than length
			// int index = position % length;
			int index = get_offset(position, 0, length);

			char current_bead = necklace.charAt(index);

			// initialize bead_color when encounter a bead not in white
			// will be initialized only once
			if (bead_color == ' ' && current_bead != 'w') {
				bead_color = current_bead;
			}

			// do the counter
			if (current_bead == bead_color || current_bead == 'w') {
				count++;
			} else {
				break;
			}
		}

		return count;
	}
}
