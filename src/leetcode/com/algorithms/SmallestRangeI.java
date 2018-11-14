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
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0], ans;
        
        for(int i = 1; i < A.length; i++){
            min = min > A[i]? A[i] : min;
            max = max > A[i]? max  : A[i];
        }
        
        ans = max - min - 2*K;
        return ans < 0 ? 0 : ans;
    }
}
