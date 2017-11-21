/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class IslandPerimeter {
    public static void main(String[] args){
        int[][] a = {{1,0}};
        IslandPerimeter i = new IslandPerimeter();
        i.islandPerimeter(a);
    }
    
    //Iterate over every cell and check where it has a perimeter of it is just
    // a part of the island
    public int islandPerimeter(int[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        int perimeter =0;
        for(int i =0 ; i <row;i++){
            for(int j = 0 ; j < col; j++){
                if(grid[i][j]==1){
                    if(i-1 <0 || grid[i-1][j]==0) perimeter++;
                    if(i+1 > row-1 || grid[i+1][j]==0) perimeter++;
                    if(j-1 <0 || grid[i][j-1]==0) perimeter++;
                    if(j+1 > col-1 || grid[i][j+1]==0) perimeter++;
                }
            }
        }
        return perimeter;
    }
    
    //Author: liupangzi at leetcode
    // Clever solution. It counts how many cells it is the island and remove
    // every part that shares with another neighbour. However, it has the same
    // complexity.
    public int islandPerimeter2(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
