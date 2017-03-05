package hackerrank.bitmanipulatio;


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
public class SumVsXor {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        int count = 0;
        BigInteger numb = new BigInteger(n);
        for (int i = 0; i < numb.bitLength(); i++) {
            BigInteger comp = new BigInteger("1");
            comp = comp.shiftLeft(i);
            if (numb.and(comp).toString(2).equals("0")) {
                count++;
            }
        }
        BigInteger base = new BigInteger(2 + "");
        BigInteger answer = new BigInteger(base.pow(count).toString());
        System.out.println(answer);

    }
}
