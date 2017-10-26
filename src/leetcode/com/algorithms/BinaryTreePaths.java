/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author willi
 */
public class BinaryTreePaths {

   
    public static void main(String[] args){
        BinaryTreePaths b = new BinaryTreePaths();
       
        TreeNode root = TreeNode.generateFullTree(2);
        
        root.right =null;
       // root.right.right =null;
       // root.left.right = null;
        TreeNode.printPreOrder(root);
        
        
        
        List<String> r = b.binaryTreePaths2(root);
        System.out.println("");
        for(String s: r){
            System.out.println(s);
        }
        
    }

    //Top-Botton approach. When it finds a leaf, it saves the string into a 
    // global variable.
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> output = new ArrayList<>();
        if (root == null) {
            return output;
        }   
        
        binaryTreePaths(root, root.val +"",output);
        return output;
    }

    private void binaryTreePaths(TreeNode root, String path,List<String> output) {
        if (isLeaf(root)) {
            output.add(path);
            return;
        }

        if (root.left != null) {
            binaryTreePaths(root.left, path  + "->"+ root.left.val,output);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, path  + "->"+ root.right.val,output);
        }
    }
    
    //Another approach by sanket.purbey at Leetcode without using helper function
    //On the other hand, i think it makes too much unnecessary copies and the extra
    // space with the new linkedlist in every recursion
    public List<String> binaryTreePaths2(TreeNode root) {
        
        List<String> paths = new LinkedList<>();

        if(root == null) return paths;
        
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

         for (String path : binaryTreePaths(root.left)) {
             paths.add(root.val + "->" + path);
         }

         for (String path : binaryTreePaths(root.right)) {
             paths.add(root.val + "->" + path);
         }

         return paths;
        
    }

    //Utils
    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
