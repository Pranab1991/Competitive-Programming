package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result19 {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
    	 LinkedList<Integer> containers = new LinkedList<>();
         LinkedList<Integer> balls = new LinkedList<>();
         for(int i = 0; i < container.size(); i++){
             int rowSum = 0;
             int colSum = 0;
             for(int j = 0; j < container.get(0).size(); j++){
                 rowSum += container.get(i).get(j); 
                 colSum += container.get(j).get(i);
             }
             balls.add(colSum);
             containers.add(rowSum);
         }
         
         //Check if the two bags are equal
         containers.removeAll(balls);
         if(containers.isEmpty()) {
        	 return "Possible";
         }
         else {
        	 return "Impossible";
         }
    }

}

public class Organise_Container {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] containerRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> containerRowItems = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowTempItems[j]);
                    containerRowItems.add(containerItem);
                }

                container.add(containerRowItems);
            }

            String result = Result19.organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
