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
public class MutiplyString {

    public static void main(String[] args) {
        String multiply = multiply("458", "0");
        System.out.println(multiply);
    }

    /*
    * For each element in factor 1, we should mutiply for each element in factor 2
    * and add them in correct position of a single linked list that we can keep track
    * where it should be because of the power of 10.
    * in the end, we can reverse the linked list and we will have the result
    * 23*14 = 4*3 + 4*2*10 + 3*1*10 + 1*2*100
    * head->
    * head-> 2 -> 1
    * cur1     -> 8
    * cur2        3 ->
    * head-> 2 -> 2 -> 1
    * cur2          -> 2
    * head-> 2 -> 2 -> 3
    * The empty spaces represent where the single linked list is pointing based on the power of 10
    * reverse: 322
    */
    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        int size1 = num1.length(), size2 = num2.length();
        if(size1 == 0 || size2 == 0) return "0";
        
        MyLinkList head = new MyLinkList(0);
        MyLinkList cur1 = head, cur2;
        for (int i = size1 - 1; i >= 0; i--) {
            int alg1 = Integer.parseInt(num1.charAt(i) + "");
            if (cur1.next == null) {
                cur1.next = new MyLinkList(0);
            }
            cur2 = cur1;
            for (int j = size2 - 1; j >= 0; j--) {
                int alg2 = Integer.parseInt(num2.charAt(j) + "");
                cur2.add(alg1 * alg2);
                if (cur2.next == null) {
                    cur2.next = new MyLinkList(0);
                }
                cur2 = cur2.next;
            }
            cur1 = cur1.next;
        }

        return head.toString();
    }

    public static class MyLinkList {

        int val;
        MyLinkList next;

        public MyLinkList(int v) {
            val = v;
        }

        private void add(int i) {
            if (i == 0) {
                return;
            }
            int initial = i;
            int addVal = initial % 10;
            int addNext = initial / 10;
            int sum = addVal + this.val;
            this.val = sum % 10;
            addNext += sum / 10;
            if (addNext > 0) {
                if (next == null) {
                    next = new MyLinkList(0);
                }
                next.add(addNext);
            }

        }

        @Override
        public String toString() {
            StringBuilder numb = new StringBuilder();
            MyLinkList cur = next;
            numb.append(val);
            while (cur != null) {
                numb.insert(0, cur.val);
                cur = cur.next;
            }
            String numbWithout0 = numb.toString();
            int count = 0;
            while (count < numbWithout0.length() && numbWithout0.charAt(count) == '0') {
                count++;
            }
            numbWithout0 = numbWithout0.substring(count);
            if(numbWithout0.length() ==0) numbWithout0 = "0";
            return numbWithout0;
        }

    }

}
