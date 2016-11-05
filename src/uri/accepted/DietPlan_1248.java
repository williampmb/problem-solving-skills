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
public class DietPlan_1248 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String bfast, lunch;
        char[] diet;
        int alg, dinner;
        int numbTests = Integer.valueOf(input);

        int[] dietPlan;
        StringBuilder result = new StringBuilder();
        StringBuilder dinnerPlan;

        while (numbTests != 0) {
            dietPlan = new int[26];
            diet = br.readLine().toCharArray();
            for (char d : diet) {
                alg = ((int) d) - 65;
                dietPlan[alg]++;
            }
            bfast = br.readLine();
            for (char b : bfast.toCharArray()) {
                alg = ((int) b) - 65;
                dietPlan[alg]--;
            }
            lunch = br.readLine();
            for (char l : lunch.toCharArray()) {
                alg = ((int) l) - 65;
                dietPlan[alg]--;
            }

            dinnerPlan = new StringBuilder();
            for (int i = 0; i < dietPlan.length; i++) {
                dinner = dietPlan[i];
                if (dinner < 0 || dinner > 1) {
                    dinnerPlan = new StringBuilder();
                    dinnerPlan.append("CHEATER");
                    break;
                } else if (dinner == 1) {
                    dinnerPlan.append((char) (i + 65));
                }
            }
            result.append(dinnerPlan.toString());
            result.append("\n");
            numbTests--;

        }
        bw.write(result.toString());
        bw.flush();
    }
}
