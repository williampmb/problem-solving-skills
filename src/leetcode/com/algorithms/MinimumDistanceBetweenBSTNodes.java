/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author William Barbosa
 */
public class MinimumDistanceBetweenBSTNodes {
    //[90,69,null,49,89,null,52,null,null,null,null]
    //WRONG ANSWER
    public int minDiffInBST(TreeNode root) {
        int min = MinimumDistanceBetweenBSTNodes(root,null, null);
        return min;
    }

    private int MinimumDistanceBetweenBSTNodes(TreeNode cur, TreeNode p1, TreeNode p2) {
        int min = Integer.MAX_VALUE;
        if(cur != null ){
            int minLeft = MinimumDistanceBetweenBSTNodes(cur.left, p1, cur);
            int minRight = MinimumDistanceBetweenBSTNodes(cur.right, cur, p2);
            if(p1 != null){
                minLeft = Math.min(minLeft, cur.val - p1.val);
            }
            if(p2 != null ){
                minRight = Math.min(minRight, p2.val - cur.val );
            }
            
            min = Math.min(minLeft,minRight);
        }
        return min;
    }

  
}
