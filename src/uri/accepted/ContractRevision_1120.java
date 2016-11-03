/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri.accepted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author William
 */
public class ContractRevision_1120 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        String input;
        StringBuilder flawContract = new StringBuilder();
        int sum, numb;

        input = br.readLine();
        while (!input.equals("0 0")) {
            sum = 0;
            String[] tk = input.split(" ");
            int flawedDig = Integer.valueOf(tk[0]);
            for (char alg : tk[1].toCharArray()) {
                numb = Character.getNumericValue(alg);
                if (numb != flawedDig) {
                    sum += Character.getNumericValue(alg);
                    flawContract.append(alg);
                }

            }
            if (flawContract.length() == 0) {
                result.append("0\n");
            } else if (sum == 0) {
                result.append("0\n");
            } else {
                for(char alg : flawContract.toString().toCharArray()){
                    if(Character.getNumericValue(alg) ==0){
                        flawContract.delete(0, 1);
                    }else{
                        break;
                    }
                }
                result.append(flawContract.toString() + "\n");
            }
            flawContract = new StringBuilder();
            input = br.readLine();

        }

        bw.write(result.toString());
        bw.flush();

    }

}
