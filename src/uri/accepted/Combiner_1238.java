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
public class Combiner_1238 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();

        int numbLines = Integer.valueOf(input);
        String[] str;
        int l1, l2, i;

        while (numbLines != 0) {
            input = br.readLine();
            str = input.split(" ");
            if (str[0].length() < str[1].length()) {
                result.append("nao encaixa\n");
            } else {
                i = 0;
                l1 = str[0].length();
                l2 = str[1].length();

                l1 -= l2;
                while (l2 != 0) {
                    if (((int) str[0].charAt(l1+i)) != ((int) str[1].charAt(i))) {
                        result.append("nao encaixa\n");
                        break;
                    }
                    l2--;
                    i++;
                }
                if (l2 == 0) {
                    result.append("encaixa\n");
                }
            }

            numbLines--;
        }
        
        bw.write(result.toString());
        bw.flush();

    }
}
