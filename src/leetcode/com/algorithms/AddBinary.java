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
public class AddBinary {

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("100010", "11"));
    }
    
    /*
    * After solving, I thought I should compare and analyze the question with a
    * solved solution. LeetCode Author: lx223
    */
     public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    
     /*
     * My solution.
     */
    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int sb1 = a.length(), sb2 = b.length(), min = 0;
        min = sb1 > sb2 ? sb2 : sb1;
        StringBuilder sb = new StringBuilder();
        char passOne = '0';
        for (int i = 0; i < min; i++) {
            char cb1 = a.charAt(sb1 - i - 1);
            char cb2 = b.charAt(sb2 - i - 1);
            if (cb1 == '1' && cb2 == '1') {
                sb.insert(0, passOne);
                passOne = '1';
            } else if ((cb1 == '1' && cb2 == '0') || (cb1 == '0' && cb2 == '1')) {
                if (passOne == '1') {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                }
            } else {
                if (passOne == '1') {
                    sb.insert(0, '1');
                    passOne = '0';
                } else {
                    sb.insert(0, '0');
                }
            }
        }
        int csb1 = sb1 - min-1;
        while (csb1 >= 0) {
            char cb1 = a.charAt(csb1);
            if (passOne == '1' && cb1 == '1') {
                sb.insert(0, '0');
            } else if ((cb1 == '0' && passOne == '1') || (passOne == '0' && cb1 == '1')) {
                sb.insert(0, '1');
                passOne = '0';
            }else {
                sb.insert(0, '0');
            }
            csb1--;
        }
        int csb2 = sb2 - min-1;
        while (csb2 >= 0) {
            char cb2 = b.charAt(csb2);
            if (passOne == '1' && cb2 == '1') {
                sb.insert(0, '0');
            } else if ((cb2 == '0' && passOne == '1') || (passOne == '0' && cb2 == '1')) {
                sb.insert(0, '1');
                passOne = '0';
            } else {
                sb.insert(0, '0');
            }
            csb2--;
        }

        if (passOne == '1') {
            sb.insert(0, '1');
        }
        return sb.toString();

    }
}
