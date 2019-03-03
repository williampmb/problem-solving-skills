/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.HashMap;

/**
 *
 * @author William Barbosa
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int s = nums.length;
        int[] dp2 = new int[s];
        int count = 0;

        for (int i = 0; i < s; i++) {
            dp2[i] = nums[i];
            if (dp2[i] == k) {
                count++;
            }
        }
        for (int i = 1; i < s; i++) {
            for (int j = 0; j < s - i; j++) {
                dp2[j] = dp2[j] + nums[i + j];
                if (dp2[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
    
    //https://leetcode.com/problems/subarray-sum-equals-k/solution/
    public int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
