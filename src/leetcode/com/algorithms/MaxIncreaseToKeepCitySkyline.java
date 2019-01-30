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
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid[0].length;
        int sum =0;
        int[] horizontal = new int[n], vertical = new int[n];
        
        for(int i =0 ; i < n;i++){
            for(int j = 0 ; j< n ; j++){
                horizontal[i] = Math.max(horizontal[i], grid[i][j]);
                vertical[j] = Math.max(vertical[j], grid[i][j]);
            }
        }
        
        for(int i =0 ; i < n;i++){
            for(int j = 0 ; j< n ; j++){
               int min = Math.min(horizontal[i],vertical[j]);
               sum += min - grid[i][j];
            }
        }
        return sum;
    }
}
