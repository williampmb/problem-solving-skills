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
public class TargetSum {

    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        int[] nums = {1,2,3,4,5};
        int findTargetSumWays = t.findTargetSumWays2(nums, 3);

        System.out.println(findTargetSumWays);
    }

    //backtracking approach
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = findTargetSumWays(nums, S, 0);
        return sum;
    }

    private int findTargetSumWays(int[] nums, int S, int pos) {
        if (pos == nums.length && S == 0) {
            return 1;
        }
        if (pos == nums.length && S != 0) {
            return 0;
        }

        int positive = findTargetSumWays(nums, S - nums[pos], pos + 1);
        int negative = findTargetSumWays(nums, S + nums[pos], pos + 1);

        return positive + negative;
    }
    
    //https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
    //Transforming to subset problem
     public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(S > sum || (sum + S) % 2 == 1)   return 0;
        return subsetSum(nums, (sum + S) / 2);
    }

     //@yuxiangmusic at leetcode O(n) space
    private int subsetSum(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }

    //@stevenlli at leetcode O(n^2) space
    public int subsetSum2(int[] nums, int S) {
        int[][] dp = new int[nums.length + 1][S + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 0) {
                dp[i][0] = dp[i - 1][0] * 2;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= S; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][S];
    }
}
