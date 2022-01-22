/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author willi
 */
public class CoinChange {
    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1,2147483647);
        System.out.println(coinChangeTabulation(coins,2));
        // System.out.println(coinChangeTabulation(coins,0));
        // System.out.println(coinChangeTabulation(coins,3));

    }

    public static int coinChangeTabulation(List<Integer> coins, int amount) {
        if (amount == 0)
            return 0;
        Integer[] combinations = new Integer[amount + 1];
        combinations[0] = 0;

        for (int i = 0; i < amount; i++) {
            if (combinations[i] == null)
                continue;

            for (int coin : coins) {
                int numbComb = combinations[i] + 1;
                int pos = i + coin;
                if (pos<0 || pos > amount)
                    continue;
                if (combinations[pos] == null || combinations[pos] > numbComb) {
                    combinations[pos] = numbComb;
                }
            }
        }

        return combinations[amount] == null ? -1 : combinations[amount];
    }

}
