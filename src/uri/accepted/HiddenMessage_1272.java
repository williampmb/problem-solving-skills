package uri.accepted;


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
public class HiddenMessage_1272 {

    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        int numbLines = Integer.valueOf(input);
        boolean newWord;
        int delimiter = (char) ' ';

        while (numbLines != 0) {
            input = br.readLine();
            newWord = true;

            for (int i = 0; i < input.length(); i++) {
                char charAt = input.charAt(i);
                if ((int) charAt != delimiter && newWord) {
                    result.append(charAt);
                    newWord = false;
                } else if ((int) charAt == delimiter) {
                    newWord = true;
                }
            }

            result.append("\n");
            numbLines--;

        }
        bw.write(result.toString());
        bw.flush();
    }
}
