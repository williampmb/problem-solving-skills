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
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        int[] cost = {10,15,20};
        int minCostClimbingStairs = m.minCostClimbingStairs2(cost);
        System.out.println(minCostClimbingStairs);
    }

    //O(n) space.
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n + 1];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            int curCost = i == n ? 0 : cost[i];
            minCost[i] = Math.min(minCost[i - 1] + curCost, minCost[i - 2] + curCost);
        }
        return minCost[n];
    }
    
    //O(1) space. DP greedy algorithm
    
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];
        int costStepi = 0;
        for (int i = 2; i <= n; i++) {
            int curCost = i == n ? 0 : cost[i];
            costStepi = Math.min(prev2 + curCost, prev1 + curCost);
            prev2 = prev1;
            prev1 = costStepi;
        }
        return costStepi;
    }
}
