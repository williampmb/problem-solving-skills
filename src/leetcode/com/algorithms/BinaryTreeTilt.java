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
public class BinaryTreeTilt {
    int sum =0;
    public int findTilt(TreeNode root) {
        tilt(root);
        return sum;
    }

    private int tilt(TreeNode root) {
        if(root == null) return 0;
        int left = tilt(root.left);
        int right = tilt(root.right);
        
        sum += Math.abs(left - right);
        
        return left + right + root.val;
    }
}
