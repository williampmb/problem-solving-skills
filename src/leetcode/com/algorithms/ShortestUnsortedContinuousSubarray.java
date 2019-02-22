/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;

/**
 *
 * @author William Barbosa
 */
public class ShortestUnsortedContinuousSubarray {
    
    public static void main(String[] args){
        //int[] nums = {1,4,5,7,7,7,7,10,8,7,9,10,15,10,22,10,15,10,10,30,31,32,33};
        //int[] nums = {1,2,3,4};
        //int[] nums = {4,3,2,1};
        //int[] nums = {1,1,1,1};
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        
        int findUnsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(findUnsortedSubarray);
    }
    
    //99% faster than others in java. O(n) complexity.
    public static int findUnsortedSubarray(int[] nums) {
         int start=0,end=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i =0 ; i < nums.length-1;i++){
            if(nums[i]>nums[i+1]){
             start = i;
                break;
            }
        }
        int tmp= end;
        for(int i = nums.length-1; i >0;i--){
            if(nums[i]<nums[i-1]){
               end=i;
                break;
            }
        }
        if(start>end)return 0;
        for(int i = start; i<=end;i++){
            if(nums[i]<min)min=nums[i];
            if(nums[i]>max)max=nums[i];
        }
        for(int i = 0 ; i < start;i++){
            if(nums[i]>min){
                start =i;
                break;
            }
        }
        for(int i = nums.length-1;i>end;i--){
            if(nums[i]<max){
                end = i;
                break;
            }
        }
        
        return end-start<=0?0:end-start+1;
    }
    
    //Shorter but not that bad. O(nlogn) time complexity
    public int findUnsortedSubarray2(int[] nums) {
    	int[] array=Arrays.copyOf(nums, nums.length);
    	Arrays.sort(array);
        int i=0;
        for(;i<nums.length;i++) {
        	if(nums[i]!=array[i])
        		break;
        }
        for(int j=nums.length-1;j>=0;j--) {
        	if(nums[j]!=array[j])
        		return j-i+1;
        }
        return 0;
    }
    
}
