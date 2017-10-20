/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author willi
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree t = new MinimumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode rl = new TreeNode(2);
        TreeNode rr = new TreeNode(3);

        //root.left = rl;
        //root.right = rr;

        TreeNode rll = new TreeNode(5);
        TreeNode rlr = new TreeNode(4);
       // rl.left = rll;
       //rl.right = rlr;

        TreeNode rlrl = new TreeNode(6);

        rlr.right = rlrl;

        int a = t.minDepth(root);
        System.out.println(a);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLvl = new LinkedList<TreeNode>();
        int depth = 1;
        cur.add(root);
        while (!cur.isEmpty()) {
            TreeNode node = cur.remove();
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                nextLvl.add(node.left);
            }
            if (node.right != null) {
                nextLvl.add(node.right);
            }
            if (cur.isEmpty()) {
                cur = nextLvl;
                nextLvl = new LinkedList<>();
                depth++;
            }
        }
        return -1;
    }
    
    
    //Recursion method. It goes all through the tree. Therefore, if the right side
    // is 1 depth, it calculates all the left side too unnecessarily.
    public int minDepth2(TreeNode root){
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
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
