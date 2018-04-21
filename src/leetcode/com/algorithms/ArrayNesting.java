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
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int longestNested = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int j = i;
            while (nums[j] != -1) {
                count++;
                int tmp = nums[j];
                nums[j] = -1;
                j = tmp;
            }
            if (count > longestNested) {
                longestNested = count;
            }

        }
        return longestNested;
    }
    
}
