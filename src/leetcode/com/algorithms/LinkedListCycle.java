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
public class LinkedListCycle {

    public boolean haasCyle(ListNode head) {
        if(head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            walker = walker.next;
            if(runner.val == walker.val) return true;
        }
        return false;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
