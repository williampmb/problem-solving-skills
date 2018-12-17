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
import utils.Node;

/**
 *
 * @author William Barbosa
 */
public class NarayTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> curLvl = new LinkedList<>();
        Queue<Node> nextLvl = new LinkedList<>();
        List<Integer> curVal = new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        curLvl.add(root);
        
        while(!curLvl.isEmpty()){
            Node head = curLvl.poll();
            curVal.add(head.val);
            
            for(Node child : head.children){
                nextLvl.add(child);
            }
            
            if(curLvl.isEmpty()){
                curLvl = nextLvl;
                ans.add(curVal);
                curVal = new ArrayList<>();
                nextLvl = new LinkedList<>();
            }
        }
        
        
        return ans;
    }
}
