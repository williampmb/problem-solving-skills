/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class TrimABinarySearchTree {
    public static void main(String[] args){
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(0);
        t.right = new TreeNode(4);
        t.left.right = new TreeNode(2);
        t.left.right.left = new TreeNode(1);
        
        TrimABinarySearchTree x = new TrimABinarySearchTree();
        TreeNode trimBST = x.trimBST(t, 1, 3);
        TreeNode.printPreOrder(t);
        System.out.println("");
        TreeNode.printPreOrder(trimBST);
        System.out.println("");
        TreeNode.printPreOrder(trimBST);
        
    }
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val >= L && root.val <= R){
            root.right = trimBST(root.right, L, R);
            root.left = trimBST(root.left, L, R);
        }else if (root.val <L){
            return trimBST(root.right, L, R);
        }else if(root.val>R){
            return trimBST(root.left, L, R);
        }
        return root;
    }
}
