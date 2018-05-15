/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.treesandgraphs;

import leetcode.com.algorithms.TreeNode;

/**
 *
 * @author William Barbosa
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);

    }
}
