package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args){
        String s = "a1b2";

        List<String> letterCasePermutation = letterCasePermutation(s);
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        
        char[] cur = new char[S.length()];
        
        helper(ans,cur,S,0);

        return ans;
    }

    private static void helper(List<String> ans, char[] cur, String s, int pos) {
        if(cur.length == pos){
            String word = new String(cur);
            ans.add(word);
            return;
        }

        char c = s.charAt(pos);
        cur[pos] =c ;
        helper(ans,cur,s,pos+1);
        if(c>='a' && c <= 'z'){
            cur[pos] = (char) (c-32);
            helper(ans,cur,s,pos+1);
        }else if (c>='A' && c <= 'Z' ){
            cur[pos] = (char) (c+32);
            helper(ans,cur,s,pos+1);
        }
        

    }
}