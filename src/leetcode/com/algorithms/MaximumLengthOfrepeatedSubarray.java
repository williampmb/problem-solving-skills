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
public class MaximumLengthOfrepeatedSubarray {

    public static void main(String[] args) {
        MaximumLengthOfrepeatedSubarray m = new MaximumLengthOfrepeatedSubarray();
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        int findLength = m.findLength(A, B);
        System.out.println(findLength);
    }

    //DP, similar than commum substring of two strings
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int longest = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    longest = Math.max(longest, dp[i][j]);
                }
            }
        }

        return longest;
    }

}
