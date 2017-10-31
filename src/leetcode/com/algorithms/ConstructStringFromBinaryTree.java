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
public class ConstructStringFromBinaryTree {
    public static void main(String[] args){
        ConstructStringFromBinaryTree c = new ConstructStringFromBinaryTree();
        TreeNode t = TreeNode.generateFullTree(3);
        t.left.left = null;
        t.right.right = null;
        t.right.left = null;
        
        String inOrder = c.inOrder(t);
        System.out.println(inOrder);
        
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        return  inOrder(t);
    }

    private String inOrder(TreeNode t) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);

        if (t.right != null && t.left == null) {
            sb.append("()");
        } else if (t.left != null) {
            sb.append("(");
            sb.append(inOrder(t.left));
            sb.append(")");
        }

        if(t.right != null){
            sb.append("(");
            sb.append(inOrder(t.right));
            sb.append(")");
        }
        return sb.toString();
    }
}
