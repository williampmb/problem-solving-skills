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
public class MultipleReading_1262 {

    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        String trace;
        int procs, count, procsReaming;

        trace = input;
        while (input != null && !input.equals("")) {
            input = br.readLine();
            procs = Integer.valueOf(input);
            count = 0;
            procsReaming = procs;
            for (char t : trace.toCharArray()) {
                if ((int) t == (char) 'W') {
                    count++;
                    procsReaming = procs;
                } else if ((int) t == (char) 'R') {
                    if (procsReaming == procs) {
                        count++;
                    }
                    procsReaming--;

                    if (procsReaming == 0) {
                        procsReaming = procs;
                    }

                }
            }
            input = br.readLine();
            trace = input;
            result.append(count + "\n");
        }
        bw.write(result.toString());
        bw.flush();
    }
}
