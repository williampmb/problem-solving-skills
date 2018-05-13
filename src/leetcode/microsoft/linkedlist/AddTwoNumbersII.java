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
public class AddTwoNumbersII {

    public class SumState {
        public ListNode numb = null;
        public int carry = 0;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int size1 = listSize(l1);
        int size2 = listSize(l2);

        SumState state = new SumState();

        if (size1 > size2) {
            state = addTwoNumbers(l1, size1, l2, size2, state);
        } else {
            state = addTwoNumbers(l2, size2, l1, size1, state);
        }

        if (state.carry == 1) {
            ListNode cur = new ListNode(1);
            cur.next = state.numb;
            state.numb = cur;
        }
        return state.numb;
    }

    private int listSize(ListNode l2) {
        ListNode cur = l2;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    private SumState addTwoNumbers(ListNode l1, int s1, ListNode l2, int s2, SumState state) {
        ListNode cur = new ListNode(0);

        if (s1 > s2) {
            state = addTwoNumbers(l1.next, s1 - 1, l2, s2, state);
        } else if (s1 == s2 && s1 != 1) {
            state = addTwoNumbers(l1.next, s1 - 1, l2.next, s2 - 1, state);
        }

        int sum = 0;
        sum += l1.val + state.carry;
        if (s1 == s2) {
            sum += l2.val;
        }
        state.carry = sum / 10;
        cur.val = sum % 10;
        cur.next = state.numb;
        state.numb = cur;

        return state;
    }
}
