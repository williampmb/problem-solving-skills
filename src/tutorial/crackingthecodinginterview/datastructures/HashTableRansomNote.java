package tutorial.crackingthecodinginterview.datastructures;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
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
public class HashTableRansomNote {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int wordsInMaganize = s.nextInt();
        int wordsInRansom = s.nextInt();
        String[] magazine = new String[wordsInMaganize];
        String[] ransom = new String[wordsInRansom];

        for (int i = 0; i < wordsInMaganize; i++) {
            String word = s.next();
            magazine[i] = word;
        }
        for (int i = 0; i < wordsInRansom; i++) {
            String word = s.next();
            ransom[i] = word;
        }

        String untraceable = untraceableNote(magazine, ransom);
        System.out.println(untraceable);
    }

    private static String untraceableNote(String[] magazine, String[] ransom) {
        Hashtable<String, Integer> ht = new Hashtable<>();

        for (String s : magazine) {
            if (ht.get(s) == null) {
                ht.put(s, 1);
            } else {
                Integer times = ht.get(s);
                ht.put(s, ++times);
            }
        }

        for (String s : ransom) {
            if (ht.get(s) == null) {
                return "No";
            } else {
                Integer times = ht.get(s);
                if (times < 1) {
                    return "No";
                }
                ht.put(s, --times);
            }
        }
        return "Yes";
    }


}
