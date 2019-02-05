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
public class SquaresOfaSortedArray {
     public int[] sortedSquares(int[] A) {
        int n = A.length, start = 0, end = A.length-1, pos = A.length-1;
        int[] ans = new int[n];
        
        while(start<=end){
            if(A[end] >= A[start]*-1){
                ans[pos--] = A[end]*A[end];
                end--;
            }else{
                ans[pos--] = A[start]*A[start];
                start++;
            }
        }
        return ans;
    }
}
