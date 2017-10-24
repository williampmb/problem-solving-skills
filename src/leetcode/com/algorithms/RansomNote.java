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
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        for (char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--chars[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
