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
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = {1, 3, 2};
        n.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + "- ");
        }
        System.out.println("");
    }

    public void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int x = -1;
        for (int i = nums.length - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                x = i;
                break;
            }
        }
        swap(nums, k, x);

        reverse(nums, k + 1, nums.length-1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int pos, int pos2) {
        int tmp = nums[pos];
        nums[pos] = nums[pos2];
        nums[pos2] = tmp;
    }
}
