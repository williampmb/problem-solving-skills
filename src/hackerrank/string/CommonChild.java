package hackerrank.string;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class CommonChild {

    static int maxComum = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();

        //int r = recursiveSolution(s1, s2);
        int r = longestCommumSubsequence(s1, s2);
        System.out.println(r);

    }

    private static int recursiveSolution(String s1, String s2) {
        int s1Hist = histogram(s1);
        s2 = reduceString(s2, s1Hist);
        int s2Hist = histogram(s2);
        s1 = reduceString(s1, s2Hist);
        int r = incomum(s1, s2);
        return r;
    }

    private static int histogram(String s) {
        int db = 0;
        for (char c : s.toCharArray()) {
            db |= (1 << (c - 65));
        }
        return db;
    }

    private static String reduceString(String s, int db) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((db & (1 << (c - 65))) > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //Recursive method (exponential complexity)
    private static int incomum(String s1, String s2) {
        int commum = 0;
        int sizeS1 = s1.length();
        int sizeS2 = s2.length();
        int smallerString = sizeS1 > sizeS2 ? sizeS2 : sizeS1;
        if (s1.length() == 0 || s2.length() == 0) {
            return commum;
        }
        if (maxComum > commum + smallerString) {
            return commum;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            commum++;
            if (maxComum < commum) {
                maxComum = commum;
            }
            commum += incomum(s1.substring(1), s2.substring(1));

        } else {

            int a = incomum(s1.substring(1), s2);
            int b = incomum(s2.substring(1), s1);
            int c = incomum(s1.substring(1), s2.substring(1));
            if (a >= b && a >= c) {
                commum += a;
            } else if (b >= a && b >= c) {
                commum += b;
            } else if (c >= a && c >= b) {
                commum += c;
            }
        }
        if (maxComum < commum) {
            maxComum = commum;
        }
        return commum;
    }

    private static int longestCommumSubsequence(String s1, String s2) {
        int s1Leng = s1.length();
        int s2Leng = s2.length();
        int[][] matrix = new int[s1Leng+1][s2Leng+1];

        for (int i = 0; i < s1Leng; i++) {
            int schar1 = s1.charAt(i);
            for (int j = 0; j < s2Leng; j++) {
                int schar2 = s2.charAt(j);
                if (schar1 == schar2) {
                    matrix[i+1][j+1] = matrix[i - 1+1][j - 1+1] + 1;
                } else {
                    int left = matrix[i+1][j - 1+1];
                    int top = matrix[i - 1+1][j+1];
                    matrix[i+1][j+1] = top > left ? top : left;
                }
            }
        }
        return matrix[s1Leng][s2Leng];
    }
}
