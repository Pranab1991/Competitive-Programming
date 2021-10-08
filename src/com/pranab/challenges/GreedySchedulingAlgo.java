package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GreedySchedulingAlgo {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan=new Scanner(new File("greedyInput.txt"));
		int inputSize=scan.nextInt();
		List<Model> dataStore=new ArrayList<>();
		while(scan.hasNext()) {
			Model job=new Model();
			job.weight=scan.nextInt();
			job.length=scan.nextInt();
			job.score=job.weight-job.length;
			dataStore.add(job);
		}
		
		Collections.sort(dataStore, (o1,o2)-> {
				int result=o1.score-o2.score;
				//System.out.println(o1+"   "+o2);
				if(result!=0) {
					//System.out.println("inside:" +-1*result);
					return -1*result;
				}
				//System.out.println("outside:" +-1*(o1.weight-o2.weight));
				return -1*(o1.weight-o2.weight);
			});
		
		long sum=0;
		int completionTime=0;
		for(Model o1:dataStore) {
			completionTime+=o1.length;
			sum+=o1.weight*completionTime;
		}
		System.out.println(sum);
		scan.close();
	}

}


class Model{
	public int score;
	public int weight;
	public int length;
	@Override
	public String toString() {
		return "Model [score=" + score + ", weight=" + weight + ", length=" + length + "]";
	}
	
	
}