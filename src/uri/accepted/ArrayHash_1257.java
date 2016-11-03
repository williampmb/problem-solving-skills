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
public class ArrayHash_1257 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringBuilder result = new StringBuilder();
        int numbTest, lines, sum, sumTest, ascii;

        input = br.readLine();
        numbTest = Integer.valueOf(input);

        for (int i = 0; i < numbTest; i++) {
            input = br.readLine();
            lines = Integer.valueOf(input);
            sumTest = 0;
            for (int j = 0; j < lines; j++) {
                sum = 0;
                input = br.readLine();
                for (int l = 0; l < input.length();l++) {
                    ascii = ((int) input.charAt(l)) - 65;
                    
                    sum += ascii + j + l ;
                }
                sumTest += sum;
            }
            result.append(sumTest + "\n");
        }
        bw.write(result.toString());
        bw.flush();
    }
}
