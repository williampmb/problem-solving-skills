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
public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        int maxLeft = root.left == null ? Integer.MAX_VALUE : maxValue(root.left);
        int minRight = root.right == null ? Integer.MAX_VALUE : minValue(root.right);
        
        int min = Math.min(Math.abs(maxLeft - root.val), Math.abs(minRight - root.val));
        
        int minTreeLeft = getMinimumDifference(root.left);
        int minTreeRight= getMinimumDifference(root.right);
        
        return Math.min(Math.min(min, minTreeLeft), minTreeRight);
        
    }

    private int maxValue(TreeNode left) {
        TreeNode node = left;
        while(node.right != null){
            node = node.right;
        }
        return node.val;
    }

    private int minValue(TreeNode right) {
        TreeNode node = right;
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }
    
    //Inorder approach
    //Author: compton_scatter at leetcode
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int getMinimumDifference2(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
}
