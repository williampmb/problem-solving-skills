/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

/**
 *
 * @author William Barbosa
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString r = new ReverseWordsInAString();
        String s = "   a  abe  d qee   q q    e";
        String reverseWords = r.reverseWords(s);
        System.out.println(reverseWords);
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        int left = 0, right = s.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= left && s.charAt(right) == ' ') {
            right--;
        }

        while (right >= left) {
            int wordStart = right;

            while (wordStart >= left && s.charAt(wordStart) != ' ') {
                wordStart--;
            }
            int tmpStart = wordStart;
            while (wordStart < right) {
                ans.append(s.charAt(++wordStart));
            }
            
            right = tmpStart-1;
            if (right >= left) {
                ans.append(" ");
            }
            
            while(right >= left && s.charAt(right) == ' '){
                right--;
            }
        }
        return ans.toString();
    }
}
