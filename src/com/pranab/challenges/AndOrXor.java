package com.pranab.challenges;

import java.util.Scanner;
import java.util.Stack;

public class AndOrXor {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        int[] arr = new int[N];
	        for(int i = 0; i < N; i++){
	            arr[i] = sc.nextInt();
	        }
	        int max = 0;
	        Stack<Integer> stack = new Stack();
	        for(int i = 0; i < N; i++){
	            while(!stack.isEmpty()){
	                int temp = stack.peek() ^ arr[i];
	                max = Math.max(temp,max);
	                if(arr[i]<stack.peek()) {
	                    stack.pop();
	                }else{
	                    break;
	                }
	            }
	            stack.push(arr[i]);
	        }
	        System.out.println(max);

	 }
}