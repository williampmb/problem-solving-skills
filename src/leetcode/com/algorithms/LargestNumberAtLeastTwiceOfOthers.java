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
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        int pos = 0, max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pos != -1) {
                if (nums[i] > max / 2) {
                    if (nums[i] / 2 < max) {
                        pos = -1;
                        max = nums[i];
                    } else {
                        max = nums[i];
                        pos = i;
                    }
                }
            } else {
                if (nums[i] >= max * 2) {
                    max = nums[i];
                    pos = i;
                }
            }
        }
        return pos;
    }

    //O(n) time O(1) space. Simplie. Keep track of max1 max 2 and compare them
    public int dominantIndex2(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int max1 = -1, max2 = -1, index = -1, length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return 0;
        }

        for (int i = 0; i < length; i++) {
            if (max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
                index = i;
            } else if (max2 < nums[i]) {
                max2 = nums[i];
            }
        }

        return max1 >= max2 * 2 ? index : -1;

    }

}
