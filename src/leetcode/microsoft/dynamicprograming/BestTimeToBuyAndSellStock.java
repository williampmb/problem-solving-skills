/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.dynamicprograming;

/**
 *
 * @author William Barbosa
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null )return 0;
        int l = prices.length;
        if(l < 2)return 0;
        
        int buyP = -prices[0], sell =0;
        for(int i : prices){
            sell = Math.max(buyP+i,sell);
            buyP = Math.max(buyP, -i);
        }
        return sell;
    }
}
