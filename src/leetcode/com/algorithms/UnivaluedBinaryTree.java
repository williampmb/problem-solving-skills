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
public class UnivaluedBinaryTree {
     public boolean isUnivalTree(TreeNode root) {
        if(root != null){
            int val = root.val;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                TreeNode cur = q.poll();
                if(cur.val != val) return false;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return true;
    }
}
