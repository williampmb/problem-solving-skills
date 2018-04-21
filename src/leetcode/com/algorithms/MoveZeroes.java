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
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null) return;
        int length = nums.length, left = 0;
        
        for(int i = 0 ; i< length; i++){
            if(nums[i] != 0)
                nums[left++] = nums[i];
        }
        while(left != length){
            nums[left++] =0;
        }
        
    } 
}
