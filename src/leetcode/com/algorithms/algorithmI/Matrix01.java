package leetcode.com.algorithms.algorithmI;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public static void main(String[] args){

        int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        updateMatrix(mat);

    }

    // TODO: IMPLEMENT A DP APPROACH - faster
    // BFS APPROACH
    public static int[][] updateMatrix(int[][] mat) {

        Queue<int[]> toVisit = new LinkedList<>();
        int[][] minDist = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                minDist[i][j] =Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    minDist[i][j] = 0;
                    toVisit.add(new int[] { i, j });
                }
            }
        }

        while (!toVisit.isEmpty()) {
            int[] loc = toVisit.poll();
            int x = loc[0];
            int y = loc[1];

            if (!inBoundary(minDist, x, y) || mat[x][y] < 0) {
                continue;
            }

            addToQueue(minDist, x - 1, y, toVisit, mat);
            addToQueue(minDist, x + 1, y, toVisit, mat);
            addToQueue(minDist, x, y - 1, toVisit, mat);
            addToQueue(minDist, x, y + 1, toVisit, mat);

            if (minDist[x][y] == 0) {
                continue;
            }

            int top = absValueAt(minDist, x - 1, y);
            int bot = absValueAt(minDist, x + 1, y);
            int lef = absValueAt(minDist, x, y - 1);
            int rig = absValueAt(minDist, x, y + 1);

            minDist[x][y] = Math.min(Math.min(lef,rig),Math.min(top, bot))+1;
            mat[x][y] *=-1;
        }


        return mat;
    }

    public static void addToQueue(int[][] mat, int x, int y, Queue<int[]> queue , int[][] source) {
        if (x >= mat.length || x < 0 || y >= mat[0].length || y < 0 || source[x][y] <0) {
            return;
        }
        queue.add(new int[] { x, y });
    }

    public static boolean inBoundary(int[][] mat, int x, int y) {
        if (x >= mat.length || x < 0 || y >= mat[0].length || y < 0) {
            return false;
        }
        return true;
    }

    public static int absValueAt(int[][] mat, int x, int y) {
        if (x >= mat.length || x < 0 || y >= mat[0].length || y < 0) {
            return Integer.MAX_VALUE;
        }
        return mat[x][y];
    }
}
