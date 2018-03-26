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
public class TwoKeysKeyboard {

    public static void main(String[] args) {
        TwoKeysKeyboard p = new TwoKeysKeyboard();
        int nums = 6;

        int minSteps = p.minSteps(nums);
        System.out.println(minSteps);

    }

    public int minSteps(int n) {
        int steps = 0;
        for (int divisor = 2; divisor <= n; divisor++) {
            while (n % divisor == 0) {
                steps += divisor;
                n /= divisor;
            }
        }
        return steps;
    }

    //@LinfinityLab at leetcode DP
    public int minSteps2(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j);
                    break;
                }

            }
        }
        return dp[n];
    }
}
