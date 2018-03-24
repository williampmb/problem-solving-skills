/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        int[] a = {5, 7, 2, 4, -5, 2, 7, 6, 2};
        int max = b.maxProfit2(a);
        System.out.println(max);

    }

    public int maxProfit(int[] prices) {
        int max = -1, min = Integer.MAX_VALUE;
        int profit = -1;
        for (int i : prices) {
            if (min > i) {
                min = i;
                max = -1;
            } else if (max < i && i > min) {
                max = i;
                if (profit < max - min) {
                    profit = max - min;
                }
            }
        }
        if (profit == -1) {
            return 0;
        }
        return profit;
    }

    //Kadane's Algorithm: largest sum contigous subarray
    //https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    //a simpler way of doing it
    public int maxProfit3(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;

        for (int price : prices) {
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }

        return T_i10;
    }
}
