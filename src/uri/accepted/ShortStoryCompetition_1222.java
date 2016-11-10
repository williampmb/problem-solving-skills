package uri.accepted;


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
public class ShortStoryCompetition_1222 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        String input = br.readLine();
        String[] text, ref;
        int numWords, numLines, numChars, countChars, countLines, countPages;

        while (input != null && !input.equals("")) {
            ref = input.split(" ");
            numWords = Integer.valueOf(ref[0]);
            numLines = Integer.valueOf(ref[1]);
            numChars = Integer.valueOf(ref[2]);
            countChars = 0;
            countLines = 1;
            countPages = 1;

            input = br.readLine();
            text = input.split(" ");

            for (int i = 0; i < numWords; i++) {
                if (countChars == 0) {
                    countChars = text[i].length();
                } else if (countChars + 1 + text[i].length() <= numChars) {
                    countChars += 1 + text[i].length();
                } else if (countLines + 1 <= numLines) {
                    countChars = text[i].length();
                    countLines++;
                } else {
                    countPages++;
                    countLines = 1;
                    countChars = text[i].length();

                }
            }
            result.append(countPages + "\n");
            input = br.readLine();
        }
        bw.write(result.toString());
        bw.flush();

    }
}
