/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author William Barbosa
 */
public class OnesAndZeroes {

    public static void main(String[] args) {
        OnesAndZeroes o = new OnesAndZeroes();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        //String[] strs = {"10", "0", "1"};
        int findMaxForm = o.findMaxForm(strs, 5, 3);
        System.out.println(findMaxForm);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        //invalid input. No need for this question but let's put anyway
        if (strs == null || strs.length == 0 || m < 0 || n < 0) {
            return 0;
        }

        //building a mxn matrix to count how many string we can have in dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        //saving the 1's and 0's from the string in case there is a repeated str
        Map<String, int[]> countZerosOnes = new Hashtable<>();

        // for each string, let's count 1's and 0's to fill the dp and "use" 
        // up to m0's and n1's.
        for (String s : strs) {
            int ones = 0, zeros = 0;
            //in case, it already saw the string s, it doesn't need to count again.
            if (countZerosOnes.containsKey(s)) {
                int[] get = countZerosOnes.get(s);
                ones = get[1];
                zeros = get[0];
            } else {
                for (char c : s.toCharArray()) {
                    if (c == '1') {
                        ones++;
                    } else {
                        zeros++;
                    }
                }
                countZerosOnes.put(s, new int[]{zeros, ones});
            }

            /* Fill the matrix backwards, otherwise it would count the same string
            * more than one time. i.e.: Let's suppose it iterates forward from
            * 1 to m "10", it would fill first dp[1][1]. However, When it gets to 
            * dp[2][2] = 1+ d[2-1][2-1] = 1 + d[1][1] = 1 + 1. But it already
            * filled d[1][1] with this string. So it would count twice.
             */
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

}
