package leetcode.com.algorithms;

public class ShuffleString {

    public static String retosreString(String s, int[] indices) {
        int length = indices.length;
        char[] ans = new char[length];

        for (int i = 0; i < length; i++) {
            ans[indices[i]] = s.charAt(i);
        }
        return new String(ans);
    }
}
