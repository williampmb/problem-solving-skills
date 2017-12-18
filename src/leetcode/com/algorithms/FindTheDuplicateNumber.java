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
public class FindTheDuplicateNumber {
    
    public static void main(String[] args){
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        int[] nums = {2,1,3,4,5,6,1};
        
        System.out.println(f.findDuplicate(nums));
    }
    
    
    //Author: echoxiaolee at leetcode
    public int findDuplicate(int[] nums) {
        if(nums.length<2) return -1;
        int slow = nums[0], fast= nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast =0;
        while (slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
