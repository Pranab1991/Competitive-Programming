package com.pranab.challenges;

import java.util.Scanner;

/**
 *  BInomial Coifficent(N,C)%P= N!%P/((C!)%P*(N-C)!%P)
 */
public class BinomialCofficentUnderModulo {
	public static final long PRIME=1000000007;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the Number N and the Choic C :");
		int number=sc.nextInt();
		int choice=sc.nextInt();
		long[] factorialTill10Lacs=calculateFactorialUnderPforFirst10LacsNumbers();
		long nFactorial=factorialTill10Lacs[number];
		long cFactorial=powerUnderModulo(factorialTill10Lacs[choice],PRIME-2,PRIME);
		long ncFactorial=powerUnderModulo(factorialTill10Lacs[number-choice],PRIME-2,PRIME);
		long result= ((nFactorial*cFactorial)%PRIME);
		result= ((result*ncFactorial)%PRIME);
		System.out.println(result);
	}

	private static long[] calculateFactorialUnderPforFirst10LacsNumbers() {
		long[] factorial=new long[1000000];
		factorial[0]=factorial[1]=1;
		for(int index=2;index<factorial.length;index++) {
			factorial[index]=(factorial[index-1]*index)%PRIME;
		}
		return factorial;
	}
	
	private static long powerUnderModulo(long number,long power,long modulo) {
		long result=1;
		while(power!=0) {
			if(power%2==1) {
				result=((result*number)%modulo);
				power--;
			}else {
				number=((number*number)%modulo);
				power/=2;
			}
		}
		return result;
	}
}
