package amazon.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {

    public static void main(String[] args) {
        int[] a = { 1, 0, 0, 0, 0, 1, 0, 0 };
        cellCompete(a, 1);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days) {
        int n = states.length;
        if (n == 1 && days > 0) {
            List<Integer> myList = new ArrayList<>();
            myList.add(0);
            return myList;
        }
        if (n == 1) {
            List<Integer> myList = new ArrayList<>();
            myList.add(states[0]);
            return myList;
        }
        if (n == 0) {
            List<Integer> myList = new ArrayList<>();
            return myList;
        }

        int[] cur = states;

        int[] ans = new int[n];

        while (days > 0) {
            // calculate the edges
            ans[0] = 0 ^ cur[1];
            ans[n - 1] = 0 ^ cur[n - 2];

            for (int i = 1; i <= n - 2; i++) {
                ans[i] = cur[i - 1] ^ cur[i + 1];
            }

            for (int m = 0; m < n; m++) {
                cur[m] = ans[m];
            }
            days--;
        }
        List<Integer> a = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            a.add(ans[x]);
        }
        return a;
    }
}