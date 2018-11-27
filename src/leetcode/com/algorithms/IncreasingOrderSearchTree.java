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
 * @author William Barbosa
 */
public class IncreasingOrderSearchTree {
    
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root,null);
    }
    
    private TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if(root == null) return tail;
        TreeNode left = increasingBST(root.left,root);
        root.left = null;
        root.right = increasingBST(root.right,tail);
        return left;
    }
    
    
    //Bad complexity
    public TreeNode increasingBST2(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        inorder(root,q);
        TreeNode head = q.poll();
        TreeNode cur = head;
        while(!q.isEmpty()){
            cur.left = null;
            cur.right = q.poll();
            cur = cur.right;
        }
        cur.right = null;
        return head;
    }

    private void inorder(TreeNode root, Queue<TreeNode> q) {
        if(root!= null){
            inorder(root.left, q);
            q.add(root);
            inorder(root.right, q);
        }
    }
}
