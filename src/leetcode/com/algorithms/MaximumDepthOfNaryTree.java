/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import utils.Node;

/**
 *
 * @author William Barbosa
 */
public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        int max = 0;
        if(root != null){
            for(Node c : root.children){
                int cDepth = maxDepth(c);
                max = max > cDepth?max:cDepth;
            }
            max+=1;
        }
        return max;
    }
}
