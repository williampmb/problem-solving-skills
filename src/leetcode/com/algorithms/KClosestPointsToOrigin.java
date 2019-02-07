/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class KClosestPointsToOrigin {
    public  int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        for(int i = 0 ; i < K ;i++){
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        for(int i = K ; i < points.length ;i++){
            int[] row = points[i];
            int max = -1;
            double minDist = Math.sqrt(Math.pow(row[0],2)+Math.pow(row[1],2));
            for(int j = 0; j <K;j++){
                double dist = Math.sqrt(Math.pow(ans[j][0],2)+Math.pow(ans[j][1],2));
                if(minDist < dist){
                    max = j;
                    minDist = dist;
                }
            }
            if(max!=-1){
                ans[max][0] = points[i][0];
                ans[max][1] = points[i][1];
            }
        }
        return ans;
    }
}
