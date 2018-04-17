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
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        if (nums == null || nums.length < 2) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (maxReach < i) {
                return false;
            }
            maxReach = maxReach < nums[i] + i ? nums[i] + i : maxReach;
        }
        return true;
    }
}
