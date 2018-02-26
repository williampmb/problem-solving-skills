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
public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII c = new CombinationSumIII();
        List<List<Integer>> combinationSum = c.combinationSum3(3, 9);

        for (List<Integer> l : combinationSum) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(ans, cur, n, k, 1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int n, int k, int at) {

        if (!cur.isEmpty() && n == 0 && k == 0) {
            ans.add(new ArrayList<>(cur));
        } else if (k > 0 && n > 0) {
            for (int i = at; i < 10; i++) {
                if (n - i < 0) {
                    break;
                }
                cur.add(i);
                backtrack(ans, cur, n - i, k - 1, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
