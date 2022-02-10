package leetcode.com.algorithms;

public class MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {
        maxProductDifference(new int[] { 1,6,7,5,2,4,10,6,4 });
    }

    public static int maxProductDifference(int[] nums) {
        int max1 = 0;
        int min1 = 0;

        for (int i = 1; i < nums.length; i++) {
            max1 = nums[i] >= nums[max1] ? i : max1;
            min1 = nums[i] <= nums[min1] ? i : min1;
        }

        int max2 = max1 ==0?1:0;
        int min2 = min1 == 0? 1:0;
        for (int i = 1; i < nums.length; i++) {
            max2 = nums[i] >= nums[max2] && i != max1 ? i:max2;
            min2 = nums[i] <= nums[min2] && min1 != i ? i:min2;
        }

        long result = (nums[max1] * nums[max2]) - (nums[min1] * nums[min2]);
        return (int) result;
    }
}
