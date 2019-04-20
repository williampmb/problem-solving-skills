package leetcode.com.algorithms;

public class DeleteColumnsToMakeSorted{
    public int minDeletionSize(String[] A) {
        int cols= A[0].length(), words = A.length, count =0;
        for(int i =0 ; i < cols;i++){
            for(int j = 0 ; j < words-1;j++){
                if(A[j].charAt(i)>A[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}