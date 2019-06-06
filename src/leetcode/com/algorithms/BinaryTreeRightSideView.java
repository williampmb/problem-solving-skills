package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        if(root!= null){
            q1.add(root);
            while(!q1.isEmpty()){
                TreeNode cur = q1.poll();
                if(cur.left != null) q2.add(cur.left);
                if(cur.right!= null) q2.add(cur.right);
                if(q1.isEmpty()){
                    ans.add(cur.val);
                    q1 = q2;
                    q2 = new LinkedList<>();
                }
            }
        }

        return ans;
    }
}