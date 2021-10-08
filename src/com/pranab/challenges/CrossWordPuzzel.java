package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result28 {

	/*
	 * Complete the 'crosswordPuzzle' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * following parameters: 1. STRING_ARRAY crossword 2. STRING words
	 */

	public static List<String> crosswordPuzzle(List<String> crossword, String words) {
		String[] arryOfWords = words.split(";");
		Map<Integer, List<String>> legthStringMap = new HashMap<>();
		for (String word : arryOfWords) {
			int wordLength = word.length();
			if (legthStringMap.containsKey(wordLength)) {
				List<String> wordsCollectionOfLength = legthStringMap.get(wordLength);
				wordsCollectionOfLength.add(word);
			} else {
				List<String> newWordsCollectionOfLength = new ArrayList<>();
				newWordsCollectionOfLength.add(word);
				legthStringMap.put(wordLength, newWordsCollectionOfLength);
			}
		}
		solvePuzzle(crossword, legthStringMap, 0, 0);
		return crossword;
	}

	public static boolean solvePuzzle(List<String> crossword, Map<Integer, List<String>> legthStringMap,
			int startOfIIndex, int startOfJIndex) {
		if (legthStringMap.isEmpty()) {
			return true;
		}
		int iteratableJindex = startOfJIndex;
		for (int iteratableIindex = startOfIIndex; iteratableIindex < crossword.size(); iteratableIindex++) {
			String row = crossword.get(iteratableIindex);
			for (; iteratableJindex < row.length(); iteratableJindex++) {
				if (row.charAt(iteratableJindex) == '-') {

					String blankLengthAndType = checkBlankSpaceAvailable(iteratableIindex, iteratableJindex, crossword);

					String[] blankLengthValues = blankLengthAndType.split(" ");
					String blankLengthType = blankLengthValues[1];
					int blankLength = Integer.parseInt(blankLengthValues[0]);
					int blankLengthBack = Integer.parseInt(blankLengthValues[2]);
					List<String> wordsCollectionOfLength = legthStringMap.get(blankLength);
					List<String> crosswordOld = new ArrayList<>(crossword);

					for (String word : wordsCollectionOfLength) {
						if ("R".equals(blankLengthType)) {
							iteratableJindex -= blankLengthBack;
						} else {
							iteratableIindex -= blankLengthBack;
						}

						boolean couldFitTheWord = fillUpThePuzzle(crossword, word, blankLengthType, iteratableIindex,
								iteratableJindex, blankLength);

						if (couldFitTheWord) {
							if ("R".equals(blankLengthType)) {
								iteratableJindex += blankLength;
							} else {
								iteratableJindex++;
								iteratableIindex += blankLengthBack;
							}
							formNewList(legthStringMap, blankLength, wordsCollectionOfLength, word);
							boolean result = solvePuzzle(crossword, legthStringMap, iteratableIindex, iteratableJindex);

							if (result) {
								return result;
							} else {
								if ("R".equals(blankLengthType)) {
									iteratableJindex -= blankLength;
								} else {
									iteratableJindex--;
									iteratableIindex -= blankLengthBack;
								}
								for (int i = 0; i < crosswordOld.size(); i++) {
									crossword.set(i, crosswordOld.get(i));
								}
								continue;
							}
						}
					}
					return false;
				}
			}
			iteratableJindex = 0;
		}
		return false;
	}

	private static String checkBlankSpaceAvailable(int startOfIIndex, int startOfJIndex, List<String> crossword) {
		int rowblanklength = 0;
		int rowblanklengthBack = 0;
		int columnBlankLength = 0;
		int columnBlankLengthBack = 0;
		int incrementorIIndex = startOfIIndex;
		int incrementorjIndex = startOfJIndex;
		while ((incrementorjIndex <= 9) && crossword.get(startOfIIndex).charAt(incrementorjIndex) != '+') {
			rowblanklength++;
			incrementorjIndex++;
		}
		incrementorjIndex = startOfJIndex;
		while ((incrementorjIndex != 0) && crossword.get(startOfIIndex).charAt(--incrementorjIndex) != '+') {
			rowblanklengthBack++;
		}
		while ((incrementorIIndex <= 9) && crossword.get(incrementorIIndex).charAt(startOfJIndex) != '+') {
			columnBlankLength++;
			incrementorIIndex++;
		}
		incrementorIIndex = startOfIIndex;
		while ((incrementorIIndex != 0) && crossword.get(--incrementorIIndex).charAt(startOfJIndex) != '+') {
			columnBlankLengthBack++;
		}
		int totalBlankLengthRow = rowblanklength + rowblanklengthBack;
		int totalBlankLengthColumn = columnBlankLength + columnBlankLengthBack;
		if (totalBlankLengthRow > totalBlankLengthColumn) {
			return totalBlankLengthRow + " R " + rowblanklengthBack;
		} else {
			return totalBlankLengthColumn + " C " + columnBlankLengthBack;
		}
	}

	private static boolean fillUpThePuzzle(List<String> crossword, String word, String blankLengthType,
			int startOfIIndex, int startOfJIndex, int blankLength) {
		boolean wordFits = true;
		String[] eachValueOfWord = word.split("");
		if ("R".equals(blankLengthType)) {
			String[] eachValueOfBlank = crossword.get(startOfIIndex).split("");
			for (int iteratorJIndex = startOfJIndex, wordIterator = 0; wordIterator < blankLength; iteratorJIndex++, wordIterator++) {
				if ("-".equals(eachValueOfBlank[iteratorJIndex])) {
					eachValueOfBlank[iteratorJIndex] = eachValueOfWord[wordIterator];
				} else {
					if (eachValueOfBlank[iteratorJIndex].equals(eachValueOfWord[wordIterator])) {
						continue;
					} else {
						wordFits = false;
						return wordFits;
					}
				}
			}
			StringBuilder newRow = new StringBuilder();
			for (String charecter : eachValueOfBlank) {
				newRow.append(charecter);
			}
			crossword.set(startOfIIndex, newRow.toString());
		} else {
			for (int iteratorIIndex = startOfIIndex, wordJterator = 0; wordJterator < blankLength; iteratorIIndex++, wordJterator++) {
				String operatedString = crossword.get(iteratorIIndex);
				StringBuilder columnBuilder = new StringBuilder(operatedString);
				if ('-' == (operatedString.charAt(startOfJIndex))) {
					columnBuilder.setCharAt(startOfJIndex, eachValueOfWord[wordJterator].charAt(0));
				} else {
					if ((operatedString.charAt(startOfJIndex) == (eachValueOfWord[wordJterator]).charAt(0))) {
						continue;
					} else {
						wordFits = false;
						return wordFits;
					}
				}
				crossword.set(iteratorIIndex, columnBuilder.toString());
			}
		}

		return wordFits;
	}

	private static void formNewList(Map<Integer, List<String>> legthStringMap, int blankLength,
			List<String> wordsCollectionOfLength, String word) {
		List<String> newWordsCollectionOfLength = new ArrayList<>(wordsCollectionOfLength);
		newWordsCollectionOfLength.remove(word);
		if (newWordsCollectionOfLength.isEmpty()) {
			legthStringMap.remove(blankLength);
		} else {
			legthStringMap.put((blankLength), newWordsCollectionOfLength);
		}
	}
}

public class CrossWordPuzzel {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		List<String> crossword = IntStream.range(0, 10).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		String words = bufferedReader.readLine();

		List<String> result = Result28.crosswordPuzzle(crossword, words);

		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
