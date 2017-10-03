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
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);

        TreeNode childLeft1 = root.left;
        childLeft1.left = new TreeNode(4);
        childLeft1.right = new TreeNode(5);

        TreeNode childRight2 = childLeft1.right;
        childRight2.left = new TreeNode(8);
        childRight2.right = new TreeNode(9);

        root.right = new TreeNode(3);
        TreeNode childRight1 = root.right;
        childRight1.left = new TreeNode(5);
        childRight1.right = new TreeNode(2);

        TreeNode childLeft2 = childRight1.left;
        childLeft2.left = new TreeNode(9);
        childLeft2.right = new TreeNode(8);

        String left = preOrder(root.left, 0);
        String right = posOrder(root.right, 0);
        if (left.equals(right)) {
            System.out.println(left);
            System.out.println("equal to");
            System.out.println(right);

        } else {
            System.out.println(left);
            System.out.println("different from");
            System.out.println(right);
        }
        System.out.println();
        System.out.println();
        
        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetricRecurrency(root));

    }

    public boolean isSymmetricRecurrency(TreeNode root) {
        if (root != null) {
          return isMirror(root.left, root.right);
        }
        return true;
    }

    /*
    * If we generate preorder of left side and posorder of right side including
    * the depth of the three in each node. We can check if it has the same String
    * If so, it is symmetric
     */
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            String left = preOrder(root.left, 0);
            String right = posOrder(root.right, 0);
            if (left.equals(right)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static String preOrder(TreeNode root, int lvl) {
        String preOrder = "";
        if (root != null) {
            int depth = lvl;
            preOrder += preOrder(root.left, lvl + 1);
            preOrder += root.val + "" + depth;
            preOrder += preOrder(root.right, lvl + 1);
        }
        if (preOrder.equals("")) {
            return "-";
        }
        return preOrder;
    }

    public static String posOrder(TreeNode root, int lvl) {
        String posOrder = "";
        if (root != null) {
            int depth = lvl;
            posOrder += posOrder(root.right, lvl + 1);
            posOrder += root.val + "" + depth;
            posOrder += posOrder(root.left, lvl + 1);
        }
        if (posOrder.equals("")) {
            return "-";
        }
        return posOrder;
    }

    /*
    * For each level we check the node and compare the next level with the
    * correspondent from the other side.
    */
    private boolean isMirror(TreeNode left, TreeNode right) {
       if(left == null && right == null) return true;
       if(left == null || right == null) return false;
       if(left.val != right.val) return false;
       return isMirror(left.right,right.left) && isMirror(left.left, right.right);
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
}
