package hackerrank.greedy;


import java.text.DecimalFormat;
import java.text.NumberFormat;
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
public class MarcsCakewalk {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int x = 0;
        while (n != x) {
            int c = s.nextInt();
            a = insertSort(a, c, x);
            x++;
        }
        double miles = 0;
        int count = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            miles += a[i] * Math.pow(2, count);
            count++;
        }

        NumberFormat format = new DecimalFormat("#");
        System.out.println(format.format(miles));
    }

    private static int[] insertSort(int[] a, int c, int i) {
        int j = 0;
        for (j = 0; j < i; j++) {
            if (c < a[j]) {
                int tmp = a[j];
                a[j] = c;
                c = tmp;
            }
        }
        a[j] = c;
        return a;
    }

}
