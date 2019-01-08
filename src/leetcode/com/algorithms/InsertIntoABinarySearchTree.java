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
public class InsertIntoABinarySearchTree {
     public TreeNode insertIntoBST(TreeNode root, int val) {
        dsf(root,val);
        return root;
    }
    
    public void dsf(TreeNode cur, int val){
        if(cur == null) return;
        if(cur.val>val){
            if(cur.left == null) cur.left = new TreeNode(val);
            else dsf(cur.left,val);
        }else{
            if(cur.right == null) cur.right = new TreeNode(val);
            else dsf(cur.right,val);
        }
    }
}
