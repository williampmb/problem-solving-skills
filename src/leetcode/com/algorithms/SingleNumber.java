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
public class SingleNumber {
    
    public static void main(String[] args){
        int[] a = {4,9,6,8,4,8,6};
        
        System.out.println(singleNumber(a));
    }
    public static int singleNumber(int[] nums) {
        int ele = nums[0];
        for(int i=1;i<nums.length;i++){
           ele ^=nums[i];
        }
        return ele;
    }
}
