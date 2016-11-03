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
public class LetterFrequency_1255 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringBuilder result = new StringBuilder();
        int numbLines, letter, frequency;
        int[] alp;

        input = br.readLine();
        numbLines = Integer.valueOf(input);

        for (int i = 0; i < numbLines; i++) {
            input = br.readLine();
            alp = new int[26];
            frequency = 0;
            for (int j = 0; j < input.length(); j++) {
                letter = (int) input.charAt(j);

                if (letter > 64 && letter < 91) {
                    letter -= 65;
                    alp[letter]++;
                    frequency = frequency > alp[letter] ? frequency : alp[letter];
                } else if (letter > 96 && letter < 123) {
                    letter -= 97;
                    alp[letter]++;
                    frequency = frequency > alp[letter] ? frequency : alp[letter];
                }
                
            }
            for(int x = 0; x<alp.length;x++){
                if(alp[x] == frequency){
                    letter = 97+x;
                    char cletter = (char) letter;
                    result.append(cletter);
                }
            }
            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
    }
}
