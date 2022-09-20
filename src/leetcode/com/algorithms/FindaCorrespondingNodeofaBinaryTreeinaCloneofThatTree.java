package leetcode.com.algorithms;

public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        if(original.val == target.val) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left != null) return left;
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return right;
    }
}
