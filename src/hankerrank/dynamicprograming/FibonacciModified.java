package hankerrank.dynamicprograming;


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
public class FibonacciModified {

    public static void main(String[] args) throws ArithmeticException {
        Scanner s = new Scanner(System.in);
        int intT1 = s.nextInt();
        int intT2 = s.nextInt();
        int n = s.nextInt();
        n-=2;
        int count = 0;
        BigInteger t3 = new BigInteger("0");
        BigInteger t1 = new BigInteger(intT1 + "");
        BigInteger t2 = new BigInteger(intT2 + "");
        BigInteger aux2 = new BigInteger("0");
        while (count != n) {
            t3 = aux2.add(t1);
            t1 = t2;
            t3 = t3.add(t2.pow(2));
            t2 = t3;
            count++;
        }
        System.out.println(t3.toString(10));
    }
}
