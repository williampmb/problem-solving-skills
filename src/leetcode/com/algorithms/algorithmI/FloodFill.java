package leetcode.com.algorithms.algorithmI;


public class FloodFill {

    public static void main(String[] args){

        int[][] m = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr =1;int sc = 1; int newColor =2;

        floodFill(m, sr, sc, newColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor){
            floodNeighborhood(image,newColor,sr,sc,image[sr][sc]);
        }

        return image;    
    }

    public static void floodNeighborhood(int[][] terrain, int flooded, int i, int j, int target){
       
        if(i >= terrain.length || j >= terrain[0].length || i<0 || j<0 || terrain[i][j] != target ){
            return;
        }

        terrain[i][j]=flooded;

        floodNeighborhood(terrain,flooded,i+1,j,target);
        floodNeighborhood(terrain,flooded,i-1,j,target);
        floodNeighborhood(terrain,flooded,i,j+1,target);
        floodNeighborhood(terrain,flooded,i,j-1,target);
    }
}
