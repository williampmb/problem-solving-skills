/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.sortingandsearching;

/**
 *
 * @author William Barbosa
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        s.sortColors(nums);

    }

    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int length = nums.length;
        int left = 0, right = length - 1;

        while (left < right && nums[left] == 0) {
            left++;
        }
        while (right > 0 && nums[right] == 2) {
            right--;
        }

        int cur = left;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, left++, cur++);
            } else if (nums[cur] == 2) {
                swap(nums, right--, cur);
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
