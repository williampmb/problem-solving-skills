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
public class BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV b = new BestTimeToBuyAndSellStockIV();
        int[] prices = {4, 3, 6, 7, 1, 2, 10};
        int max = b.maxProfit(333, prices);
        System.out.println(max);

    }

    public int maxProfit(int k, int[] prices) {
        if (k <1 || prices == null) {
            return 0;
        }
        int days = prices.length;

        if (k >= days >> 1) {
            // Same as BestTimeToBuyAndSellStockII. K as many transactions as we want
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }

        int[][] t = new int[k][2];

        for (int ith = 0; ith < days; ith++) {
            for (int kth = 0; kth < k; kth++) {
                t[kth][1] = Integer.MIN_VALUE;
            }
        }

        for (int ith = 0; ith < days; ith++) {
            for (int kth = k - 1; kth >= 0; kth--) {

                t[kth][0] = Math.max(t[kth][0], t[kth][1] + prices[ith]);
                if (kth <= 0) {
                    t[kth][1] = Math.max(t[kth][1], -prices[ith]);
                } else {
                    t[kth][1] = Math.max(t[kth][1], t[kth - 1][0] - prices[ith]);
                }
            }
        }
        return t[k - 1][0];
    }
}
