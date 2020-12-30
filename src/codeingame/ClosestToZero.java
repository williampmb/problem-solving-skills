package codeingame;

public class ClosestToZero {

    public static void main(String[] args) {

        int[] ts = { -10, -10 };
        System.out.println(computeClosestToZero(ts));
    }

    public static int computeClosestToZero(int[] ts) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        int min = Integer.MAX_VALUE;
        if (ts == null || ts.length == 0)
            return 0;

        for (int i : ts) {
            int minI = Math.abs(i), minAll = Math.abs(min);

            if (minI == minAll && i != min) {
                min = minI;
            } else {
                min = minI < minAll ? i : min;
            }
        }
        return min;
    }
}
