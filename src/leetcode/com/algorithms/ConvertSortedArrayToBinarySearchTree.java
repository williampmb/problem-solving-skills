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
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args){
        ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
        //int[] a = {-10,-3,0,5,9};
        int[] a = {1};
        TreeNode root = c.sortedArrayToBST(a);
        root.printPreOrder(root);
        
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = null;
        root = sortedArrayToBST(nums, 0, nums.length-1, root);
        return root;
    }

    private TreeNode sortedArrayToBST(int[] nums, int ini, int end, TreeNode root) {
        if(ini>end) return null;
        int mid = (ini+end)/2;
        root = new TreeNode(nums[mid]);
        
        root.left = sortedArrayToBST(nums,ini,mid-1,root.left);
        root.right = sortedArrayToBST(nums,mid+1,end,root.right);
        
        return root;
    }
}
