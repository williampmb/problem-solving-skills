/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author William Barbosa
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8,15,18,21};
        int pos = BinarySearch.nextClosestLowerIntButNotEqual(array, 0, array.length - 1, 9);
        System.out.println(pos);
    }

    public static int binarySearch(int[] array, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] < target) {
                start = mid + 1;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    
    // {1 5 6 10} -> 9 => it should return index 6
     public static int nextClosestLowerIntButNotEqual(int[] array, int start, int end, int target) {
      
         while (start < end) {
            int mid = (int)(Math.ceil((float)(start + end) / 2.0)); 
            
            if (array[mid] < target) {
                start = mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                return -1;
            }
        }
        return start;
    }
}
