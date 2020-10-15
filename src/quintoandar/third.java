package quintoandar;

import java.util.Arrays;

public class third {

    public static void main(String[] args) {

        int[] arr = new int[] { 10 };

        System.out.println(solution(arr));
    }

    // How far can I park my bike
    public static int solution(int[] A) {
        // Using quicksort takes O(n*logn) time complexity to sort
        Arrays.sort(A);

        int maxDist = 0;

        // betweem two consecutives rack. How far I can park my bike
        for (int i = 1; i < A.length; i++) {
            int dist = (A[i] - A[i - 1]) / 2;
            maxDist = Math.max(dist, maxDist);

        }

        return maxDist;
    }
}
