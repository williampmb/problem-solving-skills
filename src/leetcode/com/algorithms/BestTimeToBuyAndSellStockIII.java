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
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int profitDayiTransation2Sell = 0, profitDayiTransation2Buy = Integer.MIN_VALUE;
        int profitDayiTransation1Sell = 0, profitDay1Transation1Buy = Integer.MIN_VALUE;

        for (int price : prices) {
            profitDayiTransation2Sell = Math.max(profitDayiTransation2Sell, profitDayiTransation2Buy + price);
            profitDayiTransation2Buy = Math.max(profitDayiTransation2Buy, profitDayiTransation1Sell - price);
            profitDayiTransation1Sell = Math.max(profitDayiTransation1Sell, profitDay1Transation1Buy + price);
            profitDay1Transation1Buy = Math.max(profitDay1Transation1Buy, -price);

        }

        return profitDayiTransation2Sell;
    }

}
