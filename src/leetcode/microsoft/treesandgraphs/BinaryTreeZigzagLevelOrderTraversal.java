/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.treesandgraphs;

import java.util.ArrayList;
import java.util.List;
import leetcode.com.algorithms.TreeNode;

/**
 *
 * @author William Barbosa
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = TreeNode.generateFullTree(4);
        root.left.left.right = null;
        root.right.left.left = null;
        root.right.right.left = null;
        root.right.right.right = null;

        List<List<Integer>> zigzagLevelOrder = b.zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> cur = new ArrayList<>(), next = new ArrayList<>();
        int pos = 0;
        boolean zig = true;
        cur.add(root);
        while (pos != cur.size()) {
            TreeNode node = cur.get(pos);
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
            pos++;
            if (pos == cur.size()) {
                List<Integer> depth = new ArrayList<>();
                if (zig) {
                    for (int i = 0; i < cur.size(); i++) {
                        depth.add(cur.get(i).val);
                    }
                    zig = false;
                } else {
                    for (int i = cur.size() - 1; i >= 0; i--) {
                        depth.add(cur.get(i).val);
                    }
                    zig = true;
                }
                ans.add(depth);
                cur = next;
                next = new ArrayList<>();
                pos = 0;
            }

        }
        return ans;
    }

    //recursive approach
    public List<List<Integer>> zigzagLevelOrderRecursive(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        zigzagLevelOrderRecursive(root, 0, true, ans);
        return ans;
    }

    private void zigzagLevelOrderRecursive(TreeNode cur, int lvl, boolean zig, List<List<Integer>> ans) {
        if (cur == null) {
            return;
        }
        List<Integer> depth = null;
        if (lvl == ans.size()) {
            depth = new ArrayList<>();
            ans.add(depth);
        } else {
            depth = ans.get(lvl);
        }

        if (zig) {
            depth.add(cur.val);
        } else {
            depth.add(0, cur.val);
        }

        zigzagLevelOrderRecursive(cur.left, lvl + 1, !zig, ans);
        zigzagLevelOrderRecursive(cur.right, lvl + 1, !zig, ans);
    }
}
