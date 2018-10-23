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
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start =0, end = nums.length-1, mid = 0;
        while(start < end){
            mid = (start+end)/2;
            if(nums[mid]<nums[end]) end = mid;
            else start = mid+1;
        }
        return nums[start];
    }
}
