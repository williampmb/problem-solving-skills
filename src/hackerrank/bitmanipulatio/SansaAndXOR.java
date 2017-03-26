package hackerrank.bitmanipulatio;


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
public class SansaAndXOR {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
       // Scanner s = new Scanner(new FileReader("src/input.txt"));
        StringBuilder sb = new StringBuilder();
        int test = s.nextInt();
        while (test != 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            int xor = xorSubArray(a);

            sb.append(xor + "\n");
            test--;
        }
        System.out.print(sb.toString());
    }

    private static int xorSubArray(int[] a) {
        int xor = 0;

        for (int i = 0; i < a.length; i++) {
            double posBef = i == 0 ? 0 : i;
            double posAft = i == a.length - 1 ? 0 : a.length - i - 1;
            double n = (posBef + 1.0) * (posAft + 1.0);
            if(n % 2.0 == 1.0) {
                xor ^= a[i];
            }
        }
        return xor;
    }

}
