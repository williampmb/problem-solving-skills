package amazon.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question3 {

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr.add(arr2);
        arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr.add(arr2);
        arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr.add(arr2);
        arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr.add(arr2);

        int h = minimumHours(4, 3, arr);
        System.out.println(h);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int minimumHours(int rows, int columns, List<List<Integer>> grid) {
        int hours = 0;
        Queue<int[]> cur = new LinkedList<>();
        Queue<int[]> next = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    cur.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        if (cur.isEmpty())
            return -1;
        boolean available = false;
        while (!cur.isEmpty()) {
            int[] pos = cur.poll();
            int server = grid.get(pos[0]).get(pos[1]);

            if (server == 1) {
                distributFile(pos[0] - 1, pos[1], rows, columns, next, grid, visited);
                distributFile(pos[0] + 1, pos[1], rows, columns, next, grid, visited);
                distributFile(pos[0], pos[1] - 1, rows, columns, next, grid, visited);
                distributFile(pos[0], pos[1] + 1, rows, columns, next, grid, visited);
                available = true;
            }

            if (cur.isEmpty()) {
                if (!next.isEmpty()) {
                    hours++;
                }
                cur = next;
                next = new LinkedList<>();
            }
        }

        return !available ? -1 : hours;

    }

    private static void distributFile(int i, int j, int rows, int column, Queue<int[]> next, List<List<Integer>> grid,
            boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= column)
            return;
        List<Integer> row = grid.get(i);
        if (!visited[i][j]) {
            next.add(new int[] { i, j });
            row.set(j, 1);
            visited[i][j] = true;
        }
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