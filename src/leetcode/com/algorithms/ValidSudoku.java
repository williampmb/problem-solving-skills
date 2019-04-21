package leetcode.com.algorithms;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] gridSet = new HashSet[9];
        //(row/3)*3 + (col/3);
       

        for(int i = 0 ; i <9;i++){
            for(int j = 0; j<9;j++){
                char c = board[i][j];
                int gridLoc = (i/3)*3 + (j/3);
                if(rowSet[i].contains(c) || colSet[j].contains(c) || gridSet[gridLoc].contains(c)){
                    return false;
                }
                rowSet[i].add(c);
                colSet[j].add(c);
                gridSet[gridLoc].add(c);
            }
        }

        return true;
    }
}