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
public class DiameterOfBinaryTree {
    int max =0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateFullTree(3);
        root.printPreOrder(root);
//        root.left.left = null;
//        root.left.right = null;
        System.out.println("");
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        int dia = d.diameterOfBinaryTree(root);
        System.out.println(dia);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int diameter = left + right;
        int diaLef = 0, diaRig = 0, maxChild;
        if (left > right) {
            diaLef = diameterOfBinaryTree(root.left);
        } else if (left < right) {
            diaRig = diameterOfBinaryTree(root.right);
        }
        maxChild = diaLef > diaRig ? diaLef : diaRig;
        diameter = diameter > maxChild ? diameter : maxChild;

        return diameter;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0, heightLeft = 0, heightRight = 0;
        if (root.left != null) {
            heightLeft = height(root.left);
        }
        if (root.right != null) {
            heightRight = height(root.right);
        }
        int max = heightLeft > heightRight ? heightLeft : heightRight;
        height = max + 1;
        return height;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

}
