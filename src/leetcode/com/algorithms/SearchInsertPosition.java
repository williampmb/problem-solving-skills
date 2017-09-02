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
public class SearchInsertPosition {
    
    public static void main(String[] args){
        int[] a = {1,3};
        int b = searchInsert(a,4);
        System.out.println(b);
    }
    public static int searchInsert(int[] nums, int target) {
        if(nums == null ) return 0;
        int length = nums.length;
        if(length == 1){
            if(nums[0]<target) return 1;
            return 0;
        }
        return searchInsert(nums,0,length-1,target);
    }
    
    public static int searchInsert(int[] nums, int start, int end, int target){
        if(start>end) return start;
        int mid = (start + end) /2;
        if(nums[mid] == target) return mid;
        if(start==end ) {
            if(nums[mid]< target ) return mid+1;
            return mid;
        }else{
            if(target > nums[mid]){
                return searchInsert(nums,mid+1,end,target);
            }else{
                return searchInsert(nums,start,mid-1,target);
            }
        }
       
    }
}
