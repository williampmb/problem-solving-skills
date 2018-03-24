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
public class BestTimeToBuyAndSellStockWithCooldown {
    
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
    //based on discussion above
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown b = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = {4, 3, 6, 7, 1, 2, 10};
        int max = b.maxProfit(prices);
        System.out.println(max);

    }

    public int maxProfit(int[] prices) {
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old;
        }

        return T_ik0;
    }

    public int maxProfit2(int[] prices) {
        if(prices == null) return 0;
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
