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
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int target = nums[0], count =1, curPos = 1, length = nums.length;
        
        for(int i = 1 ; i < length;i++){
            if(target == nums[i] && count<2){
                count++;
                nums[curPos++] = nums[i];
            }else if(target != nums[i]){
                count =1;
                nums[curPos++] = nums[i];
                target = nums[i];
            }
        }
        return curPos;
    }
}
