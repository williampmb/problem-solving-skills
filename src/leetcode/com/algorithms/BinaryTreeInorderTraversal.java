/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author William Barbosa
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null && cur.left != null){
                stack.push(cur.left);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            if(cur.right != null ){
                stack.push(cur.right);
            }
            cur = cur.right;    
        }
        return ans;
    }
}
