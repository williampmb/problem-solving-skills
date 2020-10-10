package leetcode.com.algorithms;

public class SplitAStringInBalancedStrings{
    public int balancedStringSplit(String s) {
        int size = s.length(),stack = 0, countSb =0;
        
        for(int i = 0; i< size; i++){
            int letter = s.charAt(i) == 'R' ? 1: 0;
            stack +=letter;
            if(stack == 0){
                countSb++;
            }
        }

        return countSb;
    }
}