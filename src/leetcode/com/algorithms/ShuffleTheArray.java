package leetcode.com.algorithms;

public class ShuffleTheArray{

    public static void main(String[] args){

    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int pos =0;
        for(int i =0 ; i < n ; i++){
            ans[pos++] = nums[i];
            ans[pos++] = nums[i+n];
        }

        return int;
    } 
}