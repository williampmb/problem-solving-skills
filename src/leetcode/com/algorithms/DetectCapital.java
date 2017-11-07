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
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int upperCase = 0;
        int lowerCase = 0;
        int size = word.length();

        for (int i = 1; i < size; i++) {
            if (word.charAt(i) >= 97) {
                lowerCase++;
            } else {
                upperCase++;
            }
            if ((upperCase != 0 && lowerCase != 0) || (word.charAt(0) >= 97 && upperCase > 0)) {
                return false;
            }
        }
        
        return true;
    }
}
