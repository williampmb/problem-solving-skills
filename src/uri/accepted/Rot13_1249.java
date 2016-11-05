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
public class Rot13_1249 {

    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        int repres;
       
        while (input != null && !input.equals("")) {
            for (char thing : input.toCharArray()) {
                repres = (int) thing;
                if (repres > 64 && repres < 91) {
                    repres += 13;
                    repres = repres > 90 ? (repres % 91) + 65 : repres;
                } else if (repres > 96 && repres < 123) {
                    repres += 13;
                    repres = repres > 122 ? (repres % 123) + 97 : repres;
                }
                result.append((char) repres);
            }
            result.append("\n");
            input = br.readLine();
        }
        bw.write(result.toString());
        bw.flush();
    }
}
