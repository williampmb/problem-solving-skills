/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.treesandgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetcode.com.algorithms.TreeNode;

/**
 *
 * @author William Barbosa
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> prior = new Stack();
        prior.push(cur);
        while (cur != null || !prior.isEmpty()) {
            while (cur != null && cur.left != null) {
                prior.push(cur.left);
                cur = cur.left;
            }
            cur = prior.pop();
            ans.add(cur.val);
            if (cur.right != null) {
                prior.push(cur.right);
            }
            cur = cur.right;

        }
        return ans;
    }
}
