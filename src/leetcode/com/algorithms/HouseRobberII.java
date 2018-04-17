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
public class HouseRobberII {
    
    public static void main(String[] args){
        HouseRobberII h = new HouseRobberII();
        int[] nums = {1000,1,1,1,10,1,1,1000};
        int rob = h.rob(nums);
        
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        
        if(nums == null|| nums.length==0) return 0;
        if(nums.length == 1) return nums[0];
        
        int max1 = rob(nums, 0, nums.length - 1);
        int max2 = rob(nums, 1, nums.length);

        return Math.max(max1, max2);
    }

    private int rob(int[] nums, int start, int end) {

        int rob = 0, noRob = 0;
        for (int i = start; i < end; i++) {
            int tmp = nums[i] + noRob;
            noRob = Math.max(rob, noRob);
            rob = tmp;
        }
        return Math.max(rob, noRob);
    }
}
