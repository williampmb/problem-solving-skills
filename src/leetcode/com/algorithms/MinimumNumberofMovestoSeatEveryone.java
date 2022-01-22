package leetcode.com.algorithms;

import java.util.Arrays;

public class MinimumNumberofMovestoSeatEveryone {

    public int minMovesToSeat(int[] seats, int[] students) {
        int moves = 0;

        Arrays.sort(seats);
        Arrays.sort(students);

        int n = seats.length;
        for (int i = 0; i < n; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}
