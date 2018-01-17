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
public class SingleElementInASortedArray {

    public static void main(String[] args) {
        SingleElementInASortedArray s = new SingleElementInASortedArray();
        // int[] nums = {1, 1, 2, 2, 3, 3, 4};
        //int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
//        int[] nums = {3,3,7,7,10,11,11};
        //int[] nums = {1,1,2};
        int[] nums = {1,2,2};
        int singleNonDuplicate = s.singleNonDuplicate(nums);
        System.out.println(singleNonDuplicate);
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1, mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == nums[mid + 1]) {
                int elements = end - mid + 1;
                if (elements % 2 == 0) {
                    end = mid - 1;
                } else {
                    start = mid + 2;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                int elements = end - mid;
                if (elements % 2 == 0) {
                    end = mid - 2;
                } else {
                    start = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }

        if (start == end) {
            return nums[start];
        }

        return -1;
    }

    //it is not O(1). Recursive Approach
    public int singleNonDuplicate2(int[] nums) {
        //if invalid input would be able. We should check if nums.length%2 != 1
        if (nums.length == 1) {
            return nums[0];
        }
        return singleNonDuplicated(nums, 0, nums.length - 1);
    }

    private int singleNonDuplicated(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (end - start == 2) {
            if (nums[mid] == nums[mid + 1]) {
                return nums[mid - 1];
            } else {
                return nums[mid + 1];
            }
        }

        if (nums[mid] == nums[mid + 1]) {
            return singleNonDuplicated(nums, mid + 2, end);
        } else if (nums[mid] == nums[mid - 1]) {
            return singleNonDuplicated(nums, start, mid - 2);
        } else {
            return nums[mid];
        }
    }
}
