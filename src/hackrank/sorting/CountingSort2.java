package hackrank.sorting;


import java.io.File;
import java.io.FileNotFoundException;
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
public class CountingSort2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        //Scanner s = new Scanner(new File("src/input.txt"));
        int numbs = s.nextInt();
        int[] count = new int[100];
        while (numbs != 0) {
            int value = s.nextInt();
            count[value]++;
            numbs--;
        }
        int i = 0;
        for (i = 0; i < count.length - 1; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }

        }

        for (int j = 0; j < count[i]; j++) {
            if (count[i] - 1 == j) {
                System.out.print(i + "\n");
            } else {
                System.out.print(i + " ");

            }

        }

    }
}
