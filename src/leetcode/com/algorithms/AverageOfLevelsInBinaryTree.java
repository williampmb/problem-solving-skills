/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author willi
 */
public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args){
        AverageOfLevelsInBinaryTree a = new AverageOfLevelsInBinaryTree();
        TreeNode root = TreeNode.generateFullTree(3);
        TreeNode.printPreOrder(root);
        
        List<Double> ave = a.averageOfLevels(root);
        for(double d : ave ){
            System.out.print(d+ " ");
        }
    }
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> values = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        
        if(root == null) return values;
        queue.add(root);
        double count = 0.0;
        double sum = 0.0;
        
        do{
            TreeNode poll = queue.poll();
            
            count++;
            sum += poll.val;
            if(poll.left != null) tmp.add(poll.left);
            if(poll.right != null) tmp.add(poll.right);
            
            if(queue.isEmpty()){
                values.add(sum/count);
                count = 0.0;
                sum =0.0;
                queue = tmp;
                tmp = new LinkedList<>();
            }
            
        } while(!queue.isEmpty());
        
        return values;
    }
}
