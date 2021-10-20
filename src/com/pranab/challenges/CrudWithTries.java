package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class TriNode {
	boolean isAWord;
	int prefixCount;
	TriNode[] childReference = new TriNode[26];
}

public class CrudWithTries {

	private static final TriNode ROOTNODE=new TriNode();
	
	public static void main(String[] args) {
		System.out.println("The options for trie :");
		System.out.println("1 - Insert");
		System.out.println("2 - Search");
		System.out.println("3 - Delete");
		System.out.println("4 - PrefixCount");
		System.out.println("5 - AutoComplete");
		Scanner sc = new Scanner(System.in);
		while (true) {
			int choice = sc.nextInt();
			boolean isExit = false;
			switch (choice) {
			case 1:
				String word=sc.next();
				insert(word);
				break;
			case 2:
				String searchWord=sc.next();
				System.out.println(search(searchWord));
				break;
			case 3:
				String deleteWord=sc.next();
				delete(deleteWord);
				break;
			case 4:
				String prefixWord=sc.next();
				int count=findPrefixCount(prefixWord);
				System.out.println(count);
				break;
			case 5:
				String autoCompletePrefix=sc.next();
				List<String> autoCompleteList=autoComplete(autoCompletePrefix);
				System.out.println(autoCompleteList);
				break;
			default:
				isExit = true;
			}
			if (isExit) {
				break;
			}
		}
	}

	private static List<String> autoComplete(String autoCompletePrefix) {
		TriNode crawller=ROOTNODE;
		List<String> autoCompleteList=new ArrayList<>();
		for(int index=0;index<autoCompletePrefix.length();index++) {
			int charecterIndex=autoCompletePrefix.charAt(index)-'a';
			if(crawller.childReference[charecterIndex]==null) {
				return null;
			}
			crawller=crawller.childReference[charecterIndex];
		}
		if(crawller.isAWord) {
			autoCompleteList.add(autoCompletePrefix);
		}
		findWords(crawller,autoCompletePrefix,autoCompleteList);
		return autoCompleteList;
	}

	private static void findWords(TriNode crawller, String autoCompletePrefix, List<String> autoCompleteList) {
		/*if(crawller.childReference==null) {
			return;
		}*/
		for(int index=0;index<26;index++) {
			if(crawller.childReference[index]!=null) {
				char character=(char) ('a'+index);
				String prefixAppender=character+"";
				if(crawller.childReference[index].isAWord) {
					autoCompleteList.add(autoCompletePrefix+prefixAppender);
				}
				findWords(crawller.childReference[index],(autoCompletePrefix+prefixAppender),autoCompleteList);
			}
		}
	}

	private static int findPrefixCount(String prefixWord) {
		TriNode crawller=ROOTNODE;
		for(int index=0;index<prefixWord.length();index++) {
			int charecterIndex=prefixWord.charAt(index)-'a';
			if(crawller.childReference[charecterIndex]==null) {
				return -1;
			}
			crawller=crawller.childReference[charecterIndex];
		}
		return crawller.prefixCount;
	}

	private static boolean delete(String deleteWord) {
		TriNode crawller=ROOTNODE;
		Stack<TriNode> triStack=new Stack<>();
		Stack<Integer> indexStack=new Stack<>();
		for(int index=0;index<deleteWord.length();index++) {
			int charecterIndex=deleteWord.charAt(index)-'a';
			if(crawller.childReference[charecterIndex]==null) {
				return false;
			}
			indexStack.push(charecterIndex);
			crawller=crawller.childReference[charecterIndex];
			triStack.push(crawller);
		}
		TriNode deleteNode=triStack.pop();	
		deleteNode.isAWord=false;
		while(!triStack.isEmpty()) {
			int index=indexStack.pop();
			if(deleteNode.prefixCount>1) {
				deleteNode.prefixCount--;
			}else {
				triStack.peek().childReference[index]=null;
			}
			deleteNode=triStack.pop();
		}
		int index=indexStack.pop();
		if(deleteNode.prefixCount>1) {
			deleteNode.prefixCount--;
		}else {
			ROOTNODE.childReference[index]=null;
		}
		return true;
	}

	private static boolean search(String searchWord) {
		TriNode crawller=ROOTNODE;
		for(int index=0;index<searchWord.length();index++) {
			int charecterIndex=searchWord.charAt(index)-'a';
			if(crawller.childReference[charecterIndex]==null) {
				return false;
			}
			crawller=crawller.childReference[charecterIndex];
		}
		return crawller.isAWord;
	}

	private static void insert(String word) {
		TriNode crawller=ROOTNODE;
		for(int index=0;index<word.length();index++) {
			int charecterIndex=word.charAt(index)-'a';
			if(crawller.childReference[charecterIndex]==null) {
				crawller.childReference[charecterIndex]=new TriNode();
			}
			crawller=crawller.childReference[charecterIndex];
			crawller.prefixCount++;
		}
		crawller.isAWord=true;
	}
}
