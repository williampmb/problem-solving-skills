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
                int count = 0;
                if (w.equals("")) {
                    numWords--;
                    continue;
                }
                for (char c : w.toCharArray()) {
                    int alg = (int) c;
                    count++;
                    if ((alg > 96 && alg < 123) || (alg > 64 && alg < 91)) {
                        if (count == w.length()) {
                            lenght += w.length();
                        }
                        continue;
                    } else if ((alg > 47 && alg < 58) || (alg == (int) '.')) {
                        if (w.length() == 1) {
                            numWords--;
                            break;
                        } else if (count == w.length() && alg == (int) '.') {
                            lenght += w.length() - 1;
                        } else {
                            numWords--;
                            break;
                        }
                    }
                }
            }
            if (numWords != 0) {
                howEasy = lenght / numWords;
            } else {
                howEasy = 0;
            }
            int grade;
            if (howEasy < 4) {
                grade = 250;
            } else if (howEasy == 4 || howEasy == 5) {
                grade = 500;
            } else {
                grade = 1000;
            }

            result.append(grade + "\n");
            input = br.readLine();
        }

        bw.write(result.toString());
        bw.flush();
    }
}
