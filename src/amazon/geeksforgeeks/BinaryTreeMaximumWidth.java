package amazon.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.com.algorithms.TreeNode;

public class BinaryTreeMaximumWidth {
    public int maximumWdith(TreeNode root){
        int ans = 0;
        if(root == null) return ans;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        ans =1;
        while(!q1.isEmpty()){
            TreeNode cur = q1.poll();

            if(cur.left!= null){
                q2.add(cur.left);
            }

            if(cur.right!=null){
                q2.add(cur.right);
            }

            if(q1.isEmpty()){
                q1 = q2;
                q2 = new LinkedList<>();
                ans = ans<q1.size()?q1.size():ans;
            }
        }
        return ans;
    }
}