/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.others;

/**
 *
 * @author William Barbosa
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for(int i =1; i < nums.length; i++){
            n ^=nums[i];
        }
        return n;
    }
}
