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
public class FindPivotIndex {

    public static void main(String[] args) {
        FindPivotIndex f = new FindPivotIndex();
        //int[] nums = {1,7,3,6,5,6};
        int[] nums = {-1,-1,0,1,1,0};
        int pivotIndex = f.pivotIndex(nums);
        System.out.println(pivotIndex);
    }

    public int pivotIndex(int[] nums) {
        int right = 0;
        int left = 0;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            right += nums[i];
        }
        
        for (int i = 0; i < size ; i++) {
            if (i != 0) {
                left += nums[i - 1];
            }
            right -= nums[i];
            if (right == left) {
                return i;
            }
        }
        return -1;
    }
}
