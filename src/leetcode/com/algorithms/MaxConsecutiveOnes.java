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
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0, size = nums.length;
        int count = 0;
        boolean consecutive = false;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 1 && consecutive) {
                count++;
            } else if (nums[i] == 0) {
                consecutive = false;
                if (count > maxOnes) {
                    maxOnes = count;
                }
            } else {
                count = 1;
                consecutive = true;
                if (count > maxOnes) {
                    maxOnes = count;
                }
            }

            if (i == size - 1 && count > maxOnes) {
                maxOnes = count;
            }
        }
        return maxOnes;
    }

    //It saves the max and count how many times it has consecutives ones
    // so it can compare the max with the current numbers of ones. if it finds
    // a zero, it starts over the counter.
    public int findMaxConsecutiveOnes2(int[] nums) {
        int count = 0, max = 0;
        for (int i : nums) {
            max = Math.max(max, count = i == 0 ? 0 : ++count);
        }
        return max;
    }
}
