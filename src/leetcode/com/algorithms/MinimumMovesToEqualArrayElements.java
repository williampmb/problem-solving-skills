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
public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args){
        int ans = minMoves(new int[]{1,5,10});
    }
    
    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num:nums) {
            if (num < min) {
                min = num;
            }
        }
        int ans = 0;
        for (int num:nums) {
            ans += num - min;
        }
        return ans;
    } 
}
