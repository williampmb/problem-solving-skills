package leetcode.com.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString {

    public static void main(String[] args) {

        numSplits("aacaba");
    }

    // O(n^2) time complexity
    public static int numSplits2(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            boolean itis = isGoodOne(s.substring(0, i), s.substring(i, s.length()));
            count = itis ? ++count : count;
        }

        return count;
    }

    public static boolean isGoodOne(String s1, String s2) {
        Set<Character> s1Char = new HashSet<>();
        Set<Character> s2Char = new HashSet<>();
        System.out.println(s1 + " - " + s2);
        for (char c : s1.toCharArray()) {
            s1Char.add(c);
        }
        for (char c : s2.toCharArray()) {
            s2Char.add(c);
        }

        return s1Char.size() == s2Char.size();
    }

    // Better solution
    public static int numSplits(String s) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        int size = s.length(), count = 0;

        s1Map.put(s.charAt(0), 1);
        for (int i = 1; i < size; i++) {
            s2Map.put(s.charAt(i), s2Map.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (isSameSize(s1Map, s2Map)) {
            count++;
        }
        for (int i = 1; i < size - 1; i++) {
            char curChar = s.charAt(i);
            moveChar(s2Map, s1Map, curChar);
            if (isSameSize(s1Map, s2Map)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isSameSize(Map m1, Map m2) {
        return m1.keySet().size() == m2.keySet().size();
    }

    public static void moveChar(Map<Character, Integer> from, Map<Character, Integer> to, char c) {
        int times = from.get(c) - 1;
        if (times == 0) {
            from.remove(c);
        } else {
            from.put(c, from.get(c) - 1);
        }
        to.put(c, to.getOrDefault(c, 0) + 1);
    }
}
