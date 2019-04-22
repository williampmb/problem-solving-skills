package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import leetcode.com.algorithms.TreeNode;

public class MostFrequentSubtreeSum {

    public static void main(String[] args){
        int[] a = {0,-1};
        TreeNode r = new TreeNode(0);
        TreeNode rl = new TreeNode(-1);
        r.left = rl;
        findFrequentTreeSum(r);
    }

    public static int[] findFrequentTreeSum(TreeNode root){
        int[] ans=null;

        Map<Integer,Integer> sums = new HashMap<>();
       
        dfs(sums,root);

        List<Integer>[] bucket = new ArrayList[sums.size()+2];
        Iterator<Integer> it = sums.keySet().iterator();
        while(it.hasNext()){
            Integer subtreeSum = it.next();
            Integer freq = sums.get(subtreeSum);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(subtreeSum);
        }

        List<Integer> ansL = new ArrayList<>();
        for(int i = bucket.length-1;i>0;i--){
            ansL = bucket[i];
            if(bucket[i] != null) break;
        }

        if(ansL == null) return new int[0];
        ans = new int[ansL.size()];
        for(int i =0 ; i < ans.length;i++){
            ans[i] = ansL.get(i);
        }
        return ans;

    }

    private static int dfs(Map<Integer,Integer> sums, TreeNode cur) {
        if(cur == null)return 0;

        int left = dfs(sums, cur.left);
        int right = dfs(sums, cur.right);

        int curSum = left+right+cur.val;
        sums.put(curSum,sums.getOrDefault(curSum, 0)+1);
        return curSum;
    
    }
}