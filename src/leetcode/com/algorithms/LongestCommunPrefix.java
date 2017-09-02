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
public class LongestCommunPrefix {
    
    //It solves the problem but the best approach is taking the smallest string
    // and make a binary search in the other ones looking for the characters
    
    public String longestCommonPrefix(String[] strs) {
        if(strs == null ) return "";
        int length = strs.length;
        if(length == 0) return "";
        if(length == 1) return strs[0];
        
        int prefixPointer =0;
        char match;
        
        for(int i = 0 ; i < strs[0].length();i++){
            match = strs[0].charAt(i);
            boolean hasPrefix = true;
            for(int j = 1 ; j < length ; j++){
                if(i > strs[j].length()-1 || strs[j].charAt(i) != match){
                    hasPrefix = false;
                    break;
                }
            }
            if(!hasPrefix) break;
            prefixPointer++;
        }
      
        
        return strs[0].substring(0,prefixPointer);
    }
}
