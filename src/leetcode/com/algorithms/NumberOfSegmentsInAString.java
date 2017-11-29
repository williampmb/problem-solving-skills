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
public class NumberOfSegmentsInAString {

    public static void main(String[] args) {
        NumberOfSegmentsInAString n = new NumberOfSegmentsInAString();
        //int c = n.countSegments("Hello, my name is John");
        int c = n.countSegments(",a,aaa  ");
        //int c = n.countSegments("   ");
        System.out.println(c);
    }

    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        boolean letter = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
            }
        }
        return count;
    }
}
