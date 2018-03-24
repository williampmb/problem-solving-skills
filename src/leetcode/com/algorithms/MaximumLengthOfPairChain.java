/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;

/**
 *
 * @author William Barbosa
 */
public class MaximumLengthOfPairChain {
    
    public static void main(String[] args){
        MaximumLengthOfPairChain m = new MaximumLengthOfPairChain();
        int[][] pairs= {{1,2},{3,7},{4,5},{4,10},{6,7}};
        m.findLongestChain(pairs);
        
    }
    
    
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length ==0 ) return 0;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int res=1, end = pairs[0][1];
        for(int i =1; i<pairs.length; i++) {
            if(pairs[i][0]>end){
                res++;
                end = pairs[i][1];
            }
        }
        return res;
    }
    
    //Dp solution. However, we use O(n) space. Since we need to care just how
    // long the chain is which means we care just about one variable, we can
    // look just dp[j] as an int that we should increment or not using O(1) space.
    public int findLongestChain2(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1]? dp[j] + 1 : dp[j]);
            }
        }
        return dp[pairs.length - 1];
    }
}
