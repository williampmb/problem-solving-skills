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
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        //  l1.next.next = new ListNode(3);
        // l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        // l2.next = new ListNode(6);
        //  l2.next.next = new ListNode(6);
//
        ListNode addTwoNumbers = a.addTwoNumbers(l1, l2);

        int ax = 1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        Integer carry = new Integer(0);

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode dig = new ListNode(sum % 10);

            cur.next = dig;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        l1 = l1 == null ? l2 : l1;

        if (carry == 1 && l1 != null) {
            cur.next = addTwoNumbers(l1, new ListNode(1));
        }else if(carry == 1 && l1 == null){
            cur.next = new ListNode(1);
        }else{
            cur.next = l1;
        }
        return head.next;
    }

}
