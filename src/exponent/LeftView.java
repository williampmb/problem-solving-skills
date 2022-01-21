package exponent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.com.algorithms.*;

public class LeftView {

    public static void main(String[] args){
        
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(2);
        TreeNode rr = new TreeNode(6);
     
        root.left = left;
        root.right = right;
        right.right = rr;
        
        printOutlineView(root);
    }

    static void printLeftView(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        current.add(root);
        boolean first = true;
        while(!current.isEmpty()){
            TreeNode curNode = current.poll();

            if(curNode.left!= null){
                next.add(curNode.left);
            }
            if(curNode.right!=null){
                next.add(curNode.right);
            }
            if(first){
                System.out.print(curNode.val + " - ");
                first = false;
            }
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                first = true;
            }
        }
    }

    static void printOutlineView(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        current.add(root);
        boolean first = true;
        while(!current.isEmpty()){
            TreeNode curNode = current.poll();

            if(curNode.left!= null){
                next.add(curNode.left);
            }
            if(curNode.right!=null){
                next.add(curNode.right);
            }
            if(first){
                leftNodes.add(curNode.val);
                first = false;
            }
            if(current.isEmpty()){
                if(leftNodes.get(leftNodes.size()-1)!=curNode.val){
                    rightNodes.add(curNode.val);
                }
                current = next;
                next = new LinkedList<>();
                first = true;
            }
        }
        for(int i = rightNodes.size()-1; i>=0 ;i--){
            System.out.print(rightNodes.get(i)+" ");
        }
        for(Integer i : leftNodes){
            System.out.print(i + " ");
        }
    }

}
