package hackerrank.string;


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
public class MarsExploration {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String message = s.nextLine();
        int count =0;

        for (int i = 0; i < message.length(); i = i + 3) {
            if (message.charAt(i) != 'S') {
                count++;
            }
            if (message.charAt(i + 1) != 'O') {
                count++;
            }
            if (message.charAt(i + 2) != 'S') {
                count++;
            }
        }
        System.out.println(count);
    }
}
