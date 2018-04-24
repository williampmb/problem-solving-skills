/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        int[] memo = new int[2];
        memo[1] = -1;

        helper(root, 0, memo, true);
        return memo[0];
    }

    private void helper(TreeNode cur, int depth, int[] memo, boolean left) {
        if (cur == null) {
            return;
        }
        helper(cur.left, depth + 1, memo, true);
        if (depth > memo[1] && left) {
            memo[0] = cur.val;
            memo[1] = depth;
        }
        helper(cur.right, depth + 1, memo, false);
    }
}
