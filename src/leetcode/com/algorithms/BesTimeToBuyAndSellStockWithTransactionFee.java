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
public class BesTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        BesTimeToBuyAndSellStockWithTransactionFee b = new BesTimeToBuyAndSellStockWithTransactionFee();
        //int[] prices = {4, 3, 6, 7, 1, 2, 10};
        int[] prices = {1, 3, 2, 8, 4, 9};
        int maxProfit = b.maxProfit(prices, 2);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices, int fee) {
        int transationDayiSell = 0, transationDayiBuy = Integer.MIN_VALUE;

        for (int price : prices) {
            int profitUpToNow = transationDayiSell;
            transationDayiSell = Math.max(transationDayiSell, transationDayiBuy + price);
            transationDayiBuy = Math.max(transationDayiBuy, profitUpToNow - price - fee);
        }

        return transationDayiSell;
    }
}
