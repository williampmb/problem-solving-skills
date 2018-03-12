/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class Subsets {
    
    public static void main(String[] args){
        Subsets s = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = s.subsets(nums);
        for (List<Integer> l : subsets) {
            for (int i : l) {
                System.out.print("" + i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        ans.add(new ArrayList<>(cur));
        backtrack(ans, cur, 0, nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int start, int[] nums) {
        if (!cur.isEmpty()) {
            ans.add(new ArrayList<>(cur));
        }
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(ans, cur, i+1, nums);
            cur.remove(cur.size()-1);
        }
    }
}
