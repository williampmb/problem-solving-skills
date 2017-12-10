/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;

/**
 *
 * @author willi
 */
public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int size=nums.length;
        int positives3 = nums[size-1]*nums[size-2]*nums[size-3];
        int positive1Negative2 = nums[size-1]*nums[1]*nums[0];
        
        return Math.max(positives3, positive1Negative2);
    }
}
