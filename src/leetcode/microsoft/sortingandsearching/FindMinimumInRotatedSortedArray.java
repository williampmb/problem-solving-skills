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
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left < right&& nums[left]>nums[right]) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {
                left = mid + 1;
                if(nums[left]<nums[left-1])return nums[left];
            } else {
                right = mid-1;
                if(nums[right]>nums[right+1])return nums[right];
            }
          
        }
        return nums[left];
    }
}
