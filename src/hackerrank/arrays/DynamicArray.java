package hackerrank.arrays;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willi
 */
public class DynamicArray {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        //Scanner s = new Scanner(new FileReader("src/input.txt"));
        int seq = s.nextInt();
        int query = s.nextInt();
        int lastAns = 0;
        StringBuilder sb = new StringBuilder();
        Sequence[] seqs = new Sequence[seq];
        for (int i = 0; i < seq; i++) {
            seqs[i] = new Sequence(seq);
        }
        while (query != 0) {
            int type = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            int findSeq = ((x ^ lastAns) % seq);

            if (type == 1) {
                seqs[findSeq].append(y);
            } else {
                int get = seqs[findSeq].get(y);
                lastAns = get;
                sb.append(lastAns + "\n");
            }
            query--;
        }
        System.out.println(sb.toString());
    }

    public static class Sequence {

        int maxSize;
        int[] seq;
        int pos;

        Sequence(int s) {
            this.maxSize = s;
            seq = new int[100];
            pos = 0;
        }

        public void append(int value) {
            if (pos == seq.length) {
                seq = growSeq(seq);
            }
            seq[pos] = value;
            pos++;
        }

        public int get(int pos) {
            return seq[pos % this.pos];
        }

        private int[] growSeq(int[] seq) {
            int size = 2 * seq.length > maxSize ? maxSize : 2 * seq.length;
            int[] grown = new int[size];
            for (int i = 0; i < seq.length; i++) {
                grown[i] = seq[i];
            }
            return grown;
        }
    }
}
