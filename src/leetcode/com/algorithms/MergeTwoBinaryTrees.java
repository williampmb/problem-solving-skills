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
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val = t1.val + t2.val;
        t1.right = mergeTrees(t1.right,t2.right);
        t1.left = mergeTrees(t1.left, t2.left);
        return t1;
    }
}
