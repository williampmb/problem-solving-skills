package leetcode.com.algorithms;

public class DistributeCoinsinBinaryTree{
    public int distributeCoins(TreeNode root) {
        Integer moves = new Integer(0);
        dfs(root,moves);
        return moves;
    }

    private int dfs(TreeNode root, Integer moves) {
        if(root == null) return 0;
        int left = dfs(root.left,moves);
        int right= dfs(root.right,moves);
        
        moves += Math.abs(left) + Math.abs(right);

        return root.val - 1 + left + right;
    }
}