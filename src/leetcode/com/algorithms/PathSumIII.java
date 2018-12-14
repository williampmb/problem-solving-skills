/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class PathSumIII {
   
    
    public static void main(String[] args){
        PathSumIII ps = new PathSumIII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        
        TreeNode four = root.left;
        TreeNode eight = root.right;
        
        four.left = new TreeNode(11);
        
        TreeNode eleven = four.left;
        
        eleven.left = new TreeNode(7);
        eleven.right = new TreeNode(2);
        
        eight.left = new TreeNode(13);
        eight.right = new TreeNode(4);
        
        TreeNode thirteen = eight.left;
        
        thirteen.left = new TreeNode(5);
        thirteen.right = new TreeNode(1);
        
        int count = ps.pathSum(root, 22);
        System.out.println(count);
              
        
    }
    
    public int pathSum(TreeNode root, int sum) {
        int[] ans = new int[1];
        helper(root, sum,ans);
        return ans[0];
    }
    
    public List<Integer> helper(TreeNode root, int sum,int[] count){
        List<Integer> ans = new ArrayList<>();
        if(root!=null){
            List<Integer> left = helper(root.left,sum,count);
            List<Integer> right = helper(root.right,sum,count);
            for(int i: left){
                int curVal = i+root.val;
                if(curVal==sum) count[0]=count[0]+1;
                ans.add(curVal);
            }
            for(int i: right){
                int curVal = i+root.val;
                if(curVal==sum) count[0]=count[0]+1;
                ans.add(curVal);
            }
            
            if(root.val==sum)count[0]=count[0]+1;
            ans.add(root.val);
        }
        return ans;
    }
    
    // O(n)
    // the idea is similar as Two sum, using HashMap to store ( key : the prefix sum, value : how many ways get to this prefix sum) 
    // https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

}
