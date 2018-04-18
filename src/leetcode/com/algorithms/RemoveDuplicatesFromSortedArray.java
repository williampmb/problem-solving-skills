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
public class RemoveDuplicatesFromSortedArray {
    
    //the idea is filling the array with past position with elements that are not
    // repeated. So if you have 1,2,3. It will fill itself with 1, 2,3 without
    //overwrite
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
