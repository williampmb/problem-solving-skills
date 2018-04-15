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
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int[] nums = {2,2};
        int lengthOfLIS = l.lengthOfLIS3(nums);
        System.out.println(lengthOfLIS);

    }

    //O(nlogn)
    public int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        //tracker is used if we need to know the array that compose the LIS 
        int[] tracker = new int[length];
        for (int i = 0; i < length; i++) {
            tracker[i] = -1;
        }
        int[] lis = new int[length];
        int maxLength = 1;

        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[lis[maxLength - 1]]) {
                tracker[i] = lis[maxLength - 1];
                lis[maxLength++] = i;
            } else if (nums[i] < nums[lis[0]]) {
                lis[0] = i;
            } else {
                int pos = bsClosestNum(lis, 0, maxLength - 1, nums, i);
                if (pos != 0 || nums[i] != nums[lis[0]]) {
                    tracker[i] = lis[pos];
                    lis[pos + 1] = i;
                }
            }
        }
        return maxLength;
    }

    private int bsClosestNum(int[] lis, int start, int end, int[] nums, int i) {
        int target = nums[i];
        while (start < end) {
            int mid = (int) (Math.ceil((float) (start + end) / 2));

            if (target > nums[lis[mid]]) {
                start = mid;
            } else if (target < nums[lis[mid]]) {
                end = mid - 1;
            } else {
                break;
            }
        }

        return start;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;

        int[] lis = new int[length];

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    lis[j] = Math.max(lis[j], lis[i] + 1);
                }
            }
        }

        int max = 0;
        for (int m : lis) {
            if (m > max) {
                max = m;
            }
        }

        // +1 means that we start the lis with 0 but it is actually 1 to start
        // by the end we just add the one that we skipped
        return max + 1;
    }

    //@dietpepsi at leetcode. Nlog N solution
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) {
                ++size;
            }
        }
        return size;
    }

}
