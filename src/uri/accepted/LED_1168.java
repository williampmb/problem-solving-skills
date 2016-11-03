package uri.accepted;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author William
 */
public class LED_1168 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        String input;
        int numb, sum;

        int[] leds = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        input = br.readLine();
        int numLines = Integer.valueOf(input);
        
        for(int i =0; i< numLines; i++){
            input = br.readLine();
            sum = 0;
            for(char alg : input.toCharArray()){
                numb = Character.getNumericValue(alg);
                sum += leds[numb];
                
            }
            result.append(sum + " leds\n");
        }
        
        bw.write(result.toString());
        bw.flush();
    }
}
