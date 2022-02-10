package leetcode.com.algorithms.algorithmI;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int mid =0, start =0, end = nums.length-1;
        
        while(start<end){
            mid = (start+end)/2;
            if(target>nums[mid]) start = mid+1;
            else if(target<nums[mid]) end = mid;
            else return mid;
        }
        return target==nums[start]?start:-1;
    }
}
