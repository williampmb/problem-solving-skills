/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microsoft.event.cTSx59;

import java.util.Scanner;

/**
 *
 * @author William
 */
public class FindAPath {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (test != 0) {
            int lookFor = s.nextInt();
            int rows = s.nextInt();
            int cols = s.nextInt();

            int[][] mat = new int[rows][cols];
            int[][] visit = new int[rows][cols];

            int startx = 0, starty = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = s.nextInt();
                    if (mat[i][j] == 1) {
                        startx = i;
                        starty = j;
                    }
                }
            }

            boolean path = findPath(mat, lookFor, visit, startx, starty);
            sb.append(path);
            if (test != 1) {
                sb.append("\n");

            }
            test--;
        }
        System.out.println(sb.toString());
    }

    private static boolean findPath(int[][] mat, int look, int[][] visit, int startx, int starty) {
        int at = 1;
        boolean path = true;
        while (path) {
            if (startx + 1 < mat.length && mat[startx + 1][starty] == at + 1) {
                // if (mat[startx + 1][starty] == at + 1) {
                if (visit[startx + 1][starty] == 1) {
                    return false;
                }
                visit[startx + 1][starty] = 1;
                startx += 1;
                at++;
                //  }
            } else if (starty + 1 < mat[0].length && mat[startx][starty + 1] == at + 1) {
                //   if (mat[startx][starty + 1] == at + 1) {
                if (visit[startx][starty + 1] == 1) {
                    return false;
                }
                visit[startx][starty + 1] = 1;
                starty += 1;
                at++;
                //  }
            } else if (startx - 1 > -1 && mat[startx - 1][starty] == at + 1) {
                //if (mat[startx - 1][starty] == at + 1) {
                if (visit[startx - 1][starty] == 1) {
                    return false;
                }
                visit[startx - 1][starty] = 1;
                startx -= 1;
                at++;
                //   }

            } else if (starty - 1 > -1 && mat[startx][starty - 1] == at + 1) {
                //       if (mat[startx][starty - 1] == at + 1) {
                if (visit[startx][starty - 1] == 1) {
                    return false;
                }
                visit[startx][starty - 1] = 1;
                starty -= 1;
                at++;
                //   }
            } else {
                return false;
            }

            if (at == look) {
                return true;
            }
        }
        return false;
    }

}
