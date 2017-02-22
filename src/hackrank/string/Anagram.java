package hackrank.string;


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
public class Anagram {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = s.nextInt();
        s.nextLine();
        while (test != 0) {
            String s1s2 = s.nextLine();
            int[] chars = new int[26];
            int size = s1s2.length();
            if (size % 2 == 1) {
                bw.write("-1\n");
            } else {
                int s1 = 0;
                for (s1 = 0; s1 < size / 2; s1++) {
                    chars[s1s2.charAt(s1) - 97]++;
                }
                for (int s2 = s1; s2 < size; s2++) {
                    chars[s1s2.charAt(s2) - 97]--;
                }
                int count = 0;
                for (int i : chars) {
                    if (i > 0) {
                        count += i;
                    }
                }
                bw.write(count + "\n");
            }
            test--;
        }
        bw.flush();

    }
}
