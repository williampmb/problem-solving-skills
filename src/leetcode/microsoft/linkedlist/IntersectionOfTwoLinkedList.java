/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.linkedlist;

import leetcode.com.algorithms.ListNode;

/**
 *
 * @author William Barbosa
 */
public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int sizeA = getLength(headA);
        int sizeB = getLength(headB);

        ListNode longer, shorter;

        longer = sizeA > sizeB ? headA : headB;
        shorter = sizeA <= sizeB ? headA : headB;

        int sl = sizeA > sizeB ? sizeA : sizeB;
        int ss = sizeA <= sizeB ? sizeA : sizeB;

        while (sl != ss) {
            longer = longer.next;
            sl--;
        }

        while (longer != null) {
            if (longer == shorter) {
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }

        return null;
    }

    private int getLength(ListNode root) {
        ListNode cur = root;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
