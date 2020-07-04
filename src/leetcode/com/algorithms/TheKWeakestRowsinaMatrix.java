package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class TheKWeakestRowsinaMatrix {

    public static void main(String[] args){
        int[][] mat = {{1,0},{1,0},{1,0},{1,1}};
        kWeakestRows(mat, 4);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        List<Integer>[] freq = new ArrayList[cols+1];
        int[] ans = new int[k];
        for(int i = 0 ; i < rows;i++){
            int solds = countSoldiers(mat[i]);
            if(freq[solds]==null) freq[solds] = new ArrayList<>();
            freq[solds].add(i);
        }

        for(int i = 0 ; i < cols+1  && k>0;i++){
            List<Integer> f = freq[i];
            if(f == null) continue;
            for(int j = 0; j < f.size() && k>0;j++){
                ans[ans.length - k] = f.get(j);
                k--;
            }
        }
        return ans;
    }

    private static int countSoldiers(int[] arr) {
        int left = 0, right = arr.length-1;
        int lastZero = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==0){
                lastZero = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        if(lastZero == -1) return arr.length;
        return lastZero;
    }
}