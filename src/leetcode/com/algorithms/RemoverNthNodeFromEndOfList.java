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
public class RemoverNthNodeFromEndOfList {

    public static void main(String[] args) {

    }

    /*
    * We need to go n times forward. Then walk together the end and nth pointer
    * until the end.next is null. So that we can remove the nth.
    * ...->nth->nth.next->nth.next.next->...end->null
    * so nth->nth.next.next->...end->null
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (n == 1 && head.next == null)) {
            return null;
        }
        if (n < 1) {
            return head;
        }

        ListNode nth = head;
        ListNode end = nth;

        while (n != 0 && end.next != null) {
            end = end.next;
            n--;
        }
        if(end.next == null && n>0){
            return nth.next;
        }

        while (end.next != null) {
            end = end.next;
            nth = nth.next;
        }

        nth.next = (nth.next).next;
        return head;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
