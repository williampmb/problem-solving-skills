package leetcode.com.algorithms;

public class CountNodesEqualtoAverageofSubtree {
    int total = 0;

    public int averageOfSubtree(TreeNode root) {
        averageOfSubtreeReturnSumAvg(root);
        return total;
    }

    public int[] averageOfSubtreeReturnSumAvg(TreeNode cur) {
        if( cur == null) return new int[2];
        
        int[] left = averageOfSubtreeReturnSumAvg(cur.left);
        int[] right = averageOfSubtreeReturnSumAvg(cur.right);

        int sum = left[0] + right[0] + cur.val;
        int nodes = left[1] + right[1] + 1;

        if(sum/nodes == cur.val){
            total ++;
        }
        return new int[]{sum,nodes};
    }


    
}
