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
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int[] nums = {0, 1};
        int missingNumber = m.missingNumber(nums);
        System.out.println(missingNumber);
    }

    public int missingNumber(int[] nums) {
        int sum = 0, count = 0, should = 0, max = 0, size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
            should += count;
            count += 1;
        }
        if (should == sum) {
            return max + 1;
        }
        return should - (sum - max);
    }
}
