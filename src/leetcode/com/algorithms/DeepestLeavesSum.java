package leetcode.com.algorithms;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        int[] ans = new int[2];
        ans[1] = root.val;
        deepestSum(root, 0, ans);
        return ans[1];
    }

    private void deepestSum(TreeNode node, int deep, int[] ans) {
        if (node == null)
            return;

        deepestSum(node.left, ++deep, ans);
        deepestSum(node.right, ++deep, ans);

        if (deep > ans[0]) {
            ans[1] = node.val;
            ans[0] = deep;
        } else if (deep == ans[0]) {
            ans[1] += node.val;
        }
    }
}