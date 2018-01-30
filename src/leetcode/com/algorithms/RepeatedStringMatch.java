/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author william barbosa
 */
public class RepeatedStringMatch {

    public static void main(String[] args) {
        RepeatedStringMatch r = new RepeatedStringMatch();
        int repeatedStringMatch = r.repeatedStringMatch2("aabaa", "aaab");
        System.out.println(repeatedStringMatch);
    }

    public int repeatedStringMatch(String A, String B) {
        int startA = 0, pointerB = 0, pointerA = 0, lengthA = A.length(), lengthB = B.length(), count = 1;

        while (startA < lengthA) {
            pointerA = startA;

            while (pointerB < lengthB) {
                if (B.charAt(pointerB) != A.charAt(pointerA)) {
                    break;
                }
                pointerB++;
                pointerA++;

                if (pointerB == lengthB) {
                    return count;
                } else if (pointerA == lengthA) {
                    pointerA = 0;
                    count++;
                }
            }
            pointerB = 0;
            startA++;
            count = 1;
        }
        return -1;
    }

    /*Author: @alexander at leetcode
    * I don't know why it is a good solution while it copies A into AS, So it uses
    * a lot of extra space and it is not a good way of copy strings "as += a" each iteration.
    * Also, for every iteration, it compares AS with B to see if it is a substring. 
    * Finally, it is not O(1) space complexity.
    */
    public int repeatedStringMatch2(String a, String b) {
        String as = a;
        for (int rep = 1; rep <= b.length() / a.length() + 2; rep++, as += a) {
            if (as.indexOf(b) != -1) {
                return rep;
            }
        }
        return -1;
    }
}
