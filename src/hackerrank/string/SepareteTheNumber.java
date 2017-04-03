package hackerrank.string;


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
public class SepareteTheNumber {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (test != 0) {
            String word = s.next();
            String res = separeteNumbers(word);
            sb.append(res + "\n");
            test--;
        }

        System.out.print(sb.toString());
    }

    private static String separeteNumbers(String word) {
        if (word.length() < 2 || word.charAt(0) == '0') {
            return "NO";
        }
        String serie = "";

        for (int i = 0; i < word.length(); i++) {
            serie += word.charAt(i);
            if (serie.length() > word.length() + 1 - i) {
                return "NO";
            }
            BigInteger value = new BigInteger(serie);
            BigInteger one = new BigInteger("1");
            BigInteger next = value.add(one);
            boolean hasSerie = findSerie(next, i + 1, word);
            if (hasSerie) {
                if (i == word.length() - 1) {
                    return "NO";
                }
                return "YES " + serie;
            }
        }
        return "NO";
    }

    private static boolean findSerie(BigInteger look, int pos, String word) {
        if (pos == word.length()) {
            return true;
        }
        if (word.charAt(pos) == '0') {
            return false;
        }
        String find = "";

        for (int j = pos; j < word.length(); j++) {
            find += word.charAt(j);
            BigInteger v = new BigInteger(find);
            BigInteger one = new BigInteger("1");
            BigInteger next = v.add(one);
            if (look.compareTo(v) == 0) {

                return findSerie(next, j + 1, word);
            } else if (look.compareTo(v) == -1) {
                return false;
            }
        }

        return false;
    }
}
