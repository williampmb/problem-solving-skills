/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.treesandgraphs;

import utils.TreeLinkNode;

/**
 *
 * @author William Barbosa
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        TreeLinkNode r = new TreeLinkNode(3);
        TreeLinkNode rl = new TreeLinkNode(1);
        TreeLinkNode rr = new TreeLinkNode(5);
        r.left = rl;
        TreeLinkNode rll = new TreeLinkNode(0);
        TreeLinkNode rlr = new TreeLinkNode(2);
        rl.left = rll;
        rl.right = rlr;

        r.right = rr;
        TreeLinkNode rrl = new TreeLinkNode(4);
        TreeLinkNode rrr = new TreeLinkNode(6);
        rr.left = rrl;
        rr.right = rrr;
        PopulatingNextRightPointersInEachNode p = new PopulatingNextRightPointersInEachNode();
        p.connect(r);
    }

    public void connect(TreeLinkNode root) {
        connect(root, null);
        return;
    }

    private void connect(TreeLinkNode root, TreeLinkNode next) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;

        }
        if (next != null) {
            root.next = next.left;
        }
        connect(root.left, null);
        connect(root.right, root.next);

    }
}
