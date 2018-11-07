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
public class NaryTreePostorderTraversal {
    
    //TODO: Implement DFS
    // BOTTOM->TOP LEFT->RIGHT

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Integer> reverse = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                reverse.add(node.val);
                for (Node c : node.children) {
                    stack.push(c);
                }
            }

            while (!reverse.isEmpty()) {
                ans.add(reverse.pop());
            }
        }

        return ans;
    }
}
