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
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)) return -1;
        int size1 = a.length();
        int size2 = b.length();
        return size1>size2?size1:size2;
    }
}
