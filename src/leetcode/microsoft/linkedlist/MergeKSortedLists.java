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
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        int k = lists.length;
        if (k == 0) {
            return null;
        }

        boolean missingVal = true;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int min = Integer.MIN_VALUE;
        int pos = -1;

        while (missingVal) {
            missingVal = false;
            for (int i = 0; i < k; i++) {
                if (lists[i] != null) {
                    missingVal = true;
                    if (pos == -1 || min > lists[i].val) {
                        min = lists[i].val;
                        pos = i;
                    }
                }
            }
            if (missingVal) {
                cur.next = lists[pos];
                lists[pos] = lists[pos].next;
                cur = cur.next;
                cur.next = null;
            }
            min = Integer.MIN_VALUE;
            pos = -1;

        }

        return head.next;
    }
}
