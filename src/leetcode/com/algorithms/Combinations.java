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
public class Combinations {
    
      public static void main(String[] args) {
        Combinations c = new Combinations();
        
        List<List<Integer>> combination = c.combine(4, 2);

        for (List<Integer> l : combination) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (k > n || n < 1 || k < 1) {
            return ans;
        }
        List<Integer> cur = new ArrayList<>();
        backtrack(ans, cur, n, k, 1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int n, int k, int at) {
        if (k == 0) {
            ans.add(new ArrayList<>(cur));
        } else {
            for (int i = at; i <= n; i++) {
                cur.add(i);
                backtrack(ans, cur, n, k - 1, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
