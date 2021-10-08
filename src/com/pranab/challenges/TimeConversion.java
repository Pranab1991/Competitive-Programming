package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    
    static String timeConversion(String s) {
    	String[] input=s.split(":");
    	if(input[2].contains("AM")) {
    		if(input[0].equals("12")) {
    			input[0]="00";
    		}
    	}else {
    		if(!input[0].equals("12")) {
    			input[0]=(Integer.parseInt(input[0])+12)+"";
    		}
    	}
    	input[2]= input[2].substring(0, 2);
    	return input[0]+":"+input[1]+":"+input[2];
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();*/

        System.out.println(timeConversion("01:01:00PM"));

        /*bw.write(result);
        bw.newLine();

        bw.close();*/
    }
}

