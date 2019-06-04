package leetcode.com.algorithms;

import java.util.LinkedList;
import java.util.Queue;

class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.add(root);
        boolean foundx = false, foundy = false;
        
        while(!q1.isEmpty()){
            TreeNode cur = q1.poll();
            if(isBrother(cur,x,y)) return false;
            if(cur.val == x){
                foundx = true;
            }else if(cur.val == y){
                foundy = true;  
            } 
            if(cur.left != null) q2.add(cur.left);
            if(cur.right != null) q2.add(cur.right);
            
            if(q1.isEmpty()){
                if(foundx && foundy) return true;
                if((foundx&& !foundy) || (!foundx && foundy)) return false;
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
        
        
        return false;
    }
    
    public boolean isBrother(TreeNode cur, int x , int y){
        if(cur.left != null && cur.right!=null){
            int left = cur.left.val, right = cur.right.val;
            return (left == x && right == y) || (left == y && right == x);
        }
        return false;
    }
}