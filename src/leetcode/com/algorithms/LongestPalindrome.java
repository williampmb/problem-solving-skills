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
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("abcABAcabdaefrty"));

    }

    public int longestPalindrome(String s) {
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lowerCase[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                upperCase[c - 'A']++;
            }
        }

        boolean singleOne = false;
        int palindromeSize = 0;
        
        for(int x = 0 ; x < 26;x++){
            if (lowerCase[x] % 2 == 0)  palindromeSize += lowerCase[x];
            else{
                singleOne= true;
                palindromeSize += lowerCase[x]-1;
            }
            if (upperCase[x] % 2 == 0)  palindromeSize += upperCase[x];
            else {
                singleOne = true;
                palindromeSize += upperCase[x]-1;
            }
            
        }
        
        if (singleOne) {
            palindromeSize++;
        }
        return palindromeSize;
    }
}
