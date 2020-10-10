package leetcode.com.algorithms;

public class BulbSwitcherIV {
    public int minFlips(String target) {
        boolean flipped = false;
        int count = 0;
        char[] targetChars = target.toCharArray();
        for (char c : targetChars) {

            if (c != isFlipped(flipped)) {
                count++;
                flipped = !flipped;
            }
        }

        return count;
    }

    public char isFlipped(boolean flipped) {
        return flipped ? '1' : '0';
    }
}
