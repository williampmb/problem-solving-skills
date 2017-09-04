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
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head != null){
            ListNode current = head;
            while(current != null){
                ListNode next = current.next;
                if(next != null && current.val == next.val){
                    while(next != null && next.val == current.val){
                        next = next.next;
                    }
                    current.next = next;
                }
                current = current.next;
            }
        }
        return head;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
