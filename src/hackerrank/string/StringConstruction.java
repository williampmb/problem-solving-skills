package hackerrank.string;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class StringConstruction {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int test = Integer.parseInt(s.nextLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (test != 0) {
            String line = s.nextLine();
            int cost = construction(line);
            bw.write(cost + "\n");
            test--;
        }
        bw.flush();

    }

    private static int construction(String line) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int cost = 0;
        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if (map.get(charAt) == null) {
                map.put(charAt, 1);
                cost++;
            }else{
                int qt = map.get(charAt);
                map.put(charAt, ++qt);
            }
           
        }
        return cost;
    }
}
