package hackerrank.greedy;


import java.text.DecimalFormat;
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
public class MinimumAbsoluteDifferenceInAnArray {
    static int[] a;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        a = execute(a);
        float dif = -1;
        for(int i = 0 ; i< n-1; i++){
            float abs = Math.abs(a[i]-a[i+1]);
            if(dif == -1){
                dif = abs;
            }else if(abs<dif){
                dif = abs;
            }
        }
        DecimalFormat f = new DecimalFormat("#0");
                
        System.out.println(f.format(dif));
    }

    public static int[] execute(int[] array) {
        a = array;
        int wall = 0;
        int pivot = array[array.length - 1];

        quickSort(wall, pivot, array.length - 1);

        return a;
    }

    private static void quickSort(int wall, int pivot, int posPivot) {
        int start = wall;
        int end = posPivot;
        int current = wall;
        int tmp;

        if (current == posPivot) {
            //break when the subarray has lenght one.
            return;
        }

        while (posPivot != current) {
            if (a[current] < pivot) {
                //Put everything smaller than pivot at the right side.
                tmp = a[wall];
                a[wall] = a[current];
                a[current] = tmp;
                wall++;
                current = wall;
            } else if (pivot == a[current]) {
                if (posPivot != current) {
                    //If it has repeated numbers, this solves the case.
                    current++;
                } else {
                    //If it gets the last two elements of the array.
                    tmp = a[wall];
                    a[wall] = pivot;
                    a[current] = tmp;
                    if (current != wall) {
                        //if it is not at the end of the array
                        wall++;
                    }
                }
            } else {
                //do nothing, move forward.
                current++;
            }
        }

        if (pivot == a[current]) {
            tmp = a[wall];
            a[wall] = pivot;
            a[current] = tmp;
            if (current != wall) {
                wall++;
            }
        }

        //Split the right side of the pivot, from the left side
        quickSort(start, a[wall - 1], wall - 1);
        quickSort(wall, a[end], end);
    }
}
