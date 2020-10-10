package leetcode.com.algorithms;

public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets(String s) {
        int size = s.length();
        char fir = 0, sec = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char thi = s.charAt(i);
            if (thi == '#') {
                ans.append(mapDigToChar(false, fir, sec));
                fir = 0;
                sec = 0;
            } else {
                if (fir != 0 && sec != 0) {
                    ans.append(mapDigToChar(true, fir, '0'));
                }
                fir = sec;
                sec = thi;
            }
        }

        if (fir != 0) {
            ans.append(mapDigToChar(true, fir, '0'));
        }

        if (sec != 0) {
            ans.append(mapDigToChar(true, sec, '0'));
        }

        return ans.toString();

    }

    public char mapDigToChar(boolean simple, char dig, char dig2) {
        return simple ? (char) (dig + 48) : (char) ('j' + Integer.parseInt(new String(dig + "" + dig2)) - 10);
    }
}
