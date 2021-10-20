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

class Result85 {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
     int index=-1; boolean indicator=false;
     for(int i=0,j=s.length()-1;j>i;i++,j--){
      if(s.charAt(i)!=s.charAt(j)&&(!indicator)){
          if(s.charAt(i+1)==s.charAt(j)){
            index=i;
            i++;
            indicator=true;  
          }else if(s.charAt(i)==s.charAt(j-1)){
              index=j;
              j--;
              indicator=true;         	  
          }else{
            index=-1;
            break;  
          }
      }else if(s.charAt(i)!=s.charAt(j)&&(indicator)){
          index=-1;
            break; 
      }   
     }
     return index;
    }

}

public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result85.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
