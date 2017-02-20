package hackrank.bitmanipulatio;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
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
public class CounterGame {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("src/input.txt"));
       // Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = sc.nextInt();
        while (t != 0) {
            BigInteger nextBigInteger = sc.nextBigInteger();
            String winner = ctGame(nextBigInteger);
            bw.write(winner + "\n");
            t--;
        }
        bw.flush();
    }

    public static String ctGame(BigInteger bi) {
        bi = bi.subtract(new BigInteger("1"));
        int bits = bi.bitCount();
        if (bits % 2 == 0) {
            return "Richard";
        } else {
            return "Louise";
        }
    }

}
