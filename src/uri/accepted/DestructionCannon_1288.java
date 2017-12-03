/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri.accepted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author willi
 */
public class DestructionCannon_1288 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(br.readLine());
        while (cases != 0) {
            int leads = Integer.parseInt(br.readLine());
            int[][] map = new int[leads + 1][102];
            int cols = map[0].length;
            for (int i = 1; i < leads+1; i++) {
                String strLead = br.readLine();
                String[] spec = strLead.split(" ");
                int damage = Integer.parseInt(spec[0]);
                int weight = Integer.parseInt(spec[1]);

                for (int j = 1; j < cols; j++) {
                    if (j < weight) {
                        map[i][j] = map[i - 1][j];
                    } else {
                        map[i][j] = Math.max(map[i - 1][j], map[i - 1][j - weight] + damage);
                    }
                }
            }
            int capacity = Integer.parseInt(br.readLine());
            int resistance = Integer.parseInt(br.readLine());

            if (map[leads][capacity] >= resistance) {
                bw.write("Missao completada com sucesso\n");
            } else {
                bw.write("Falha na missao\n");
            }
            bw.flush();

            cases--;
        }
    }
}
