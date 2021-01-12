package com.pranab.challenges;

public class ValidatCapital {
	
	public static void main(String[] args) {
		boolean isValid=false;
		if(args[0].charAt(0)>=97&&args[0].charAt(0)<=122) {
			for(int index=1;index<args[0].length();index++) {
				if((args[0].charAt(index)>=97&&args[0].charAt(index)<=122)) {
					isValid=true;
					continue;
				}
				isValid=false;
				break;
			}
		}else if(args[0].charAt(0)>=65&&args[0].charAt(0)<=90) {
			if(args[0].charAt(1)>=97&&args[0].charAt(1)<=122) {
				for(int index=2;index<args[0].length();index++) {
					if((args[0].charAt(index)>=97&&args[0].charAt(index)<=122)) {
						isValid=true;
						continue;
					}
					isValid=false;
					break;
				}
			}else if(args[0].charAt(1)>=65&&args[0].charAt(1)<=90) {
				for(int index=2;index<args[0].length();index++) {
					if((args[0].charAt(index)>=65&&args[0].charAt(index)<=90)) {
						isValid=true;
						continue;
					}
					isValid=false;
					break;
				}
			}
		}
		System.out.println(isValid);
	}
}
