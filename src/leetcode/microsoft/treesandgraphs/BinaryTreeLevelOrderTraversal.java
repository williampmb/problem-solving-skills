/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.com.algorithms.TreeNode;

/**
 *
 * @author William Barbosa
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> depth = new ArrayList<>();

        while (!q1.isEmpty()) {
            TreeNode cur = q1.poll();
            depth.add(cur.val);
            if (cur.left != null) {
                q2.add(cur.left);
            }
            if (cur.right != null) {
                q2.add(cur.right);
            }

            if (q1.isEmpty()) {
                q1 = q2;
                ans.add(depth);
                depth = new ArrayList<>();
                q2 = new LinkedList<>();
            }

        }
        return ans;
    }
}
