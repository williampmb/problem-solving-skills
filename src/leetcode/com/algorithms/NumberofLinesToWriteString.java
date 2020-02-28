package leetcode.com.algorithms;

public class NumberofLinesToWriteString {

    public int[] numberOfLines(int[] widths, String S) {
        int numb = 0, lines = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            numb += widths[c - 97];
            if (numb > 100) {
                lines++;
                numb = widths[c - 97];
            }
        }

        int[] ans = new int[2];
        ans[1] = numb;
        ans[0] = numb > 0 ? lines + 1 : lines;
        return ans;
    }

}
