import java.io.FileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class LetterRange_1276 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        String input = br.readLine();
        while (input != null && !input.equals("")) {
            int[] avaibleLet = new int[26];

            for (int i = 0; i < input.length(); i++) {
                int posLet = input.charAt(i);
                if (posLet > 96 && posLet < 123) {
                    avaibleLet[posLet - 97]++;
                }
            }
            int start = -1, count = 0;
            int first, second;
            for (int i = 0; i < 26; i++) {
                if (avaibleLet[i] > 0) {
                    if (start == -1) {
                        start = i;
                    }
                    if (i == 25) {
                        count++;
                        if (count > 1) {
                            result.append(", ");
                        }
                        first = start + 97;
                        second = i + 97;
                        result.append((char) first + ":" + (char) second);
                    }
                } else if (start != -1) {
                    count++;
                    if (count > 1) {
                        result.append(", ");
                    }
                    first = start + 97;
                    second = i - 1 + 97;
                    result.append((char) first + ":" + (char) second);
                    start = -1;
                }

            }
            result.append("\n");

            input = br.readLine();
        }
        bw.write(result.toString());
        bw.flush();
    }
}
