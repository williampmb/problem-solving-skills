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
public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> combinationSum = c.combinationSum2(candidates, 8);

        for (List<Integer> l : combinationSum) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack(ans, cur, 0, target, candidates, used);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int start, int target, int[] candidates, boolean[] used) {
        if (!cur.isEmpty() && target == 0) {
            ans.add(new ArrayList<>(cur));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    break;
                }
                if (i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1]) {
                    continue;
                }
                cur.add(candidates[i]);
                used[i] = true;
                backtrack(ans, cur, i + 1, target - candidates[i], candidates, used);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }

        }
    }

}
