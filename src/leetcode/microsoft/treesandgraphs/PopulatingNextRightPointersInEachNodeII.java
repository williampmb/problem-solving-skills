/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;
import utils.TreeLinkNode;

/**
 *
 * @author William Barbosa
 */
public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> q1 = new LinkedList<>();
        Queue<TreeLinkNode> q2 = new LinkedList<>();
        
        q1.add(root);
        while(!q1.isEmpty()){
            TreeLinkNode cur = q1.poll();
            if(!q1.isEmpty()) cur.next = q1.peek();
            if(cur.left != null) q2.add(cur.left);
            if(cur.right!= null) q2.add(cur.right);
            if(q1.isEmpty()){
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
    }
}
