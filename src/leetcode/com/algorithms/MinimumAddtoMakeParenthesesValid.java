/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int stack =0, count =0;
        for(char c : S.toCharArray()){
            if(c == '(')stack++;
            else if(c==')' && stack ==0) count++;
            else stack--;
        }
        return stack+count;
    }
}
