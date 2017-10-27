/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author willi
 */
public class TwoSumIVInputIsABST {

    //O(n) time and space complexity. It is not taking advantage from the BST
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> db = new HashSet<Integer>();
        return findTarget(root, k, db);
    }

    private boolean findTarget(TreeNode root, int k, Set<Integer> db) {
        if (root == null) {
            return false;
        }

        if (db.contains(k - root.val)) {
            return true;
        }

        db.add(root.val);

        return findTarget(root.left, k, db) || findTarget(root.right, k, db);
    }
    
    /*
    * Another way is to reduce the problem to a Two Sum Array putting the tree
    * into an array with a preorder manipulation of the BST,
    * then we can use two pointers to solve it.
    * This uses the advantage of BST, however it stills using O(n) space.
    */
    
    //Using the BST
    /*Author: Vincent Cai 
    * The idea is to use binary search method. For each node, 
    * we check if k - node.val exists in this BST.
    * Time Complexity: O(nlogn), Space Complexity: O(h).
    * h is the height of the tree, which is logn at best case, and n at worst case.
    */
    public boolean findTarget2(TreeNode root, int k) {
        return dfs(root, root,  k);
    }
    
    public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }
    
    public boolean search(TreeNode root, TreeNode cur, int value){
        if(root == null)return false;
        return (root.val == value) && (root != cur) 
            || (root.val < value) && search(root.right, cur, value) 
                || (root.val > value) && search(root.left, cur, value);
    }
}
