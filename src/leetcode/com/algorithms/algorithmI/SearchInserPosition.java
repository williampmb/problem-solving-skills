package leetcode.com.algorithms.algorithmI;

// Leetcode #35
public class SearchInserPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] { 1, 3, 6 }, 7));
        System.out.println(searchInsert(new int[] { 1, 3, 6 }, 5));
        System.out.println(searchInsert(new int[] { 1, 3, 6 }, 0));
        System.out.println(searchInsert(new int[] { 1, 3, 6 }, 6));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left < nums.length && nums[left] < target ? left + 1 : left;
    }
}
