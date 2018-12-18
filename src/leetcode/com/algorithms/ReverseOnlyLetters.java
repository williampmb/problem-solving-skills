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
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] ans = S.toCharArray();
        int start=0,end=ans.length-1;
        
        while(start <end){
            start = nextChar(ans,start,1);
            end = nextChar(ans,end,-1);
            
            if(start<ans.length && start<end){
                char tmp = ans[start];
                ans[start]=ans[end];
                ans[end]=tmp;
                start++;
                end--;
            }
        }
        
        return new String(ans);
    }
    
    public int nextChar(char[] letter, int pos, int add){
        
        while(pos>=0 && pos<letter.length){
            if((letter[pos]>='A' && letter[pos] <='Z') || (letter[pos]>='a' && letter[pos] <='z'))
                return pos;
            pos+=add;
        }
        return pos;
    }
}
