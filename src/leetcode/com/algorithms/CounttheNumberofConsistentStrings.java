package leetcode.com.algorithms;

import java.util.HashSet;
import java.util.Set;

public class CounttheNumberofConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Integer> charsAllowed = new HashSet<>();
        int ans = 0;
        for(int i =0 ; i < allowed.length();i++){
            charsAllowed.add((int)allowed.charAt(i));
        }

        for(String word: words){
            boolean ok = true;
            for(char w : word.toCharArray()){
                if(!charsAllowed.contains((int) w)){
                    ok = false;
                    break;
                }
            }
            if(ok){
                ans++;
            }
        }

        return ans;
    }
}
