/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
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
        List<Integer> coins = Arrays.asList( 2, 5);
        printList(coinChangeTabulationReturnMinListOfCoins(coins, 10));
        printList(coinChangeTabulationReturnMinListOfCoins(coins, 11));
        printList(coinChangeTabulationReturnMinListOfCoins(coins, 4));
        printList(coinChangeTabulationReturnMinListOfCoins(coins, 7));
        printList(coinChangeTabulationReturnMinListOfCoins(coins, 0));

    }

    public static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + "-");
        }
        System.out.println();
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
                if (pos < 0 || pos > amount)
                    continue;
                if (combinations[pos] == null || combinations[pos] > numbComb) {
                    combinations[pos] = numbComb;
                }
            }
        }

        return combinations[amount] == null ? -1 : combinations[amount];
    }

    public static List<Integer> coinChangeTabulationReturnMinListOfCoins(List<Integer> coins, int amount) {
        if (amount == 0)
            return new ArrayList<>();
        List<Integer>[] combinations = new ArrayList[amount + 1];
        combinations[0] = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            if (combinations[i] == null)
                continue;
            for (int coin : coins) {
                int newSize = combinations[i].size() + 1;
                int pos = i + coin;
                if (pos > amount)
                    continue;
                if (combinations[pos] == null || combinations[pos].size() > newSize) {
                    combinations[pos] = new ArrayList<>();
                    combinations[pos].addAll(combinations[i]);
                    combinations[pos].add(coin);
                }
            }
        }

        return combinations[amount] == null ? new ArrayList<>() : combinations[amount];
    }

}
