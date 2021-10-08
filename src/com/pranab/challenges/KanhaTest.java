package com.pranab.challenges;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;


public class KanhaTest {
	public static void countSentences(List<String> wordSet,List<String> sentences) {
		List<Integer> length=new ArrayList<>();
		List<Integer> wordsumVal=new ArrayList<>();
		Map<Integer,Set<String>> angrams=new HashMap<>();
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<wordSet.size();i++) {
			String val=wordSet.get(i);
			length.add(val.length());
			int wordsum=0;
			for(int j=0;j<val.length();j++) {
				wordsum+=val.charAt(j);				
			}
			int present=wordsumVal.indexOf(wordsum);
			if(present==-1) {
				wordsumVal.add(wordsum);
			}else {
				wordsumVal.add(wordsum);
				if(val.length()==length.get(present)) {
					int uniqueKey=wordsum+val.length();
					if(angrams.containsKey(uniqueKey)) {
						Set<String> angramSet=angrams.get(uniqueKey);
						angramSet.add(val);
						angramSet.add(wordSet.get(present));
					}else {
						Set<String> angramSet=new HashSet<>();
						angramSet.add(val);
						angramSet.add(wordSet.get(present));
						angrams.put(uniqueKey, angramSet);
					}
				}
			}
		}
		//
		for(String sentence:sentences) {
			int resultdata=1;
			for(String word:sentence.split(" ")) {
				int wordLength=word.length();
				int wordsum=0;
				for(int j=0;j<word.length();j++) {
					wordsum+=word.charAt(j);				
				}
				int uniqueKey=wordsum+wordLength;
				if(angrams.containsKey(uniqueKey)) {
					Set<String> angramSet=angrams.get(uniqueKey);
					resultdata*=(angramSet.size());
				}
			}
			result.add(resultdata);
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) throws IOException {
		List<String> words=Arrays.asList("the","bats","tabs","in","cat","act");
		List<String> sentences=Arrays.asList("cat the bats","int the act","act tabs in");
		countSentences(words,sentences);
	}
}
