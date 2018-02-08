/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author William Barbosa
 */
public class FindLargetValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        int max = Integer.MIN_VALUE;
        q1.add(root);
        
        while(!q1.isEmpty()){
            TreeNode node = q1.poll();
            if(node.val > max) max = node.val;
            if(node.right != null) q2.add(node.right);
            if(node.left != null) q2.add(node.left);
            if(q1.isEmpty()){
                ans.add(max);
                max = Integer.MIN_VALUE;
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
        return ans;
    }
    
    /*
    * @author: ryan777 at leetcode.
    * @schumpeter: One reason DFS is better than BFS is that in BFS you’re always
    * maintaining a queue that could potentially grow up to 2^logN (leaves of a 
    * full and balanced binary tree) whereas in DFS the only cost you pay is the 
    * stack-space logN
    */
     public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}
