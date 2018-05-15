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
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;
        if(nums.length == 1) return 1;
        int point = 1;
        for(int i = 1 ; i < nums.length;i++){
            if(nums[i-1] != nums[i]){
                nums[point++] = nums[i];
            }
        }
        return point;
    }
}
