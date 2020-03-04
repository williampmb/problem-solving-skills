package amazon.interview;

import java.util.ArrayList;
import java.util.List;

public class Question4 {

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(1);
        arr2.add(0);
        arr2.add(0);
        arr.add(arr2);
        arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr.add(arr2);
        arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(1);
        arr2.add(1);
        arr.add(arr2);
        arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr.add(arr2);

        numberAmazonTreasureTrucks(4, 4, arr);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
        int ttpu = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                int ele = grid.get(i).get(j);
                boolean up = visited(i - 1, j, rows, column, grid);
                boolean left = visited(i, j - 1, rows, column, grid);
                boolean right = visited(i, j + 1, rows, column, grid);
                boolean down = visited(i + 1, j, rows, column, grid);

                if (!up && !left && !right && !down && ele == 1) {
                    ttpu++;
                    List<Integer> row = grid.get(i);
                    row.set(i, -1);
                } else if (ele == 1) {
                    List<Integer> row = grid.get(i);
                    row.set(i, -1);
                }

            }
        }

        return ttpu;

    }

    public static boolean outOfBounds(int i, int j, int x, int y) {
        if (i < 0 || i >= x || j < 0 || j >= y)
            return true;
        return false;
    }

    public static boolean visited(int i, int j, int rows, int column, List<List<Integer>> grid) {
        if (outOfBounds(i, j, rows, column)) {
            return false;
        }
        if (grid.get(i).get(j) == -1) {
            return true;
        }

        return false;
    }
    // METHOD SIGNATURE ENDS
}