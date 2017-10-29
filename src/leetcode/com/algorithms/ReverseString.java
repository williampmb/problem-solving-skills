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
public class ReverseString {

    public String reverseString(String s) {
         if(s == null) return "";
        int length = s.length();
        StringBuilder reverse = new StringBuilder();
        for(int i = length-1 ; i >=0 ; i--){
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
    }
}
