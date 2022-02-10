package leetcode.com.algorithms;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int indexMax = start;

        for (int i = start + 1; i <= end; i++) {
            if (nums[indexMax] < nums[i]) {
                indexMax = i;
            }
        }
        TreeNode node = new TreeNode(nums[indexMax]);

        node.left = constructMaximumBinaryTree(nums, start, indexMax - 1);
        node.right = constructMaximumBinaryTree(nums, indexMax + 1, end);

        return node;

    }
}
