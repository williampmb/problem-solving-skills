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
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        int posEnd = -1,posStart = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ' && posEnd == -1){
                posEnd = i;
            }else if(s.charAt(i) == ' ' && posEnd != -1 ){
                posStart = i;
                break;
            }
        }
        return posEnd - posStart;
    }
}
