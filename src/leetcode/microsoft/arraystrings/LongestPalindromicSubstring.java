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
public class LongestPalindromicSubstring {

    //O(n^2) solution. There is Manacher's algorithm to solve in O(n) though
    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String s = "abaxabaxabb";
        String longestPalindrome = l.longestPalindrome(s);
        System.out.println(longestPalindrome);

    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return s;
        }
        int beg = 0, end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int[] pos = checkPadindrome(s, i, i);
            if (pos[1] - pos[0] > end - beg) {
                end = pos[1];
                beg = pos[0];
            }

            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                pos = checkPadindrome(s, i, i + 1);
                if (pos[1] - pos[0] > end - beg) {
                    end = pos[1];
                    beg = pos[0];
                }
            }
        }
        return s.substring(beg, end + 1);
    }

    private int[] checkPadindrome(String s, int left, int right) {

        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if ((left < 0 || right > s.length() - 1) || (s.charAt(left) != s.charAt(right))) {
            left++;
            right--;
        }

        return new int[]{left, right};
    }
}
