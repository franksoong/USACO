/*
ID: xinkun.2
LANG: JAVA
TASK: namenum
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class namenum_v1 {
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("namenum.in"));
		PrintWriter writer = new PrintWriter(new File("namenum.out"));

		String num = reader.next();
		ArrayList<String> dict = read_dict();

		ArrayList<String> result = solve(num, dict);

		for (String name : result) {
			writer.println(name);
		}
		writer.close();
		reader.close();
	}

	public static ArrayList<String> read_dict() throws IOException {
		ArrayList<String> dict = new ArrayList<String>();

		Scanner reader = new Scanner(new File("dict.txt"));
		while (reader.hasNext()) {
			dict.add(reader.next());
		}
		reader.close();

		return dict;
	}

	public static ArrayList<String> solve2(String num, ArrayList<String> dict) {
		// inverted index
		ArrayList<String> result = new ArrayList<String>();

		HashMap<Character, Character> keypad = get_keypad2();
		HashMap<String, ArrayList<String>> inverted_index = buildInvertedIndex(keypad, dict);

		ArrayList<String> value = inverted_index.get(num);
		if (value == null || value.size() == 0) {
			result.add("NONE");
		} else {
			result = value;
		}

		return result;

	}

	private static HashMap<String, ArrayList<String>> buildInvertedIndex(HashMap<Character, Character> keypad,
			ArrayList<String> dict) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String item : dict) {
			if (item.contains("Q") || item.contains("Z")) {
				continue;
			}

			String key = "";
			for (char c : item.toCharArray()) {
				key += keypad.get(c);
			}

			// System.out.println(key);
			ArrayList<String> value = map.get(key);
			if (value == null) {
				value = new ArrayList<String>();
			}

			value.add(item);
			map.put(key, value);
		}

		return map;
	}

	public static HashMap<Character, Character> get_keypad2() {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('A', '2');
		map.put('B', '2');
		map.put('C', '2');
		map.put('D', '3');
		map.put('E', '3');
		map.put('F', '3');
		map.put('G', '4');
		map.put('H', '4');
		map.put('I', '4');
		map.put('J', '5');
		map.put('K', '5');
		map.put('L', '5');
		map.put('M', '6');
		map.put('N', '6');
		map.put('O', '6');
		map.put('P', '7');
		map.put('R', '7');
		map.put('S', '7');
		map.put('T', '8');
		map.put('U', '8');
		map.put('V', '8');
		map.put('W', '9');
		map.put('X', '9');
		map.put('Y', '9');

		return map;
	}

	public static HashMap<Character, char[]> get_keypad() {
		HashMap<Character, char[]> keypad = new HashMap<Character, char[]>();
		keypad.put('2', new char[] { 'A', 'B', 'C' });
		keypad.put('3', new char[] { 'D', 'E', 'F' });
		keypad.put('4', new char[] { 'G', 'H', 'I' });
		keypad.put('5', new char[] { 'J', 'K', 'L' });
		keypad.put('6', new char[] { 'M', 'N', 'O' });
		keypad.put('7', new char[] { 'P', 'R', 'S' });
		keypad.put('8', new char[] { 'T', 'U', 'V' });
		keypad.put('9', new char[] { 'W', 'X', 'Y' });

		return keypad;
	}

	static HashMap<String, ArrayList<String>> table = new HashMap<String, ArrayList<String>>();

	public static ArrayList<String> generateCombinations(String num, HashMap<Character, char[]> keypad) {
		ArrayList<String> first = new ArrayList<String>();
		ArrayList<String> all = new ArrayList<String>();

		if (table.containsKey(num)) {
			return table.get(num);
		}

		int length = num.length();

		char[] values = keypad.get(num.charAt(0));
		for (char c : values) {
			first.add(String.valueOf(c));
		}

		if (length == 1) {
			return first;
		} else {
			ArrayList<String> other = generateCombinations(num.substring(1), keypad);
			for (char c : values) {
				for (String string : other) {
					all.add(c + string);
				}
			}
			table.put(num.substring(1), all);
		}

		return all;
	}

	public static ArrayList<String> solve(String num, ArrayList<String> dict) {
		ArrayList<String> result = new ArrayList<String>();

		HashMap<Character, char[]> keypad = get_keypad();
		ArrayList<String> combinations = generateCombinations(num, keypad);
		// System.out.print(keypad);
		// System.out.print(combinations);

		for (String name : combinations) {
			if (dict.contains(name)) {
				result.add(name);
			}
		}
		if (result.size() == 0) {
			result.add("NONE");
		}

		return result;

	}
}