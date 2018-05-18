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
public class FindMinimumInRotatedSortedArrayII {

    //@JJH11 at leetcode
    // It doesn't interfere on the complexity. However, it should keep track
    // of the min
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
             min = Math.min(min, nums[mid]);
            if (nums[low] < nums[mid] || nums[mid] > nums[high]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else if (nums[low] > nums[mid] || nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low++;
            }
        }
        return min;
    }
}
