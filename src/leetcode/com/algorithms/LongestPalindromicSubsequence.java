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
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return longestPalindromeSubseq(s, 0, s.length(), memo);
    }

    //@tankztc at leetcode
    private int longestPalindromeSubseq(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = longestPalindromeSubseq(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(longestPalindromeSubseq(s, i + 1, j, memo), longestPalindromeSubseq(s, i, j - 1, memo));
        }
        return memo[i][j];
    }

    //iterative approach
    public int longestPalindromeSubseq2(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

}
