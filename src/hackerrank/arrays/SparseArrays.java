package hackerrank.arrays;


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
public class SparseArrays {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numbWord = s.nextInt();
        Dictionary dic = new Dictionary();
        StringBuilder sb = new StringBuilder();
        while (numbWord != 0) {
            dic.addWord(s.next());
            numbWord--;
        }
        numbWord = s.nextInt();
        while (numbWord != 0) {
            int times = dic.findWord(s.next());
            sb.append(times + "\n");
            numbWord--;
        }
        System.out.println(sb.toString());
    }

    public static class Dictionary {

        Dictionary[] letter;
        int word;

        public Dictionary() {
            letter = new Dictionary[26];
            word = 0;
        }

        public void addWord(String w) {
            if (w.length() == 0) {
                word++;
            } else {
                int chatAt = w.charAt(0);
                if (letter[chatAt - 97] == null) {
                    letter[chatAt - 97] = new Dictionary();
                }
                letter[chatAt - 97].addWord(w.substring(1));
            }
        }

        public int findWord(String w) {
            if (w == null) {
                return 0;
            } else if (w.length() == 0) {
                return word;
            } else {
                int c = w.charAt(0);
                if (letter[c - 97] == null) {
                    return 0;
                }
                return letter[c - 97].findWord(w.substring(1));
            }
        }
    }
}
