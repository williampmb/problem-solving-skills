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
public class DancingSentence_1234 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        char[] toChar;
        boolean uppercase;
        int letInt;
        StringBuilder result = new StringBuilder();

        while ((input = br.readLine()) != null && !input.equals("")) {
            toChar = input.toCharArray();
            uppercase = false;

            for (int i = 0; i < toChar.length; i++) {
                letInt = (int) toChar[i];
                if (letInt == 32) {
                    
                } else if (uppercase) {
                    if (letInt < 91) {
                        letInt += 32;
                        toChar[i] = (char) letInt;
                    }
                    uppercase = false;
                } else {
                    if (letInt > 96) {
                        letInt -= 32;
                        toChar[i] = (char) letInt;
                    }
                    uppercase = true;
                }
                result.append(toChar[i]);
            }
            result.append("\n");
        }
        bw.write(result.toString());
        bw.flush();
    }
}
