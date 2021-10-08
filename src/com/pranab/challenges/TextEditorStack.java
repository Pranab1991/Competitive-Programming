package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*public class TextEditorStack {

	public static void main(String[] args) throws IOException {
		LocalTime startTime = LocalTime.now();
		final Scanner scanner = new Scanner(new File("Input.txt"));
		int inputCounts = Integer.parseInt(scanner.nextLine());
		Stack<String> undoStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int iter = 0; iter < inputCounts; iter++) {
			String[] actions = scanner.nextLine().split(" ");
			String action = actions[0];
			if ("1".equals(action)) {
				sb.append(actions[1]);
				undoStack.push("2 " + actions[1].length());
			} else if ("2".equals(action)) {
				int builder_length = sb.length();
				int remove_index = builder_length - Integer.parseInt(actions[1]);
				String removedStrings = sb.substring(remove_index);
				sb.delete(remove_index, builder_length);
				undoStack.push("1 " + removedStrings);
			} else if ("3".equals(action)) {
				int charIndex = Integer.parseInt(actions[1]);
				System.out.println(sb.charAt(charIndex - 1));
			} else {
				String undoaction = undoStack.pop();
				String argsAt[] = undoaction.split(" ");
				if ("1".equals(argsAt[0])) {
					sb.append(argsAt[1]);
				} else {
					int builder_lengthAt = sb.length(), remove_indexAt = builder_lengthAt - Integer.parseInt(argsAt[1]);
					sb.delete(remove_indexAt, builder_lengthAt);
				}
			}
		}
		scanner.close();
		LocalTime endTime = LocalTime.now();
		System.out.println("The time duration " + Duration.between(startTime, endTime));
	}
}*/

/*public class TextEditorStack {
	public static void main(String[] args) throws FileNotFoundException {
		LocalTime startTime = LocalTime.now();
		final Scanner scanner = new Scanner(new File("Input.txt"));
		int inputCounts = Integer.parseInt(scanner.nextLine());
		String[] actionsIn=new String[inputCounts];
		for (int iter = 0; iter < inputCounts; iter++) {
			actionsIn[iter]=scanner.nextLine();
			
		}
		Stack<String> undoStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(String actionOp:actionsIn) {
			String[] actions = actionOp.split(" ");
			String action = actions[0];
			if ("1".equals(action)) {
				sb.append(actions[1]);
				undoStack.push("2 " + actions[1].length());
			} else if ("2".equals(action)) {
				int builder_length = sb.length(), remove_index = builder_length - Integer.parseInt(actions[1]);
				String removedStrings = sb.substring(remove_index);
				sb.delete(remove_index, builder_length);
				undoStack.push("1 " + removedStrings);
			} else if ("3".equals(action)) {
				int charIndex = Integer.parseInt(actions[1]);
				System.out.println(sb.charAt(charIndex - 1));
			} else {
				String undoaction = undoStack.pop();
				String argsAt[] = undoaction.split(" ");
				if ("1".equals(argsAt[0])) {
					sb.append(argsAt[1]);
				} else {
					int builder_lengthAt = sb.length(), remove_indexAt = builder_lengthAt - Integer.parseInt(argsAt[1]);
					sb.delete(remove_indexAt, builder_lengthAt);
				}
			}
		}
		LocalTime endTime = LocalTime.now();
		System.out.println("The time duration " + Duration.between(startTime, endTime));
	}
}*/

public class TextEditorStack {

	public static void main(String[] args) throws FileNotFoundException {
		LocalTime startTime = LocalTime.now();
	    Stack<String> st = new Stack<String>();
	    final Scanner sc = new Scanner(new File("Input.txt"));
	    int n = sc.nextInt();
	    String str = "";
	    st.push("");
	    sc.nextLine();
	    for (int i = 0; i < n; i++) {
	      int op = sc.nextInt();
	      switch (op) {
	        case 1:
	          str = st.peek() + sc.next();
	          st.push(str);
	          break;
	        case 2:
	          if (!st.isEmpty()) {
	            str = st.peek().substring(0, st.peek().length() - sc.nextInt());
	            st.push(str);
	          }
	          break;
	        case 3:
	          if (!st.isEmpty()) {
	            str = st.peek();
	            char c = str.charAt(sc.nextInt() - 1);
	            //System.out.println(c);
	          }
	          break;
	        case 4:
	          if (!st.isEmpty()) {
	            st.pop();
	          }
	          break;
	      }
	    }
	    sc.close();
	    LocalTime endTime = LocalTime.now();
		System.out.println("The time duration " + Duration.between(startTime, endTime));
	  }
}
