package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.Stack;

public class TwoStackQueue {

	public static void main(String[] args) throws FileNotFoundException {
		Instant start = Instant.now();
		Scanner in = new Scanner(new File("input04.txt"));
        int noElements = in.nextInt();
        
        Stack<Integer> one = new Stack<Integer>();
        Stack<Integer> two = new Stack<Integer>();
        
        int command;
        
        for (int i = 0 ; i < noElements ; i++) {
            command = in.nextInt();
            
            if (command == 1)
            {
                one.push(in.nextInt());
            } 
            else if (command == 2)
            {
                if(two.isEmpty())
                {
                    while(!one.isEmpty())
                    {
                        two.push(one.pop());
                    }                    
                }
                
                if (!two.isEmpty()){                                
                    two.pop(); 
                }

            }
            else if (command == 3)
            {       
                if(two.isEmpty())
                {
                    while(!one.isEmpty())
                    {
                        two.push(one.pop());
                    }
                    System.out.println(two.peek());
                } 
                else 
                {
                    System.out.println(two.peek());
                }
            }
        }
        Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
        in.close();
	}
}
