package hackerrank.hack45;


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
public class MiniMaxSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] tk = input.split(" ");

        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        long sum = 0, maxSum, minSum;

        for (int i = 0; i < tk.length - 1; i++) {
            long numb = Long.parseLong(tk[i]);
            sum += numb;
            if (numb < min) {
                min = numb;
            }
            if (numb > max) {
                max = numb;
            }

        }

        long last = Long.parseLong(tk[tk.length - 1]);

        if (last > min) {
            maxSum = sum - min + last;
        } else {
            maxSum = sum;
        }

        if (last < max) {
            minSum = sum - max + last;
        } else {
            minSum = sum;
        }

        bw.write(minSum + " " + maxSum);
        bw.flush();

    }
}
