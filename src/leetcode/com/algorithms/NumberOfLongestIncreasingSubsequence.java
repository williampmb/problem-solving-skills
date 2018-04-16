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
public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence n = new NumberOfLongestIncreasingSubsequence();

        //int[] nums = {1,2};
        int[] nums = {1,2,3,1,2,3,1,2,3};
        //int[] nums = {1, 3, 5, 4, 7};
        //int[] nums = {2, 2, 2, 2, 2};
        //int[] nums = {1,1,1,2,2,2,3,3,3};
        //int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        int findNumberOfLIS = n.findNumberOfLIS(nums);
        System.out.println(findNumberOfLIS);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int[] dp = new int[length];
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            count[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int prev = dp[i];
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    if (prev != dp[i]) {
                        count[i] = count[j];
                    } else if (prev == dp[i] && !(dp[j]+1< prev)) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int max = -1;
        for (int i = 0; i < length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i] == max) {
                sum += count[i];
            }
        }

        return sum;
    }
}
