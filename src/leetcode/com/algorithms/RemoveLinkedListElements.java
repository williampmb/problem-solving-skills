/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        a = removeElements(a, 6);
        a.print();

    }

    //O(n) runtime because we need to check at least once every single node.
    //O(1) space since we dont need to store any extra data
    public static ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        if(head == null) return null;
        while (cur.next != null) {
           if(cur.next.val == val) cur.next = cur.next.next;
           else cur = cur.next;
        }
        if(head.val == val) return head.next;
        return head;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        void print() {
            System.out.print(val + "-");
            if (next != null) {
                next.print();
            }
        }
    }
}
