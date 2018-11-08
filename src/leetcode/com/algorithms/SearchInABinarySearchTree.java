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
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null && cur.val != val) {
            if (cur.val > val) {
                cur = cur.left;
            } else {// cur.val < val;
                cur = cur.right;
            }
        }
        return cur;
    }
}
