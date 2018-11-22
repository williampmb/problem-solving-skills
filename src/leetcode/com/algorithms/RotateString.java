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
public class RotateString {
    public boolean rotateString(String A, String B) {
        if(A == null || B == null) return false;
        int i =0, j=0,cur=0, sa = A.length(), sb = B.length();
        if(sa != sb) return false;
        
        while(j<sa && i <sb){
            if(A.charAt(cur)!=B.charAt(i)){
                i=0;
                j++;
                cur=j;
            }else{
                cur++;
                cur= sa%j;
                i++;
            }
        }
        
        return i == sb;
        
    }
    
    public boolean rotateString2(String A, String B) {
        if (A.length() != B.length()) return false;
        A = A + A;
        return A.contains(B);
    }
}
