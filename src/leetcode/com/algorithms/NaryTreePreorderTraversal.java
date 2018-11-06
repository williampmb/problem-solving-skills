/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import utils.Node;

/**
 *
 * @author William Barbosa
 */
public class NaryTreePreorderTraversal {
    
    /**
     * Basically, BSF and it has same complexity than doing it recursively 
     */

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> order = new Stack<>();
        if(root == null) return ans;
        order.push(root);
        while(!order.isEmpty()){
            Node n = order.pop();
            ans.add(n.val);
            if(n.children == null)continue;
            for(int i = n.children.size()-1;i>=0;i--){
                Node cc = n.children.get(i);
                order.push(cc);
            }
        }
        return ans;
    }
}
