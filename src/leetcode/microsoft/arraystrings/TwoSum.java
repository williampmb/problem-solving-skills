/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

import java.util.HashMap;

/**
 *
 * @author William Barbosa
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {2,7,11,15};
        int[] twoSum = t.twoSum(nums, 9);
        System.out.println(twoSum[0] + " " + twoSum[1]);
    }

    //in this case, we cannot sort the array because the answer is base on
    // the original position.
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
