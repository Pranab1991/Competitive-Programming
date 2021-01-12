package com.pranab.challenges;

import java.util.HashMap;
import java.util.Map;

public class CountMax {
	
	public void maxCount() {
		String str = "aabbaaakkkkkkkkbbaaaabbaaaak";
		String[] arr=str.split("");
		/*Map<String,Integer> charIntCount=new HashMap<>();
		for(String charc:arr) {
			if(charIntCount.containsKey(charc)) {
				charIntCount.put(charc,charIntCount.get(charc)+1);
			}else {
				charIntCount.put(charc, 1);
			}
		}*/
		int max_count=0,cur_count=0;
		String max_char=null,cur_char=null;
		for(String charc:arr) {
			if(charc!=cur_char) {

				if(cur_count>max_count) {
					max_count=cur_count;
					max_char=cur_char;
				}
				cur_char=charc;
				cur_count=1;
			}else {
				cur_count++;
			}
		}
	}

}
