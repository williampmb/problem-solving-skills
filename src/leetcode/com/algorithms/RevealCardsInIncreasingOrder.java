/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author William Barbosa
 */
public class RevealCardsInIncreasingOrder {
     public int[] deckRevealedIncreasing(int[] deck) {
        int size = deck.length;
        int[] ans = new int[size];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < size; i++){
            q.add(i);
        }
        
        Arrays.sort(deck);
        for(int card : deck){
            ans[q.poll()] = card;
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
        return ans;
    }
}
