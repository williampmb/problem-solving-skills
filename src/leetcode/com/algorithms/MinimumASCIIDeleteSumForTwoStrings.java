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
public class MinimumASCIIDeleteSumForTwoStrings {

    public int minimumDeleteSum(String s1, String s2) {
        int[][] count = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < s1.length(); i++) {
            count[i][0] = count[i - 1][0] + s1.charAt(i - 1);
        }
        for (int i = 1; i < s2.length(); i++) {
            count[0][i] = count[0][i - 1] + s2.charAt(i - 1);
        }

        for (int row = 1; row < s1.length() + 1; row++) {
            for (int col = 1; col < s2.length() + 1; col++) {
                int DeleteBothChar = s1.charAt(row - 1) != s2.charAt(col - 1) ? s1.charAt(row - 1) + s2.charAt(col - 1) : 0;
                count[row][col] = Math.min(count[row - 1][col] + s1.charAt(row - 1), count[row][col - 1] + s2.charAt(col - 1));
                count[row][col] = Math.min(count[row][col], count[row - 1][col - 1] + DeleteBothChar);
            }
        }
        return count[s1.length()][s2.length()];
    }
}
