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
public class HouseRobber {

    //O(n) space and O(n) time complexity with DP
    public int rob(int[] nums) {
        int[][] state = new int[nums.length][2];
        state[0][0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            state[i][0] = state[i - 1][1] + nums[i];
            state[i][1] = Math.max(state[i - 1][0], state[i - 1][1]);

        }
        return Math.max(state[nums.length - 1][0], state[nums.length - 1][1]);

    }

    //O(1) space and O(n) time complexity with DP
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int robCurHouse = 0, noRobCurHouse = 0, noRobPrevHouse = 0, robPrevHouse = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //To rob the cur (nums[i)) house we cannot rob the last one
            robCurHouse = noRobPrevHouse + nums[i];
            //If we don't rob the current house, we can check what it is the max
            // from the last state which means robbing the previous house or not
            noRobCurHouse = Math.max(robPrevHouse, noRobPrevHouse);

            //To go to the next state, the current houses are the previous now.
            robPrevHouse = robCurHouse;
            noRobPrevHouse = noRobCurHouse;

        }
        return Math.max(robPrevHouse, noRobPrevHouse);
    }
}
