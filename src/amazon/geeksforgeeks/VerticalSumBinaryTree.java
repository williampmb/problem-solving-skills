package amazon.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.com.algorithms.TreeNode;

// source: https://www.youtube.com/watch?v=il_t1WVLNxk&t=99s
public class VerticalSumBinaryTree {
    public List<Integer> verticalSumBinaryTree(TreeNode node){
        Map<Integer,Integer> memo = new HashMap<>();
        helper(memo,0,node);
        List<Integer> ans = new ArrayList<>(memo.values());
        return ans;

    }

    private void helper(Map<Integer, Integer> memo, int verticalSum, TreeNode cur) {
        if(cur==null) return;
        memo.put(verticalSum, memo.getOrDefault(verticalSum,0) + cur.val);
        helper(memo,verticalSum-1,cur.left);
        helper(memo,verticalSum+1,cur.right);
    }
}