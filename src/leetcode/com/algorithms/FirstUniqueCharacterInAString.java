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
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] db = new int[26];
        for(char c : s.toCharArray()) db[c-'a']++;
        for(int i = 0 ; i< s.length();i++){
            if(db[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
