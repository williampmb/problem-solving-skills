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
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args){
        LongestContinuousIncreasingSubsequence l  = new LongestContinuousIncreasingSubsequence();
        int[] nums = {1,3,5,4,2,3,4,5};
        l.findLengthOfLCIS(nums);
    }
    
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int size = nums.length;
        int max =1;
        int count =1;
        for(int i = 1; i < size;i++){
            if(nums[i-1] < nums[i]){
                max = Math.max(max, ++count);
            }else{
                count=1;
            }
        }
        System.out.println(max);
        return max;
    }
}
