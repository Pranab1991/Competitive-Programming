package com.pranab.challenges;




import java.util.*;




class _TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        String inputData = s.nextLine();                 
        String dataleft=inputData.substring(0,inputData.length()/2);   
        String dataRight=inputData.substring(inputData.length()/2);
        recurse(dataRight,dataleft);
    }

    public static String recurse(String dataleft,String dataRight){
        if(dataleft.charAt(dataleft.length()-1)==dataRight.charAt(0)){
            int count_left=1;
            int count_right=1;
            char match_char=dataRight.charAt(0);
            for(int index=(dataleft.length()-2);index>=0;index--){
                if(dataleft.charAt(index)==match_char){
                    count_left++;
                    continue;
                }
                break;
            }
            for(int index=1;index<dataRight.length();index++){
                if(dataRight.charAt(index)==match_char){
                    count_right++;
                    continue;
                }
                break;
            }
            String leftNew=dataleft.substring(0,(dataleft.length()-count_left));
            String rightNew=dataRight.substring(count_right);
            return recurse(leftNew,rightNew);
        }else{
            return dataleft+dataRight;
        }
    }
}
