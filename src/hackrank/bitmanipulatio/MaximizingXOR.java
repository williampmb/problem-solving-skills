package hackrank.bitmanipulatio;


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
public class MaximizingXOR {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int left = Integer.parseInt(br.readLine());
        int right = Integer.parseInt(br.readLine());
        int max = 0;
        int xor = 0;
        for (int i = left; i <= right; i++) {
            for (int j = i; j <= right; j++) {
                xor = i ^ j;
                if (xor > max) {
                    max = xor;
                }
            }
        }
        bw.write(max+"\n");
        bw.flush();

    }
}
