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
public class ReverseStringII {
    public static void main(String[] args){
        ReverseStringII r = new ReverseStringII();
        String reverseStr = r.reverseStr("abcdefg", 3);
        System.out.println(reverseStr);
        
    }
    public String reverseStr(String s, int k) {
        int length = s.length();
        StringBuilder reversed = new StringBuilder();
        for(int i = 0 ; i < length;i+=2*k){
            for(int j = i; j < i+2*k && j<length;j++){
                if(j <i+k){
                    reversed.insert(i, s.charAt(j));
                }else{
                    reversed.append(s.charAt(j));
                }
            }
        }
        return reversed.toString();
    }
}
