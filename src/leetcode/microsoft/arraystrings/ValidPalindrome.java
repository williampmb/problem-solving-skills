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
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(v.isPalindrome(s));
        
    }

    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0 ) return true;
        int left = 0, right = s.length() - 1, length = s.length();

        while (left < right && !isValidChar(s, left)) {
            left++;
        }

        while (right > left && !isValidChar(s, right)) {
            right--;
        }
        while (left < right) {
            if (isCharsDif(s, left, right)) {
                return false;
            }
            left++;
            right--;
            while (left < right && !isValidChar(s, left)) {
                left++;
            }
            while (right > left && !isValidChar(s, right)) {
                right--;
            }
        }

        return true;
    }

    public boolean isValidChar(String s, int pos) {
        char valid = s.charAt(pos);

        if ((valid <= 'z' && valid >= 'a')
                || (valid <= 'Z' && valid >= 'A')
                || (valid <= '9' && valid >= '0')) {
            return true;
        }
        return false;
    }

    private boolean isCharsDif(String s, int left, int right) {
        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);
        if(leftChar <= 'Z') leftChar += 32;
        if(rightChar <= 'Z') rightChar += 32;
        return leftChar != rightChar;
    }
}
