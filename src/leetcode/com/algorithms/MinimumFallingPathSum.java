package leetcode.com.algorithms;

public class MinimumFallingPathSum{
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        for(int i = 1; i<n;i++){
            for(int j =0; j<n;j++){
                int min=0;
                if(j==0){
                    min = Math.min(A[i-1][j],A[i-1][j+1]);
                }else if(j==n-1){
                    min = Math.min(A[i-1][j-1],A[i-1][j]);
                }else{
                    min = Math.min(A[i-1][j-1],A[i-1][j]);
                    min = Math.min(min,A[i-1][j+1]);
                }
                A[i][j] +=min;
            }
        }
        
        int min = A[n-1][0];
        for(int i =1 ; i<n;i++){
            if(min>A[n-1][i]){
                min = A[n-1][i];
            }
        }
        return min;
    }
}