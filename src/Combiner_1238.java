
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

        String input;
        StringBuilder result = new StringBuilder();
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int half, numbLines;

        input = br.readLine();
        numbLines = Integer.valueOf(input);
        char[] vector = null;
        char tmp;
        int posIni,posFin;

        for (int i = 0; i < numbLines; i++) {
            input = br.readLine();
            half = input.length()/2;
            vector = input.toCharArray();
            
            posIni = 0;
            posFin = half -1;
            while(posIni < posFin){
                tmp = vector[posFin];
                vector[posFin] = vector[posIni];
                vector[posIni] = tmp;
                posIni++;
                posFin--;
            }
            
            posIni = half;
            posFin = vector.length-1;
            while(posIni < posFin){
                tmp = vector[posFin];
                vector[posFin] = vector[posIni];
                vector[posIni] = tmp;
                posIni++;
                posFin--;
            }
            result.append(vector);
            result.append("\n");
        }
        bw.write(result.toString());
        bw.flush();
    }
}
