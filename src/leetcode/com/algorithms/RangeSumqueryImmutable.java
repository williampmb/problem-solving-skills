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
public class RangeSumqueryImmutable {

    class NumArray {

        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return (i == 0 ? nums[j] : nums[j] - nums[i - 1]);
        }
    }
}
