package leetcode.com.algorithms;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int[] sarr = new int[26];
        for (char c : s.toCharArray()) {
            sarr[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            sarr[c - 'a'] -= 1;
        }
        int changes = 0;
        for (int i : sarr) {
            changes += Math.abs(i);
        }
        return changes / 2;
    }
}