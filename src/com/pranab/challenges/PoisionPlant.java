package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;

public class PoisionPlant {
	
	public static void main(String[] args) {
		//whatever is present
	}
	
	//method one as given
	public static int digit_based(int M) {	
		if(M==1) {
			return M;
		}
		for(int base=2;base<M;base++) {
			List<Integer> numList=convertToBase(M,base);
			//System.out.println(base);
			boolean allsame=true;
			int first=numList.get(0);
			for(int nums:numList) {
				if(first!=nums) {
					allsame=false;
					break;
				}
			}
			if(allsame) {
				return base;
			}
		}
		return 0;
	}
	
	//submothed
	public static List<Integer> convertToBase(int num, int base) {
		int reminder=-1,quotent=-1;
		List<Integer> list=new ArrayList<>();
		while(quotent!=0) {
			quotent=num/base;
			reminder=num%base;
			list.add(reminder);
			num=quotent;
		}
		return list;
	}

}
