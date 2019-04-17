package leetcode.com.algorithms;

public class MonotonicArray{
    public boolean isMonotonic(int[] A) {
        int s = A.length;
        boolean asc = A[s-1]>=A[0];
        for(int i =0; i <s-1;i++){
            if(asc){
                if(A[i]>A[i+1]) return false;
            }else if(!asc){
                if(A[i]<A[i+1]) return false;
            }
        }
        return true;
    }
}