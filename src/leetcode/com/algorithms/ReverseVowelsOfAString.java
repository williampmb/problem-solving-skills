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
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int start =0, end = s.length()-1;
        char[] arr = s.toCharArray();
        while(start<end){
            if(isVowel(arr[start]) && isVowel(arr[end])){
                swap(start,end,arr);
                start++;
                end--;
            }else{
                while(start<end && !isVowel(arr[start]))
                    start++;
                while(start<end && !isVowel(arr[end]))
                    end--;
            }
        }
        
        return new String(arr);
    }
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    
    public void swap(int pos1, int pos2, char[] arr){
        char tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
        
    }
}
