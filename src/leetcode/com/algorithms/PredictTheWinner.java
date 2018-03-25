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
public class PredictTheWinner {

    public static void main(String[] args) {
        PredictTheWinner p = new PredictTheWinner();
        int[] nums = {4, 3, 6, 7, 1, 2, 10};
        boolean PredictTheWinner = p.PredictTheWinner(nums);
        System.out.println(PredictTheWinner);

    }

    //point 1: we need to think if it can overflow
    //point 2: we can do better space complexity. O(N^2) -> O(N)
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i];
        }

        int z = 1;
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int j = z; j < n; j++) {
                int left = nums[row] + dp[row + 1][j][1];
                int right = nums[j] + dp[row][j - 1][1];

                dp[row][j][0] = left > right ? left : right;
                dp[row][j][1] = left > right ? dp[row + 1][j][0] : dp[row][j - 1][0];
                row++;
            }
            z++;
        }
        System.out.println("p1:" + dp[0][n - 1][0]);
        System.out.println("p2:" + dp[0][n - 1][1]);
        return dp[0][n - 1][0] >= dp[0][n - 1][1];
    }

    //@odingg at leetcode
    public boolean PredictTheWinner2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        System.out.println("p1:" + dp[0][n - 1]);
        return dp[0][n - 1] >= 0;
    }

    
    //@anantpathak2614 at leetcode
    private static boolean findWinner(int[] a, int i, int j, int p1, int p2, boolean flag) {
        if (i == j) {
            if (flag) {
                return p1 + a[i] >= p2;
            }
            return p1 >= p2 + a[i];
        }
        if (flag) {
            return findWinner(a, i + 1, j, p1 + a[i], p2, false) || findWinner(a, i, j - 1, p1 + a[j], p2, false);
        }
        return findWinner(a, i + 1, j, p1, p2 + a[i], true) && findWinner(a, i, j - 1, p1, p2 + a[j], true);

    }
}
