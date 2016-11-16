package uri.timelimitexceeded;


import java.io.FileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class GrowinStrings_1141_AhoCarosickAlg {

    private static int MAX_ALPHABET = 26;
    private static int FAIL = -1;
    private static int[] out;
    private static int[] f;
    private static int[][] g;
    private static Map storeSeq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/uri/timelimitexceeded/input_1141.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringBuilder result = new StringBuilder();
        int numWords, totalStates, biggestSequence;
        String[] dictionary;

        input = br.readLine();
        numWords = Integer.valueOf(input);

        while (numWords != 0) {
            dictionary = new String[numWords];
            totalStates = 0;
            storeSeq = new HashMap<String, Integer>();

            for (int i = 0; i < numWords; i++) {
                dictionary[i] = br.readLine();
                totalStates += dictionary[i].length();
            }
            totalStates += 1;
            biggestSequence = ahoCorasickAlgoritm(dictionary, totalStates);
            result.append(biggestSequence + "\n");
            numWords = Integer.valueOf(br.readLine());
        }

        bw.write(result.toString());
        bw.flush();
    }

    private static int ahoCorasickAlgoritm(String[] dictionary, int totalStates) {
        g = new int[totalStates][MAX_ALPHABET];
        f = new int[totalStates];
        out = new int[totalStates];
        java.util.Arrays.fill(out, 0);
        java.util.Arrays.fill(f, -1);
        for (int[] row : g) {
            java.util.Arrays.fill(row, FAIL);
        }

        int biggestSequence = 0;

        buildGotoFunction(dictionary);
        buildFailureFunction();
        int sequence;
        for (String word : dictionary) {
            if (storeSeq.get(word) == null) {
                sequence = patternMatchingMachine(word, dictionary);
            } else {
                sequence = (int) storeSeq.get(word);
            }

            if (biggestSequence < sequence) {
                biggestSequence = sequence;
            }
        }

        return biggestSequence;
    }

    private static void buildGotoFunction(String[] dictionary) {
        int newState = 0;

        for (int i = 0; i < dictionary.length; i++) {
            newState = enter(dictionary[i], newState, i);
        }
        for (int i = 0; i < MAX_ALPHABET; i++) {
            if (g[0][i] == FAIL) {
                g[0][i] = 0;
            }
        }
    }

    private static int enter(String word, int newState, int posWord) {
        int state = 0;
        int j = 0;
        int aj = word.charAt(j) - 97;
        boolean wordIncluded = false;
        while (g[state][aj] != FAIL) {
            j++;
            state = g[state][aj];
            if (word.length() == j) {
                j--;
                wordIncluded = true;
                break;
            }
            aj = word.charAt(j) - 97;
        }

        if (wordIncluded) {

        } else {
            for (int p = j; p < word.length(); p++) {
                newState++;
                int ap = word.charAt(p) - 97;
                g[state][ap] = newState;
                state = newState;
            }
        }

        out[state] |= (1 << posWord);

        return newState;
    }

    private static void buildFailureFunction() {
        Queue<Integer> queue = new LinkedList<Integer>();
        int s, state;
        for (int i = 0; i < MAX_ALPHABET; i++) {
            if (g[0][i] != 0) {
                s = g[0][i];
                queue.add(s);
                f[s] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int r = queue.poll();
            for (int i = 0; i < MAX_ALPHABET; i++) {
                s = g[r][i];
                if (s != -1) {
                    queue.add(s);
                    state = f[r];
                    while (g[state][i] == -1) {
                        state = f[state];
                    }
                    f[s] = g[state][i];
                    out[s] |= out[f[s]];
                }
            }
        }
    }

    private static int patternMatchingMachine(String input, String[] dic) {
        int state = 0;
        int longestSequence = 0;
        int seqDicj;
       
        
        if (storeSeq.get(input) == null) {
            for (int i = 0; i < input.length(); i++) {

                while (g[state][input.charAt(i) - 97] == -1) {
                    state = f[state];
                }
                int ai = input.charAt(i) - 97;
                state = g[state][ai];

                if (out[state] != 0) {
                    for (int j = 0; j < dic.length; j++) {
                        //DIC.LENGHT should be up to 32 or it will break
                        int a = out[state] & (1 << j);
                        if (a != 0) {
                            if (!dic[j].equals(input)) {
                                if (storeSeq.get(dic[j]) != null) {
                                    seqDicj = (int) storeSeq.get(dic[j]);
                                } else {
                                    seqDicj = patternMatchingMachine(dic[j], dic);
                                    storeSeq.put(dic[j], seqDicj);
                                }

                                if (longestSequence < seqDicj) {
                                    longestSequence = seqDicj;
                                }
                            } else {
                                longestSequence += 1;

                                storeSeq.put(dic[j], longestSequence);
                            }
                        }
                    }
                }
            }
            storeSeq.put(input, longestSequence);
        } else {
            longestSequence = (int) storeSeq.get(input);
        }

        return longestSequence;

    }
}
