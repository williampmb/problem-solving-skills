package leetcode.com.algorithms;

public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flattenReturn(root);
    }
   
    public static TreeNode flattenReturn(TreeNode root) {
        if(root == null) return null;
        
        TreeNode left = flattenReturn(root.left);
        TreeNode right = flattenReturn(root.right);

        if(left == null && right == null){
            return root;
        }else if(left!= null && right == null){
            root.right = root.left;
            root.left = null;
            return left;
        }else if(right != null && left == null){
            return right;
        }else{
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            return right;
        }
      
    }


}
