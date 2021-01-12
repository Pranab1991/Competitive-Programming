package com.pranab.challenges;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

	
	
	public static void main(String[] args) throws IOException {
		Instant start = Instant.now();
		Scanner scanner = new Scanner(new File("input04.txt"));
		int inputCounts=Integer.parseInt(scanner.nextLine());
		Stack<String> undoStack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		for (int iter=0;iter<inputCounts;iter++) {
			String[] action = scanner.nextLine().split(" ");
			if(!"4".equals(action[0])) {
				operation(Integer.parseInt(action[0]),action[1],false,undoStack,sb);
			}else {
				operation(Integer.parseInt(action[0]),null,false,undoStack,sb);
			}
		}
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
		scanner.close();
	}
	
	public static void operation(int action, String arg,boolean undoflag,
			Stack<String> undoStack,StringBuilder sb) {
		switch(action) {
			case 1:
				sb.append(arg);
				//if(!undoflag) {
				undoStack.push("2 "+arg.length());
				//}
				break;
			case 2:
				int builder_length=sb.length(),remove_index=builder_length-Integer.parseInt(arg);
				String removedStrings=sb.substring(remove_index);
				sb.delete(remove_index,builder_length);
				//if(!undoflag) {
				undoStack.push("1 "+removedStrings);
				//}
				break;
			case 3:
				int charIndex=Integer.parseInt(arg);
				System.out.println(sb.charAt(charIndex-1));
				break;
			case 4:
				String undoaction=undoStack.pop();
				String args[]=undoaction.split(" ");
				//operation(Integer.parseInt(args[0]),args[1],true,undoStack,sb);
				if(Integer.parseInt(args[0])==1) {
					sb.append(args[1]);
				}else {
					int builder_lengthAt=sb.length(),remove_indexAt=builder_lengthAt-Integer.parseInt(args[1]);
					sb.delete(remove_indexAt,builder_lengthAt);
				}
				break;
		}
	}
}
