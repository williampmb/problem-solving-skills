package leetcode.com.algorithms;

public class FindFirstPalindromicStringintheArray {
    
public static void main(String[] args){

    System.out.println(firstPalindrome(new String[]{"abc"}));
}

    public static String firstPalindrome(String[] words) {
     
        for(String word: words){
            if(isPalindrome(word)){
                return word;
            }
        }

        return "";
    }

    public static boolean isPalindrome(String word){
        int start =0;
        int end = word.length()-1;

        while(start >= end){
            if(word.charAt(start) != word.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
