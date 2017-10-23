/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        a.left = new TreeNode(2);
        a.right = new TreeNode(7);

        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(3);

        a.left.left.left = new TreeNode(6);
        a.left.right.left = new TreeNode(9);

        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(9);

        a.right.left.left = new TreeNode(6);
        a.right.right.right = new TreeNode(9);

        System.out.println(isBalanced(a));
    }

    /*
    * Top-down approach. The problem here is that we need to call depth of its
    * childs for every node making the complexity grow to O(n^2). A way of solving
    * this is putting a depth variable on the tree class, calculate it first once
    * for each node and then checking if it is balanced.
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }

    /*
    * Another way of solving this problem is based on botton-top approach. It takes
    * much less time, O(n). Basically, we don't need to recalculate every depth for
    * every childs node. We start from the leafs and backtrack summing the depth by 1.
    * When then dif between left and right is bigger than one we return a negative
    * value and treat it as a unbalanced tree.
     */
    public static boolean isBalanced2(TreeNode root) {
        return depthBottonTop(root) != -1;
    }

    private static int depthBottonTop(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = depthBottonTop(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depthBottonTop(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
