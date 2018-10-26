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
public class PeakIndexInMoutainArray {
    /*
    *   Time complexity O(log N )
    *   Space complexity O(1)
    *   It should never leave the while loop unless it hits the "else"
    */
    public int peakIndexInMountainArray(int[] A) {
        int start=0,end=A.length-1,mid=0;
        while(start<end){
            mid = (start+end)/2;
            if(A[mid]>A[mid-1]&&A[mid]<A[mid+1]) start=mid+1;
            else if(A[mid]<A[mid-1]&&A[mid]>A[mid+1]) end = mid;
            else return mid;
        }
        return start;
    }
}
