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
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);

        m.mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
                cur.next = null;

            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
                cur.next = null;
            }
        }

        l1 = l1 == null ? l2 : l1;

        cur.next = l1;

        return head.next;

    }

    /*
    ListNode head, cur;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if (l1.val < l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        while( l1 != null){
            cur.next = new ListNode(l1.val);
            l1 = l1.next;
            cur = cur.next;
        }
        
        while( l2 != null){
            cur.next = new ListNode(l2.val);
            l2 = l2.next;
            cur = cur.next;
        }
        
        return head;
     */
}
