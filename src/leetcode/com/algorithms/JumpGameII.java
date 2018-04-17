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
public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII j = new JumpGameII();
        int[] nums = {11, 2, 11, 2, 1}; //1
        //int[] nums = {2, 2, 11, 2, 1}; //2
        //int[] nums = {1, 1,1, 3, 1, 1,1,1}; //5
        //int[] nums = {2,3,1,1,4}; //2
        //int[] nums = {1,1,1,1,1}; //4
        //int[] nums = {6,4,1,3,2,3,1,1,1,1}; //3
        int jump = j.jump(nums);
        System.out.println(jump);
    }
    
    // more complex solution. However, i think it stills O(n) because we jump 
    // j steps in i everytime we see about j numbers
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int steps = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            int e = nums[i], curPos = i;
            steps++;
            if (curPos + e >= nums.length - 1) {
                return steps;
            }
            for (int j = 1; j <= e; j++) {
                if (j + curPos + nums[j + curPos] >= nums.length - 1) {
                    steps++;
                    return steps;
                } else if (curPos + j + nums[j + curPos] >= max) {
                    max = curPos + j + nums[j + curPos];
                    i = curPos + j - 1;
                }
            }
            max = 0;
        }
        return steps;
    }
    
    //@adam20 at leetcode 
    public int jump2(int[] A) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            max = Math.max(max, i + A[i]);
            if (i == e) {
                sc++;
                e = max;
            }
        }
        return sc;
    }
}
