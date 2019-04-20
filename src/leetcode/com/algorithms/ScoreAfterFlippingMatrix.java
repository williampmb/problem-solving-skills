package leetcode.com.algorithms;

public class ScoreAfterFlippingMatrix{

    public static void main(String[] args){
        int[][] input = {{1,1},{1,1},{0,1}};
        //int[][] input = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int matrixScore = matrixScore(input);
        System.out.println(matrixScore);
    }

    public static int matrixScore(int[][] A) {
        int rows = A.length, cols = A[0].length;
        int[] ones = new int[cols];
        for(int i = 0; i < rows; i++){
            if(A[i][0]==0){
                for(int j = 0 ; j < cols;j++){
                    A[i][j] = (A[i][j]+1)%2;
                    ones[j] += A[i][j];
                }
            }else{
                for(int j = 0 ; j < cols;j++){
                    ones[j] += A[i][j];
                }
            }
        }

        for(int i =0; i < cols; i++){
            if(ones[i]<=rows/2){
                ones[i]=0;
                for(int j = 0; j<rows; j++){
                    A[j][i]= (A[j][i]+1)%2;
                    ones[i]+=A[j][i];
                }
            }
        }

        int ans =0;
        for(int i=0;i<rows;i++){
            for(int j = 0 ; j < cols;j++){
                ans+= A[i][j] * Math.pow(2,cols-1-j);
            }
        }
        return ans;
    }
}