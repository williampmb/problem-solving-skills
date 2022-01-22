package leetcode.com.algorithms;

public class CountNumberofPairsWithAbsoluteDifferenceK {

    public int countKDifference(int[] nums, int k) {
        
        int result=0;
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            for(int j = i+1; j< n;j++){
                if(Math.abs(nums[i]-nums[j])==k){
                    result++;
                }
            }
        }
        return result;
    }


    //1 <= nums <= 100 and 1<=k<=99
    public int countKDifferenceCountAlgo(int[] nums, int k) {
        final int kMax = 100;
    
        int ans = 0;
        int[] count = new int[kMax + 1];
    
        for (final int num : nums)
          ++count[num];
    
        for (int i = k + 1; i <= kMax; ++i)
          ans += count[i] * count[i - k];
    
        return ans;
      }
}
