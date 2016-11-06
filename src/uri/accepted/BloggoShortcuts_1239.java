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
public class BloggoShortcuts_1239 {

    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        boolean italic, bold;

        while (input != null && !input.equals("")) {
            italic = false;
            bold = false;

            for (int i = 0; i < input.length(); i++) {
                char read = input.charAt(i);
                if ((int) read == (int) '_') {
                    if (!italic) {
                        result.append("<i>");
                        italic = true;
                    } else {
                        result.append("</i>");
                        italic = false;
                    }
                }else if ((int) read == (int) '*') {
                    if (!bold) {
                        result.append("<b>");
                        bold = true;
                    } else {
                        result.append("</b>");
                        bold = false;
                    }
                }else{
                     result.append(read);
                }
            }
            result.append("\n");
            input = br.readLine();
        }
        bw.write(result.toString());
        bw.flush();
    }
}
