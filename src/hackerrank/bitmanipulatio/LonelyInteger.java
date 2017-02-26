package hackerrank.bitmanipulatio;


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
public class LonelyInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        String strArrayLine = br.readLine();
        String[] arrayStr = strArrayLine.split(" ");

        bw.write(lonelyInteger(arrayStr) + "\n");
        bw.flush();
    }

    private static int lonelyInteger(String[] a) {
        int lonely = 0;
        for (String i : a) {
            lonely ^= Integer.valueOf(i);
        }
        return lonely;
    }

}
