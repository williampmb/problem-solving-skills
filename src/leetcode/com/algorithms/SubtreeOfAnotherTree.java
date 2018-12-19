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
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t != null) {
            return false;
        }
        if (t == null && s != null) {
            return false;
        }

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        inOrder(s, s1);
        inOrder(t, s2);

        if (s1.toString().contains(s2.toString()) || s2.toString().contains(s1.toString())) {
            return true;
        }
        return false;
    }

    private void inOrder(TreeNode s, StringBuilder sb) {

        if (s == null) {
            sb.append("n");
        } else {
            if (s.left == null) {
                sb.append("l");
            } else {
                inOrder(s.left, sb);
            }
            sb.append("" + s.val);
            
            if (s.right == null) {
                sb.append("r");
            } else {
                inOrder(s.right, sb);
            }
        }
    }
}
