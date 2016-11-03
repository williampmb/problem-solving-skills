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
public class CaesarCipher_1253 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String codSent;
        StringBuilder result = new StringBuilder();
        int shift,alg;
        int numbLines = Integer.valueOf(input);

        while (numbLines != 0) {
            codSent = br.readLine();
            shift = Integer.valueOf(br.readLine());
            
            for(char letter : codSent.toCharArray()){
                alg = (int) letter;
                alg = letter - shift;
                if(alg <65){
                    alg = 65 - alg;
                    alg = 91 - alg;
                }
                result.append(((char)alg));
            }
            result.append("\n");
            numbLines--;
        }
        bw.write(result.toString());
        bw.flush();
    }
}
