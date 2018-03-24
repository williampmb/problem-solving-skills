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
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
        int[] prices = {4, 3, 6, 7, 1, 2, 10};
        int maxProfit = b.maxProfit(prices);
        int maxProfit2 = b.maxProfit2(prices);
        System.out.println(maxProfit);
        System.out.println(maxProfit2);
    }

    //the difference shows if we will have profit between two adjacents days
    // in the case {1,5,7 }, we can buy on the day 1 and sell on the day 2 and 
    // buy again on the day 2 and sell on the day 3. this will be the same profit
    // than buying on the day one and selling in the day 3
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    // maybe more clear than we should get the minimum and maximum of the 
    // subarrays. for instance,  {4, 3, 6, 7, 1, 2, 10}. we would take
    // {3, 6, 7} subarray and {1, 2, 10}.
    public int maxProfit2(int[] prices) {
        int profit = 0, profitDaySell = 0, profitDayBuy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            profitDaySell = Math.max(profitDaySell, profitDayBuy + prices[i]);
            profitDayBuy = Math.max(profitDayBuy, -prices[i]);
            if (i != prices.length - 1 && prices[i] > prices[i + 1]) {
                profit += profitDaySell;
                profitDaySell = 0;
                profitDayBuy = Integer.MIN_VALUE;
            }
            if (i == prices.length - 1) {
                profit += profitDaySell;
            }
        }
        return profit;
    }
}
