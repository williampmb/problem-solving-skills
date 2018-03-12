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
public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsetsWithDup = s.subsetsWithDup(nums);
        for (List<Integer> l : subsetsWithDup) {
            for (int i : l) {
                System.out.print("" + i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        ans.add(new ArrayList<>(cur));
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(ans, cur, 0, nums, used);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int start, int[] nums, boolean[] used) {
        if (!cur.isEmpty()) {
            ans.add(new ArrayList<>(cur));
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            used[i] = true;
            backtrack(ans, cur, i + 1, nums, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}
