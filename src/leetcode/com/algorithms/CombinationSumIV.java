/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author William Barbosa
 */
public class CombinationSumIV {

    public static void main(String[] args) {
        CombinationSumIV c = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        int comb = c.combinationSum4(nums, 4);
        System.out.println(comb);
    }

    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> lookAt = new HashMap<>();
        Arrays.sort(nums);
        return backtrack(nums, target, lookAt);
    }

    //DP 6ms
    private int backtrack(int[] nums, int target, Map<Integer, Integer> lookAt) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                break;
            }
            if (lookAt.get(target - nums[i]) != null) {
                res += lookAt.get(target - nums[i]);
            } else {
                res += backtrack(nums, target - nums[i], lookAt);
            }
        }
        lookAt.put(target, res);
        return res;
    }

    //top-down approach beats DP. 1ms
    public int combinationSum4Topdown(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }
}
