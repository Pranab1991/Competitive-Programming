package com.pranab.challenges;
import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

/*public class Solution {

    public static void main(String[] args) throws IOException {
    	LocalTime start = LocalTime.now();
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input05.txt"))));
        int n = Integer.parseInt(in.readLine());
        int[] frequencies = new int[100];
        StringBuilder STDOUTT = new StringBuilder("");
        Map<Integer,Queue<StringBuilder>> order = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            String[] tmp = in.readLine().split(" ");
            int num = Integer.parseInt(tmp[0]);
            
            StringBuilder s = new StringBuilder(tmp[1]);
            if(i < n/2) s = new StringBuilder("-");//use - as s for first half
            
            //add the string to the queue associated with num
            if(!order.containsKey(num))
            {
                Queue<StringBuilder> strs = new LinkedList();
                order.put(num, strs);
            }
                order.get(num).add(s);
                
            frequencies[num] = frequencies[num] + 1;
        }
        
        //For all sorted numbers
        for(int i = 0; i < frequencies.length; i++)
        {
            for(int j = 0; j < frequencies[i]; j++)
            {
                STDOUTT.append(order.get(i).poll().toString() + " ");//Print every element from the queue
            }
        }
        System.out.print(STDOUTT);
        LocalTime end = LocalTime.now();
		Duration duration = Duration.between(start, end);
		System.out.println();
		System.out.println("Time duration : " + duration);
    }
}*/

/*import java.io.*;
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

class Result55 {

  

    public static int findMedian(List<Integer> arr) {
        Integer[] arra=new Integer[arr.size()];
        for(int i=0;i<arr.size();i++){
            arra[i]=arr.get(i);
        }
         quickSort(arra,0,arr.size()-1);
         int medianIndex=(arr.size()/2);
         return arra[medianIndex];      
    }

    public static void quickSort(Integer[] inputArray,int startIndex,int endIndex) {
        if(startIndex==endIndex) {
            return;
        }
        int key=inputArray[startIndex];
        int endPointer=endIndex+1;
        for(int j=(endPointer-1);j>startIndex;j--) {
            if(inputArray[j]>key) {
                endPointer--;
                swap(inputArray,j,endPointer);
            }
        }
        int partionIndex=--endPointer;
        swap(inputArray,partionIndex,startIndex);
        
        int lowerpartition=partionIndex-1;
        if(lowerpartition<startIndex) {
            lowerpartition=startIndex;
        }
        quickSort(inputArray,startIndex,lowerpartition);
        int higherPartition=partionIndex+1;
        if(higherPartition>endIndex) {
            higherPartition=endIndex;
        }
        quickSort(inputArray,higherPartition,endIndex);
        //printArray(inputArray,0,inputArray.length);
    }
    
    private static void swap(Integer[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result55.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/

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

class Result55 {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    	Map<Integer,List<Integer>> myMap=new HashMap<>();
    	Integer[] arra=new Integer[arr.size()];
        for(int i=0;i<arr.size();i++){
            arra[i]=arr.get(i);
        }
         quickSort(arra,0,arr.size()-1);
         for(int i=1;i<arr.size();i++) {
        	 int prevElement=arra[i-1];
        	 int currentElement=arra[i];
        	 int distance=Math.abs(prevElement-currentElement);
        	 if(myMap.containsKey(distance)) {
        		 myMap.get(distance).add(prevElement);
        		 myMap.get(distance).add(currentElement);
        	 }else {
        		 List<Integer> list=new ArrayList<>();
        		 list.add(prevElement);
        		 list.add(currentElement);
        		 myMap.put(distance,list );
        	 }
         }
         int minDistatnce=Integer.MAX_VALUE;
         for(int distance:myMap.keySet()) {
        	 if(distance<minDistatnce) {
        		 minDistatnce=distance;
        	 }
         }
         return myMap.get(minDistatnce); 
    }
    
    public static void quickSort(Integer[] inputArray,int startIndex,int endIndex) {
        if(startIndex==endIndex) {
            return;
        }
        int key=inputArray[startIndex];
        int endPointer=endIndex+1;
        for(int j=(endPointer-1);j>startIndex;j--) {
            if(inputArray[j]>key) {
                endPointer--;
                swap(inputArray,j,endPointer);
            }
        }
        int partionIndex=--endPointer;
        swap(inputArray,partionIndex,startIndex);
        
        int lowerpartition=partionIndex-1;
        if(lowerpartition<startIndex) {
            lowerpartition=startIndex;
        }
        quickSort(inputArray,startIndex,lowerpartition);
        int higherPartition=partionIndex+1;
        if(higherPartition>endIndex) {
            higherPartition=endIndex;
        }
        quickSort(inputArray,higherPartition,endIndex);
        //printArray(inputArray,0,inputArray.length);
    }
    
    private static void swap(Integer[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String line=bufferedReader.readLine();
        List<Integer> arr = Stream.of(line.replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result55.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
