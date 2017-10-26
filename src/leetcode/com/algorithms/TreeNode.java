/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    static TreeNode generateFullTree(int depth) {
        if (depth < 1) {
            return null;
        }
        TreeNode root = new TreeNode(randomInt0To10());
        if (depth == 1) {
            return root;
        }

        generateChild(root, depth - 1);

        return root;
    }

    private static int randomInt0To10() {
        return (int) (Math.random() * 100);
    }

    private static void generateChild(TreeNode root, int i) {
        if (i == 0) {
            return;
        }
        root.left = new TreeNode(randomInt0To10());
        root.right = new TreeNode(randomInt0To10());
        generateChild(root.left, i - 1);
        generateChild(root.right, i - 1);
    }
    
    static void printPreOrder(TreeNode root){
        if(root != null){
            printPreOrder(root.left);
            System.out.print(root.val+"-");
            printPreOrder(root.right);
        }
    }

}