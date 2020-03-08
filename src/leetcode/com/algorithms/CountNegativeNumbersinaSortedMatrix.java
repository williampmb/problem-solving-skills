package leetcode.com.algorithms;

public class CountNegativeNumbersinaSortedMatrix {

    public static void main(String[] args) {

        // int[][] grid = new int[][] { { 2, 2, 2, -4 }, { -1, -1, -4, -4 }, };
        // int[][] grid = new int[][] { { 4, 3, 1 }, { -1, -1, -2 }, { -1, -1, -2 }, };
        int[][] grid = new int[][] { {}, };
        int numb = countNegatives(grid);
        System.out.println(numb);
    }

    static public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int negatives = 0, pos = cols - 1;
        int posMaxNegativeNumber = pos;
        for (int i = 0; i < rows; i++) {

            pos = countNegativesRow(grid[i], pos);
            if (pos == -1) {
                pos = posMaxNegativeNumber;
                negatives += cols - 1 - pos;
            } else {
                posMaxNegativeNumber = pos;
                negatives += cols - pos;
                pos = pos > 0 ? pos-- : pos;
            }

        }
        return negatives;
    }

    static public int countNegativesRow(int[] arr, int lastEnd) {
        int start = 0, end = lastEnd, mid = 0;
        int numbPos = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] >= 0) {
                start = mid + 1;
            } else {
                numbPos = mid;
                end = mid - 1;
            }
        }
        return numbPos;
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