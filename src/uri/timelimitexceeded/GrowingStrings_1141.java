package uri.timelimitexceeded;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class GrowingStrings_1141 {

    // TODO: colocar as sequencias calculadas numa hashmap para nao ter que calcular de novo
    //http://blog.ivank.net/aho-corasick-algorithm-in-as3.html implement aho-corasick to search on strings
    static HashMap<String, Integer> sequences = new HashMap<String, Integer>();

    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        String[] pics;
        int size, newSeqSize;
        boolean has = false;

        int lines = Integer.valueOf(input);
        while (lines != 0) {
            pics = new String[lines];
            size = 1;
            for (int i = 0; i < lines; i++) {
                input = br.readLine();
                pics[i] = input;
            }

            for (int i = 0; i < lines; i++) {
                has = sequences.containsKey(pics[i]);
                if (has) {
                    newSeqSize = (int) sequences.get(pics[i]);
                } else {
                    newSeqSize = seqSub(pics[i], pics);
                }

                if (size < newSeqSize) {
                    size = newSeqSize;
                }
            }

            input = br.readLine();
            lines = Integer.valueOf(input);
            result.append(size + "\n");
        }
        bw.write(result.toString());
        bw.flush();
    }

    private static int seqSub(String pic, String[] pics) {
        int size, newSeqSize;
        size = 0;
        newSeqSize = 0;
        boolean has = false;
        for (String word : pics) {
            if (word.length() <= pic.length()) {
                continue;
            }
            if (isSubString(pic, word)) {
                has = sequences.containsKey(word);
                if (has) {
                    newSeqSize = (int) sequences.get(word);
                } else {
                    newSeqSize = seqSub(word, pics);
                    has = sequences.containsKey(word);
                    if (has) {
                        int a = (int) sequences.get(word);
                        if (a < newSeqSize) {
                            sequences.put(word, newSeqSize);
                        }
                    } else {
                        sequences.put(word, newSeqSize);

                    }

                }

                if (size <= newSeqSize) {
                    size = newSeqSize;
                }
            }
        }
        size++;
        if (!has) {
            sequences.put(pic, size);
        }
        return size;
    }

    private static boolean isSubString(String pic, String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if ((int) letter == (int) pic.charAt(0)) {
                if (pic.length() <= word.length() - i) {
                    if (pic.length() == 1) {
                        return true;
                    }

                    for (int j = 1; j < pic.length(); j++) {
                        if ((int) pic.charAt(j) != (int) word.charAt(i + j)) {
                            break;
                        }
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
