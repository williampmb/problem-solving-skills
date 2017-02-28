package hackerrank.string;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
public class TheLoveLetterMystery {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = s.nextInt();
        while (test != 0) {
            String word = s.next();
            int changed = prankWord(word);
            bw.write(changed + "\n");
            test--;
        }
        bw.flush();
    }

    private static int prankWord(String word) {

        int size = word.length();
        if (size == 0 || size == 1) {
            return 0;
        }

        int changes = 0;
        for (int i = 0; i < size / 2; i++) {
            int let1 = word.charAt(i);
            int let2 = word.charAt(size - 1 - i);
            if (let1 != let2) {
                changes += Math.abs(let1 - let2);
            }
        }
        return changes;
    }
}
