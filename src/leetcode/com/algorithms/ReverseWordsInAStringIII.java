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
        System.out.println(r.reverWords2("a bcd"));
        System.out.println(r.reverWords2("a bc d"));
        System.out.println(r.reverWords2("a bc d "));
        System.out.println(r.reverWords2("a"));
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

    public String reverWords2(String s){

        char[] charsOfS = s.toCharArray();

        int start = 0;
        int end = 0;

        for(int i = 0 ; i < charsOfS.length; i++){
            if(charsOfS[i]==' '){
                reverseWordInArr(charsOfS,start,end-1);
                start = i +1;
                end = i +1;
            }else{
                end++;
            }
        }
        
        reverseWordInArr(charsOfS,start,end-1);

        return new String(charsOfS);

    }

    private void reverseWordInArr(char[] arr, int start, int end) {
        while(start<end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
