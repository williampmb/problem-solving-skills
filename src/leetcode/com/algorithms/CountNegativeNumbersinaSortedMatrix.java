package leetcode.com.algorithms;

public class CountNegativeNumbersinaSortedMatrix {

    public static void main(String[] args) {

        // int[][] grid = new int[][] { { 2, 2, 2, 2 }, { -1, -1, -4 }, };
        int[][] grid = new int[][] { { 4, 3, 1 }, { 3, 2, -1, -2 }, { -1, -1, -2, -3 }, };
        // } };
        int numb = countNegatives(grid);
        System.out.println(numb);
    }

    static public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int negatives = 0, pos = 0;
        for (int i = 0; i < rows; i++) {

            negatives += countNegativesRow(grid[i]);

        }
        return negatives;
    }

    static public int countNegativesRow(int[] arr) {
        int start = 0, size = arr.length;
        int end = size - 1, mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] > 0) {
                start = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] > 0) {
                    break;
                } else {
                    end = mid;
                }
            }
        }
        if (mid >= size || arr[mid] > 0) {
            return 0;
        }
        return size - mid;
    }
}

/*
 * [4, 3, 2,-1] 1 4 [3, 2, 1,-1] 1 2 [1, 1,-1,-2] 2 1 [-1,-1,-2,-3] 4 1
 * 
 * 
 * 
 * 
 * 
 */