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
public class PartitionEqualSubsetSum {
    public static void main(String[] args){
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int[] nums = {2,6,2,5};
        boolean canPartition = p.canPartition(nums);
        System.out.println(canPartition);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0, max = 0;
        for (int n : nums) {
            sum += n;
            max = n > max ? n : max;
        }
        if (sum % 2 == 1 || max > sum >>> 1) {
            return false;
        }
        return hasSubset(nums, sum >>> 1);
    }

    private boolean hasSubset(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0]=1;
        for (int n : nums) {
            for (int hitNumb = target; hitNumb >= n; hitNumb--) {
                dp[hitNumb] += dp[hitNumb - n];
            }
            if (dp[target] >= 1) {
                return true;
            }
        }
        return dp[target] >= 1;
    }
}
