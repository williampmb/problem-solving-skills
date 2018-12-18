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
public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        convertBST(root,0);
        return root;
    }

    private int convertBST(TreeNode cur, int sum) {
        if(cur == null) return sum;
        
        int right = convertBST(cur.right, sum);
        cur.val +=right;
            
        int left = cur.val;
        if(cur.left!= null){
            left = convertBST(cur.left, cur.val);
        }
        return left;
    }
    
    
    /**
     * by J. H. Morris in his 1979 paper "Traversing Binary Trees Simply and Cheaply".
     * Time O(N) Space O(1) complexity
     */
    
     private TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            /* 
             * If there is no right subtree, then we can visit this node and
             * continue traversing left.
             */
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
            /* 
             * If there is a right subtree, then there is at least one node that
             * has a greater value than the current one. therefore, we must
             * traverse that subtree first.
             */
            else {
                TreeNode succ = getSuccessor(node);
                /* 
                 * If the left subtree is null, then we have never been here before.
                 */
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                }
                /* 
                 * If there is a left subtree, it is a link that we created on a
                 * previous pass, so we should unlink it and visit this node.
                 */
                else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }
        
        return root;
    }
}
