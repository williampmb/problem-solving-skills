package hackerrank.sorting;


import java.util.ArrayList;
import java.util.List;
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
public class ClosestNumbers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numb = s.nextInt();
        int[] a = new int[numb];
        for (int i = 0; i < numb; i++) {
            int nextInt = s.nextInt();
            a[i] = nextInt;
        }

        List<Pair> pairs = findSmallestPairs(a);

        print(pairs);
    }

    private static int[] quickSort(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        a = quickSort(a, a.length - 1, 0);
        return a;
    }

    private static int[] quickSort(int[] a, int pivot, int wall) {
        int start = wall;
        int end = pivot;
        if (a == null || pivot == wall || wall > pivot) {
            return a;
        }
        int p = a[pivot];
        for (int i = wall; i < pivot; i++) {
            if (p >= a[i]) {
                int aux = a[wall];
                a[wall] = a[i];
                a[i] = aux;
                wall++;
            }

        }
        if (a[pivot] < a[wall]) {
            int aux = a[wall];
            a[wall] = a[pivot];
            a[pivot] = aux;
        }

        a = quickSort(a, wall - 1, start);
        a = quickSort(a, end, wall + 1);

        return a;

    }

    private static List<Pair> findSmallestPairs(int[] a) {
        if (a == null || a.length < 2) {
            return null;
        }
        a = quickSort(a);
        int p1 = a[0];
        int p2 = a[1];
        int dif = Math.abs(p1 - p2);
        List<Pair> p = new ArrayList<>();
        p.add(new Pair(p1, p2));
        for (int i = 1; i < a.length - 1; i++) {
            p1 = a[i];
            p2 = a[i + 1];
            int d2 = Math.abs(p1 - p2);
            if (d2 < dif) {
                p = new ArrayList<>();
                p.add(new Pair(p1, p2));
                dif = d2;
            } else if (d2 == dif) {
                p.add(new Pair(p1, p2));
            }

        }
        return p;
    }

    private static void print(List<Pair> pairs) {
        for(Pair p : pairs){
            System.out.print(p.p1 + " " + p.p2 + " ");
        }
        System.out.println("");
    }

    private static class Pair {

        int p1, p2;

        public Pair(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
}
