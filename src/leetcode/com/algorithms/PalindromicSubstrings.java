/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class PalindromicSubstrings {
    public static void main(String[] args){
        PalindromicSubstrings p = new PalindromicSubstrings();
        int c = p.countSubstrings("aaa");
        
        System.out.println(c);
    }
    

    public int countSubstrings(String s) {
        int count = 0;

        if (s == null || s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            count += countSubstrings(i, i, s);
            count += countSubstrings(i, i + 1, s);

        }
        return count;
    }

    public int countSubstrings(int left, int right, String s) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
