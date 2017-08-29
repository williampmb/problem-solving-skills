/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author willi
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) throws IOException {

        //execute Manacher's Algorithm
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Manacher Algorithm Test\n");
//        System.out.println("\nEnter String");
//        String text = br.readLine();
//
//        Manacher m = new Manacher();
//        String longestPalindrome = m.getLongestPalindrome(text);
//        System.out.println("\nLongest Palindrome : " + longestPalindrome);
        //  String input = "geeksskeeg";
        // String input = "HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE";
        String input = "abc";
        String palindrome = longestPalindrome(input);

        System.out.println(palindrome);
    }

    public static String longestPalindrome(String input) {

        if (input == null || input.length() == 0) {
            return "";
        }
        if (input.length() == 1) {
            return input;
        }

        char[] array = preprocessing(input);

        int center = array.length / 2;
        int direction = 1;

        String palindrome = checkLongestPalindromeOneSide(array, center, direction, input);

        return palindrome;

    }

    private static char[] preprocessing(String input) {
        StringBuilder build = new StringBuilder();
        build.append("|");
        for (char c : input.toCharArray()) {
            build.append(c + "|");
        }
        return build.toString().toCharArray();
    }

    private static String checkLongestPalindromeOneSide(char[] array, int center, int direction, String input) {
        int pr = center;
        int max = 0;
        int pif = 0, pff = 0;
        int[] startEnd = checkLongestPalindromeFromHalf(array, 1, center);
        max = startEnd[0];
        pif = startEnd[1];
        pff = startEnd[2];

        pr = center;
        if (pr * 2 > max) {
            startEnd = checkLongestPalindromeFromHalf(array, -1, center);
            if (max < startEnd[2] - startEnd[1]) {
                pif = startEnd[1];
                pff = startEnd[2];
                max = pff - pif;
            }

        }

       // System.out.println("pif: " + pif + " pff: " + pff);
      //  System.out.println(new String(array));
        //System.out.println();
        String substring = input.substring(pif / 2, pif / 2 + max / 2);
       // System.out.println(substring);
        return substring;
    }

    private static int[] checkLongestPalindromeFromHalf(char[] array, int direction, int center) {
        int size = array.length;
        int pr = center, pi = 0, pf = 0, i = 1;
        int[] posMax = new int[3];
        posMax[0] = 0;
        while (pr < size - 1 && pr > 0) {
            pi = pr;
            pf = pr;
            if (array[pr - i] == array[pr + i]) {
                while (array[pr - i] == array[pr + i]) {
                    i++;
                    if (pr - i < 0 || pr + i > size - 1) {
                        break;
                    }
                }
                i--;
                pi = pr - i;
                pf = pr + i;
                if (posMax[0] < pf - pi) {
                    posMax[1] = pi;
                    posMax[2] = pf;
                    posMax[0] = pf - pi;
                }
            }
            i = 1;
            pr += direction;

            if (pr - i < 0 || pr + i > size - 1 || ((size - pr) * 2 + 1) < posMax[0]) {
                break;
            }
        }
        return posMax;
    }

    /**
     * Class Manacher  to solve Longest Palindromic Substring in a complexity O(n) *
     */
    public static class Manacher {

        /**
         * function to preprocess string *
         */
        public String preProcess(String str) {
            int len = str.length();
            if (len == 0) {
                return "^$";
            }
            String s = "^";
            for (int i = 0; i < len; i++) {
                s += "#" + str.charAt(i);
            }
            s += "#$";
            return s;
        }

        /**
         * function to get largest palindromic substring *
         */
        public String getLongestPalindrome(String str) {
            /**
             * preprocess string *
             */
            char[] s = preProcess(str).toCharArray();
            int N = s.length;
            int[] p = new int[N + 1];
            int id = 0, mx = 0;
            for (int i = 1; i < N - 1; i++) {
                p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 0;
                while (s[i + 1 + p[i]] == s[i - 1 - p[i]]) {
                    p[i]++;
                }
                if (i + p[i] > mx) {
                    mx = i + p[i];
                    id = i;
                }
            }
            /**
             * length of largest palindrome *
             */
            int maxLen = 0;
            /**
             * position of center of largest palindrome *
             */
            int centerIndex = 0;
            for (int i = 1; i < N - 1; i++) {
                if (p[i] > maxLen) {
                    maxLen = p[i];
                    centerIndex = i;
                }
            }
            /**
             * starting index of palindrome *
             */
            int pos = (centerIndex - 1 - maxLen) / 2;
            return str.substring(pos, pos + maxLen);
        }
        /**
         * Main Function *
         */

    }
}
