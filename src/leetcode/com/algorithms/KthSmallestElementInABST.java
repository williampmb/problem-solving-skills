package leetcode.com.algorithms;

public class KthSmallestElementInABST {

    static int kthSmallest;
    static int smallestLeft;

    public int kthSmallest(TreeNode root, int k) {
        smalestLeft = k;
        kthSmallest(root);
        return kthSmallest;
    }

    public void kthSmallest(TreeNode node){
        if(node.left != null)
            kthSmallest(node.left);
        
        smallestLeft--;
        if(smallestLeft == 0){
            kthSmallest = node.value;
            return;
        }
        if(smallestLeft >0 && node.right != null)
            kthSmallest(node.right);
    }
}