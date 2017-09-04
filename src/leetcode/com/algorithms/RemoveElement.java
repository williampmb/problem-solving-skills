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
public class RemoveElement {
    
    public static void main(String[] args){
        int[] a = {2,3,3,2};
        System.out.println(removeElement(a,3));
    }
    
    
    public static int removeElement(int[] nums, int target){
        if(nums == null ) return 0;
        if(nums.length == 0) return 0;
        
        int pointerEnd = nums.length-1;
        for(int i = 0 ; i <= pointerEnd; i++){
            if(nums[i] == target){
                pointerEnd = lastNonTarget(nums,target, pointerEnd, i);
                if(pointerEnd == i){
                    pointerEnd--;
                    break;
                }
                nums = switchPosition(nums,i,pointerEnd);
            }
        }
        return pointerEnd+1;
    }

    private static int lastNonTarget(int[] nums, int target,int currentEnd, int currentPos) {
        while( currentPos != currentEnd && currentEnd >= 0  && nums[currentEnd] == target)
            currentEnd--;
        return currentEnd;
    }

    private static int[] switchPosition(int[] nums, int i, int pointerEnd) {
        //swap numbs in place
        nums[i] = nums[i]^nums[pointerEnd];
        nums[pointerEnd] = nums[i]^nums[pointerEnd];
        nums[i] = nums[i]^nums[pointerEnd];
        return nums;
    }
}
