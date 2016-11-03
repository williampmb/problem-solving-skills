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
public class Justifier_1273 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringBuilder result = new StringBuilder();

        input = br.readLine();
        int numbWords, longest, i, j, dif;

        String[] words;

        numbWords = Integer.valueOf(input);
        while (numbWords > 0) {
            words = new String[numbWords];
            longest = 0;
            for (i = 0; i < numbWords; i++) {
                words[i] = br.readLine();
                longest = longest >= words[i].length() ? longest : words[i].length();
            }

            for (i = 0; i < numbWords; i++) {
                dif = longest - words[i].length();
                if (dif > 0) {
                    String justify = new String(new char[dif]).replace("\0", " ");
                    result.append(justify);
                }
                result.append(words[i] + "\n");
            }
            
            input = br.readLine();
            numbWords = Integer.valueOf(input);
            if(numbWords > 0){
                result.append("\n");
            }
        }
        bw.write(result.toString());
        bw.flush();
    }
}
