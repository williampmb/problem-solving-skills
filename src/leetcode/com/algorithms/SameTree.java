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
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && q != null) ||
           (q == null && p != null)) return false;
        if(p.val != q.val) return false;
        boolean res = isSameTree(p.left, q.left);
        if(res) res = isSameTree(p.right, q.right);
        return res;
    }
      
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
