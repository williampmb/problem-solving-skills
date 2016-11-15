
import java.io.FileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class HowEasy_1243 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        //   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        String input;
        int numWords, lenght, howEasy;

        input = br.readLine();

        while (input != null && !input.equals("")) {
            String[] tok = input.split(" ");
            numWords = tok.length;
            lenght = 0;
            for (String w : tok) {
                lenght += w.length();
            }

            howEasy = lenght / numWords;
            result.append(howEasy + "\n");
            input = br.readLine();
        }

        bw.write(result.toString());
        bw.flush();
    }
}
