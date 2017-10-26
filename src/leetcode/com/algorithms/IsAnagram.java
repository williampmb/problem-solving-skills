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
public class IsAnagram {
    
    //Based on lowercase alphabets we have just 26 chars. So we create an array
    // with size equal to 26 and add all characters from s and subtracts all
    // characters from t. If there is any number diff from 0, it means it is not
    // anagram.
    // Follow up: we should use a bigger array to fit all symbols from unicode
    // and treat more than one char as part of a single unicode.
    public boolean isAnagram(String s, String t) {
        int[] anagram = new int[26];
        
        for(char c : s.toCharArray()) anagram[c-'a']++;
        for(char c : t.toCharArray()) anagram[c-'a']--;
        for(int i : anagram) if(i !=0) return false;
        return true;
    }
}

