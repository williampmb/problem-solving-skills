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
public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        int[] nums = {1, 1, 1, 2};
        List<List<Integer>> permute = p.permuteUnique(nums);

        for (List<Integer> l : permute) {
            for (int i : l) {
                System.out.print("" + i + " ");
            }
            System.out.println("");
        }
    }

    /*
    * The difference between Permutation and PermutationII is that we need to 
    * use the array nums instead of just swapping the elements in a list as I did 
    * in Permutations. Otherwise, it will have duplicated because we cannot keep
    * track which elements we have swapped. Therefore, he uses the array used
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
