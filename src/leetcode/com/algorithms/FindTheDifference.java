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
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int[] letter = new int[26];
        for (char c : s.toCharArray()) {
            letter[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            letter[c - 'a']--;
        }
        for (int i = 0; i < letter.length; i++) {
            if(letter[i] !=0 ) return (char) (i+'a');
        }
        return 'a';
    }
}
