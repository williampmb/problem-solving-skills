package leetcode.com.algorithms.algorithmI;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
 
    public static void main(String[] args){


        lengthOfLongestSubstring("pwwkew");
    }



    public static int lengthOfLongestSubstring(String s){
        int max = 0;
        int curretMax = 0;

        Set<Character> db = new HashSet<>();

        int left =0;
        for(int i =0 ; i < s.length(); i++){
            char charAt = s.charAt(i);
            if(!db.contains(charAt)){
                curretMax++;
            }else{
                char leftChar = s.charAt(left);
                while(left < i && leftChar != charAt ){
                    curretMax--;
                    left++;
                    db.remove(leftChar);
                    leftChar = s.charAt(left);
                }
                left++;
            }
            db.add(charAt);
            max = Math.max(max,curretMax);
        }
        
        return max;
    }
}
