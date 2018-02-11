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
public class Sum3Closest {

    public static void main(String[] args) {
        Sum3Closest s = new Sum3Closest();
        int[] nums = {1,1,-1,-1,3};
        int threeSumClosest = s.threeSumClosest(nums, -1);
        System.out.println(threeSumClosest);
    }

    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length, sum = target, left, right, closest = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            left = i + 1;
            right = length - 1;
            while (left < right) {
                if (Math.abs(target - nums[i] - nums[left] - nums[right]) < Math.abs(target-closest)) {
                    closest =  nums[i] + nums[left] + nums[right] ;
                } else if (nums[i] + nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else {
                    return closest;
                }
            }

        }
        return closest;
    }
}
