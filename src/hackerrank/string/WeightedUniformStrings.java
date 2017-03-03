package hackerrank.string;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author William
 *
 */
public class WeightedUniformStrings {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new FileReader("src/input.txt"));
        StringBuilder sb = new StringBuilder();
        String word = s.nextLine();
        int[] a = weightedString(word);
        int queries = s.nextInt();
        while (queries != 0) {
            int q = s.nextInt();
            String result = executeQuery(q, a);
            sb.append(result + "\n");
            queries--;
        }
        System.out.print(sb.toString());

    }

    public static int[] weightedString(String s) {
        int[] a = new int[26];
        int cur = s.charAt(0);
        int count = 1;
        if (s.length() == 1) {
            a[cur - 97] = count;
        }

        for (int i = 1; i < s.length(); i++) {
            int charAt = s.charAt(i);
            if (cur == charAt) {
                count++;

            } else {
                if (count > a[cur - 97]) {
                    a[cur - 97] = count;
                }
                count = 1;
                cur = charAt;
            }
            if (i == s.length() - 1 && count > a[charAt - 97]) {
                a[charAt - 97] = count;
            }
        }
        return a;
    }

    private static String executeQuery(int q, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if ((i + 1) * a[i] >= q) {
                if (q % (i + 1) == 0) {
                    return "Yes";
                }
            }
        }
        return "No";
    }
}
