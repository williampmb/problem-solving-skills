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
public class TagReplacement_1254 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        String input, tag, replace, text;
        boolean tagOn, match;
        int r, t;
        input = br.readLine();

        while (input != null && !input.equals("")) {
            replace = input;
            tag = br.readLine();
            text = br.readLine();
            tagOn = false;

            for (int i = 0; i < text.length(); i++) {
                if (tagOn) {
                    r = (int) replace.charAt(0);
                    t = (int) text.charAt(i);
                    if (r > 96 && r < 123) {
                        r -= 32;
                    }

                    if (t > 96 && t < 123) {
                        t -= 32;
                    }

                    if (r == t) {
                        match = true;
                        for (int j = 1; j < replace.length(); j++) {
                            if (text.length() - 1 < i + j) {
                                match = false;
                                break;
                            }
                            r = (int) replace.charAt(j);
                            t = (int) text.charAt(i + j);

                            if (r > 96 && r < 123) {
                                r -= 32;
                            }

                            if (t > 96 && t < 123) {
                                t -= 32;
                            }

                            if (r != t) {
                                match = false;
                                break;
                            }

                        }
                        if (match) {
                            result.append(tag);
                            i += replace.length() - 1;
                        } else {
                            result.append(text.charAt(i));
                        }
                    } else if ((int) text.charAt(i) == (int) '>') {
                        result.append(text.charAt(i));
                        tagOn = false;
                    } else {
                        result.append(text.charAt(i));
                    }

                } else if ((int) text.charAt(i) == (int) '<') {
                    tagOn = true;
                    result.append(text.charAt(i));
                } else {
                    result.append(text.charAt(i));
                }
            }
            result.append("\n");
            input = br.readLine();
        }
        bw.write(result.toString());
        bw.flush();
    }
}
