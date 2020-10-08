package leetcode.com.algorithms;

import java.util.HashMap;

public class NumberOfGoodPairs {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 4 };
        NumberOfGoodPairs.numIdenticalPairs(nums);
    }

    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> pairPosition = new HashMap<>();
        int numIdenticalPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!pairPosition.containsKey(nums[i])) {
                pairPosition.put(nums[i], 1);
                continue;
            }
            int numbPair = pairPosition.get(nums[i]);
            numIdenticalPairs += numbPair;
            pairPosition.put(nums[i], numbPair + 1);

        }
        return numIdenticalPairs;
    }
}