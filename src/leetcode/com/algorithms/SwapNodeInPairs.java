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
public class SwapNodeInPairs {
    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode tree = new ListNode(3);
        ListNode four = new ListNode(4);
        
        one.next = two;
        two.next = tree;
        tree.next = four;
        
        one.print();
        
        one = swapPairs(one);
        
        one.print();
        
    }
    
    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
    
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      
      public void print(){
          ListNode current = next;
          System.out.print(val + "-");
          while(current != null){
              System.out.print(current.val + "-");
              current = current.next;
          }
          System.out.println("");
      }
  }
}
