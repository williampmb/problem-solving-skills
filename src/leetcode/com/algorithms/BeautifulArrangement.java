/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class BeautifulArrangement {

    public static void main(String[] args) {
        BeautifulArrangement b = new BeautifulArrangement();
        int countArrangement = b.countArrangement(3);
        System.out.println(countArrangement);

    }

    public int countArrangement(int N) {
        boolean[] used = new boolean[N + 1];
        return backtrack(N, 1, used);
    }

    private int backtrack(int N, int pos, boolean[] used) {
        int ans = 0;
        if (pos > N) {
            ans = 1;
        } else {
            for (int i = 1; i < used.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i % pos == 0 || pos % i == 0) {
                    used[i] = true;
                    ans += backtrack(N, pos + 1, used);
                    used[i] = false;
                }
            }
        }
        return ans;
    }
}
