/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class DeleteAndEarn {

    public static void main(String[] args) {
        DeleteAndEarn d = new DeleteAndEarn();
        int[] nums = {10, 10, 5, 9, 7, 10, 6, 3};
        //int[] nums = {10};
        int deleteAndEarn = d.deleteAndEarn(nums);
        System.out.println(deleteAndEarn);
    }

    //Reduced to House Robbery problem.
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> houses = new ArrayList<>();
        Arrays.sort(nums);
        int cur = nums[0], houseValue = 0;
        for (int n : nums) {
            if (n == cur) {
                houseValue += n;
            } else {
                houses.add(houseValue);
                if (n > cur + 1) {
                    houses.add(0);
                }
                houseValue = n;
            }
            cur = n;
        }

        houses.add(houseValue);
        int pointer = houses.size();

        int preRob = 0, curRob = 0, curNoRob = 0, preNoRob = 0;
        for (int i = 0; i < pointer; i++) {
            curRob = preNoRob + houses.get(i);
            curNoRob = Math.max(preNoRob, preRob);
            preRob = curRob;
            preNoRob = curNoRob;
        }
        return Math.max(curNoRob, curRob);
    }

    public int deleteAndEarn2(int[] nums) {
        int[] count = new int[10001];
        for (int n : nums) {
            count[n] += n;
        }
        int[] dp = new int[10003];
        for (int i = 10000; i >= 0; i--) {
            dp[i] = Math.max(count[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
}
