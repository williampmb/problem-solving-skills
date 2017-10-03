/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class MaximumSubarray {
    public static void main(String[] args){
        MaximumSubarray m = new MaximumSubarray();
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        m.maxSubArray(a);
    
    }
    //solution O(n) from leetcode. Author: FujiwaranoSai
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
