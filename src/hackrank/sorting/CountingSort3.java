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
public class CountingSort3 {
    public static void main(String[] args) throws FileNotFoundException {
       Scanner s = new Scanner(System.in);
        // Scanner s = new Scanner(new File("src/input.txt"));
        int numbs = Integer.parseInt(s.nextLine());
        int[] count = new int[100];
        int[] addThem = new int[100];
        while (numbs != 0) {
            
            String line = s.nextLine();
            String[] tk = line.split(" ");
            
            count[Integer.parseInt(tk[0])]++;
            numbs--;
        }
        addThem[0] = count[0];
        
        int i = 1;
        for (i = 1; i < count.length; i++) {
            addThem[i] = addThem[i-1]+ count[i];

        }
        i = 0;
        for (i = 0; i < count.length; i++) {
           
                System.out.print(addThem[i] + " ");
           

        }
      
    }
}
