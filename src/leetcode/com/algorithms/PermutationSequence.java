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
public class PermutationSequence {

    public static void main(String[] args) {
        PermutationSequence p = new PermutationSequence();
        String permutation = p.getPermutation(3, 6);
        System.out.println(permutation);
    }

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[10];
        StringBuilder ans = new StringBuilder();

        List<Integer> ansInt = new ArrayList<>();

        backtrack(n, k, used, ansInt);
        for (int i : ansInt) {
            ans.append(i);
        }
        return ans.toString();
    }

    private int backtrack(int n, int k, boolean[] used, List<Integer> ans) {
        if (ans.size() == n) {
            return k - 1;
        }
        for (int i = 1; i <= n; i++) {

            if (used[i]) {
                continue;
            }
            used[i] = true;
            ans.add(i);
            k = backtrack(n, k, used, ans);
            if (k < 1) {
                return k;
            }
            ans.remove(ans.size() - 1);
            used[i] = false;
        }
        return k;
    }
}
