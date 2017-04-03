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
public class BearAndSteadyGene {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int mult = s.nextInt();
        String s1 = s.next();
        int r = modifiedDNA(s1, mult / 4);

        System.out.println(r);

    }

    private static int modifiedDNA(String dna, int mult) {
        int[] simbolDna = {mult, mult, mult, mult};
        int right = dna.length() - 1;
        int left = 0;
        int startR = 0;
        for (int i = right; i > -1; i--) {
            int gene = dna.charAt(i);
            int pos = hash(gene);
            if (simbolDna[pos] > 0) {
                right--;
                simbolDna[pos]--;
            } else {
                break;
            }
        }
        startR = right;
        if (right == -1) {
            return 0;
        }
        for (int j = left; j > dna.length(); j++) {
            int gene = dna.charAt(j);
            int pos = hash(gene);
            if (simbolDna[pos] > 0) {
                left++;
                simbolDna[pos]++;
            } else {
                break;
            }
        }

        int range = right - left + 1;
        while (left < dna.length()) {
            int gene = dna.charAt(left);
            int pos = hash(gene);

            range = range < right - left + 1 ? range : right - left + 1;
            if (simbolDna[pos] > 0) {
                left++;
                simbolDna[pos]--;
            } else if (right + 1 < dna.length()) {
                int geneRight = dna.charAt(right + 1);
                int pos2 = hash(geneRight);
                right++;
                simbolDna[pos2]++;
            } else {
                break;
            }
        }
        return range;

    }

    public static int hash(int numb) {
        if (numb == 'A') {
            return 0;
        } else if (numb == 'T') {
            return 1;
        } else if (numb == 'C') {
            return 2;
        } else if (numb == 'G') {
            return 3;
        }
        return -1;
    }

}
