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
public class FitOrDontFitII_1241 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int numbLines = Integer.valueOf(input);
        StringBuilder result = new StringBuilder();

        while (numbLines != 0) {
            input = br.readLine();
            String[] str = input.split(" ");
            int pos = 0;

            if (str[0].length() < str[1].length()) {
                while (pos < str[0].length()) {
                    result.append(str[0].charAt(pos));
                    result.append(str[1].charAt(pos));
                    pos++;
                }

                while (pos < str[1].length()) {
                    result.append(str[1].charAt(pos));
                    pos++;
                }
            }else{
                while (pos < str[1].length()) {
                    result.append(str[0].charAt(pos));
                    result.append(str[1].charAt(pos));
                    pos++;
                }

                while (pos < str[0].length()) {
                    result.append(str[0].charAt(pos));
                    pos++;
                }
            }
            result.append("\n");
            numbLines--;
        }
        bw.write(result.toString());
        bw.flush();

    }
}
