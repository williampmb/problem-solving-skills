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
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null ) return -1;
        int needLen = needle.length(), hayLen = haystack.length();
        if(needLen == 0 && hayLen == 0) return 0;
        if(hayLen != 0 && needLen == 0) return 0;
        if(needLen > hayLen) return -1;
        for(int i = 0 ; i <= hayLen - needLen; i++)
            if(haystack.charAt(i) == needle.charAt(0))
                if(haystack.substring(i,i+needLen).equals(needle)) return i;
        return -1;
    }
}
