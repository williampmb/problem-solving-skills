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
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode a = new ListNode(new int[]{});
        a.print();
        ListNode b = new ListNode(new int[]{1});
        b.print();
        
        ListNode r = addTwoNumbers(a,b);
        r.print();

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode sum = head;
        int add = 0;

        while (l1 != null && l2 != null) {
            int numb = l1.val + l2.val;
            numb += add;
            if (numb > 9) {
                numb = numb % 10;
                add = 1;
            } else {
                add = 0;
            }
            sum.next = new ListNode(numb);
            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 != null) {
            l1 = l2;
        }
        if(l1 == null && add == 1){
            sum.next = new ListNode(1);
        }else{
            if(l1 != null && add == 1){
                sum.next = addTwoNumbers(l1, new ListNode(1));
            }else{
                sum.next = l1;
            }
        }
       
        if (head.next != null) {
            return head.next;
        } else {
            return head;
        }

    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int[] x) {
            if(x.length == 0 ){
               return;
            }
            val = x[0];
            ListNode head = null;
            ListNode add = head;
            for (int i = 1; i < x.length; i++) {
                if (head == null) {
                    head = new ListNode(x[i]);
                    add = head;
                } else {
                    add.next = new ListNode(x[i]);
                    add = add.next;
                }
            }
            next = head;
        }

        void print() {
            ListNode print = next;
            System.out.print(val + "-");
            while (print != null) {
                System.out.print(print.val + "-");
                print = print.next;
            }
            System.out.println("");
        }
    }
}
