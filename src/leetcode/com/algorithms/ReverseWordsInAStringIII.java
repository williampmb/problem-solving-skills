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
public class ReverseWordsInAStringIII {
    public static void main (String[] args){
        ReverseWordsInAStringIII r = new ReverseWordsInAStringIII();
        String reverseWords = r.reverseWords(" ");
        System.out.println(reverseWords);
    }
    public String reverseWords(String s) {
        int size = s.length();
        StringBuilder wholeString = new StringBuilder();
        StringBuilder eachWord = new StringBuilder();
        for(int i = 0; i < size; i++){
            if(s.charAt(i) == ' '){
                wholeString.append(eachWord.toString() + " ");
                eachWord = new StringBuilder();
            }else{
                eachWord.insert(0, s.charAt(i));
            }
        }
        wholeString.append(eachWord.toString());
        return wholeString.toString();
    }
}
