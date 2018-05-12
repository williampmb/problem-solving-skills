/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

/**
 *
 * @author William Barbosa
 */
public class ReverseString {
     public String reverseString(String s) {
        if(s == null) return null;
        StringBuilder ans = new StringBuilder();
        
        for(int i = s.length()-1 ; i >=0 ; i--){
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
