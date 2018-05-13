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
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    static void print(ListNode t) {
        ListNode cur = t;
        while(cur != null){
            System.out.print(cur.val + "-");
            cur = cur.next;
        }
    }
}
