package com.pranab.challenges;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.Stack;

public class TextEditorTimeEffecient {

	public static void main(String[] args) throws IOException {
		Instant start = Instant.now();
		Scanner scanner = new Scanner(new File("input04.txt"));
		int inputCounts = Integer.parseInt(scanner.nextLine());
		Stack<String> undoStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int iter = 0; iter < inputCounts; iter++) {
			String[] actions = scanner.nextLine().split(" ");
			String action = actions[0];
			if("1".equals(action)) {
				sb.append(actions[1]);
				undoStack.push("2 " + actions[1].length());}
			else if("2".equals(action)) {
				int builder_length = sb.length(), remove_index = builder_length - Integer.parseInt(actions[1]);
				String removedStrings = sb.substring(remove_index);
				sb.delete(remove_index, builder_length);
				undoStack.push("1 " + removedStrings);
			}else if("3".equals(action)) {
				int charIndex = Integer.parseInt(actions[1]);
				System.out.println(sb.charAt(charIndex - 1));
			}else {
				String undoaction = undoStack.pop();
				String argsAt[] = undoaction.split(" ");
				if (Integer.parseInt(argsAt[0]) == 1) {
					sb.append(argsAt[1]);
				} else {
					int builder_lengthAt = sb.length(), remove_indexAt = builder_lengthAt - Integer.parseInt(argsAt[1]);
					sb.delete(remove_indexAt, builder_lengthAt);
				}
			}
		}
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
		scanner.close();
	}
}
