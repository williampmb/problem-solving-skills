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
public class JustifierII_1278 {

    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        StringBuilder fixing;
        String[] text;
        String subStr;
        int size, dif;
        boolean start, end, space;

        int lines = Integer.valueOf(input);
        while (lines != 0) {
            size = 0;
            text = new String[lines];
            
            for (int i = 0; i < lines; i++) {
                subStr = br.readLine();
                fixing = new StringBuilder();
                space = false;
                start = true;
                end = false;
                
                for (int j = 0; j < subStr.length(); j++) {
                    int charAtInt = (int) subStr.charAt(j);
                    if (charAtInt == (char) ' ') {
                        space = true;
                    } else {
                        if (space && !start && end) {
                            fixing.append(" ");
                        }
                        fixing.append((char) charAtInt);
                        space = false;
                        start = false;
                        end = true;
                    }
                }
                text[i] = fixing.toString();
                if (size < text[i].length()) {
                    size = text[i].length();
                }
            }

            for (String t : text) {
                dif = size - t.length();
                String justify = new String(new char[dif]).replace("\0", " ");
                result.append(justify);
                result.append(t + "\n");
            }

            input = br.readLine();
            lines = Integer.valueOf(input);
            if (lines != 0) {
                result.append("\n");
            }
        }
        bw.write(result.toString());
        bw.flush();
    }
}
