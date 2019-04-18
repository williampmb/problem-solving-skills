package leetcode.com.algorithms;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length-1);
    }

    public TreeNode bstFromPreorder(int[] arr, int start, int end) {
        TreeNode cur = null;
        if(start<=end){
            cur = new TreeNode(arr[start++]);
            int point = treeMidPoint(arr,start,end,cur.val);
            if(point == -1){
                cur.left = bstFromPreorder(arr,start,end);
            }else if(point == start){
                cur.right = bstFromPreorder(arr,point,end);
            }else{
                cur.left = bstFromPreorder(arr,start,point-1);
                cur.right= bstFromPreorder(arr,point,end);
            }
        }
        return cur;
    }

    public int treeMidPoint(int[] arr, int start, int end, int target){
        int pos =-1;
        while(start<end){
            int mid = (start+end)/2;
            if(arr[mid]>target){
                pos=mid;
                end=mid;
            }else{
                start=mid+1;
               
            }
        }
        if(start==end && arr[start]>target){
            pos = start;
        }
        return pos;
    }
}