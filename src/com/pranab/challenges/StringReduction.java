package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;

public class StringReduction {

	
	public static void main(String[] args) {
		System.out.println(getMinDeletions("abcab"));
	}
	
	public static int getMinDeletions(String s) {
		List<String> data=new ArrayList<>();
		int deletions=0;
		for(String charc:s.split("")) {
			if(data.contains(charc)) {
				deletions++;
			}else {
				data.add(charc);
			}
		}
		return deletions;
	}
}
