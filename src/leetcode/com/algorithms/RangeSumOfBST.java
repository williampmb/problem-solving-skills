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
public class RangeSumOfBST {
      public int rangeSumBST(TreeNode root, int L, int R) {
        return dsf(root,L,R);
    }
    
    public int dsf(TreeNode root, int l, int r){
        int sum =0;
        if(root!= null){
            if(root.val >l){
                sum+=dsf(root.left,l,r);
            }
            if(root.val<r){
                sum+=dsf(root.right,l,r);
            }
            if(root.val >=l && root.val <=r){
                sum+=root.val;
            }
        }
        return sum;
    }
}
