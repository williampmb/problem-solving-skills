/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        for (char d : digits.toCharArray()) {
            if (d == '1' || d == '0') {
                return ans;
            }
        }
        helper(ans, digits, 0, new StringBuilder());

        return ans;
    }

    private void helper(List<String> ans, String digits, int pos, StringBuilder comb) {
        if (pos == digits.length()) {
            ans.add(comb.toString());
            return;
        }
        String possibilites = getChars(digits.charAt(pos));
        for (char c : possibilites.toCharArray()) {
            comb.append(c);
            helper(ans, digits, pos + 1, comb);
            comb.setLength(comb.length() - 1);
        }

    }

    private String getChars(char numb) {
        switch (numb) {
            case '1':
                return "";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
            //throw exception;
        }
        return "";
    }
}
