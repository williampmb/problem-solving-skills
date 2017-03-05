package hackerrank.sorting;


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
public class RunningTimeOfQuicksort {

    static int quicksortComplexity = 0;
    static int insertionComplextiy = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numb = s.nextInt();
        int[] a = new int[numb];
        int[] b = new int[numb];
        for (int i = 0; i < numb; i++) {
            int nextInt = s.nextInt();
            a[i] = nextInt;
            b[i] = nextInt;
        }

        quickSort2Sorting(a);
        insertionSort(b);
        System.out.println(insertionComplextiy - quicksortComplexity);
    }

    private static int[] quickSort2Sorting(int[] a) {
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
                
                quicksortComplexity++;
            }

        }
        if (a[pivot] <= a[wall]) {
            int aux = a[wall];
            a[wall] = a[pivot];
            a[pivot] = aux;
            quicksortComplexity++;
        }

       // print(a);

        a = quickSort(a, wall - 1, start);
        a = quickSort(a, end, wall + 1);

        return a;

    }

    private static void print(int[] a) {

        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println("");
    }

    private static int[] insertionSort(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int numb = a[i];
                int mov = i - 1;
                while (mov > -1 && numb < a[mov]) {
                    a[mov + 1] = a[mov];
                    mov--;
                    insertionComplextiy++;
                }
                a[mov + 1] = numb;
            }
        }
        return a;
    }
}
