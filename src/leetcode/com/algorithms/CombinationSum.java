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
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] candidates = {1,2,3,4,5,6,7,8,9,10};
        List<List<Integer>> combinationSum = c.combinationSum(candidates, 7);

        for (List<Integer> l : combinationSum) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);

        backtrack(ans, cur, 0, candidates, target);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int start, int[] candidates, int target) {
        if (!cur.isEmpty() && target == 0) {
            ans.add(new ArrayList<>(cur));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > 0 && target > 0 && target < candidates[i]) {
                    break;
                }
                cur.add(candidates[i]);
                backtrack(ans, cur, i, candidates, target - candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
