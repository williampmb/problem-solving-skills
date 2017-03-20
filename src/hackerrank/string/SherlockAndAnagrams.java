package hackerrank.string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class SherlockAndAnagrams {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (testCase != 0) {
            String line = s.next();
            Map<Character, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < line.length(); i++) {
                char charAt = line.charAt(i);
                if (map.get(charAt) == null) {
                    List<Integer> letArray = new ArrayList<>();
                    letArray.add(i);
                    map.put(charAt, letArray);
                } else {
                    List<Integer> get = map.get(charAt);
                    get.add(i);
                }
            }

           int numb = sherlockAnagramBruteForce( line);
           
            sb.append( numb+"\n");
            testCase--;
        }
        System.out.print(sb.toString());
    }

    private static int sherlockAnagramBruteForce(String word) {
        Set<String> co = new HashSet<>();
        int count =0;
        for (int i = word.length() - 1; i > 0; i--) {
            for (int j = 0; j + i < word.length(); j++) {
                String s1 = word.substring(j,j+i);
                int[] histS1 = calculateHistogram(s1);
                for(int x = j+1; x+i<word.length()+1; x++){
                    String s2 = word.substring(x,x+i);
                    int[] histS2 = calculateHistogram(s2);
                    if(isAnagram(histS1, histS2)){
                        co.add(j+""+(j+i+1)+""+x+""+(x+i+1));
                        count++;
                    }
                }

            }
        }
       
        return count;
    }

  
    private static int[] calculateHistogram(String s) {
        int[] histS1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            histS1[s.charAt(i) - 97]++;
        }
        return histS1;
    }

    private static boolean isAnagram(int[] s1, int[] s2) {

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void print(Set<String> s) {

        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }
    }
}
