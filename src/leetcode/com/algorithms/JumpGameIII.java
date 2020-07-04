package leetcode.com.algorithms;

import java.util.HashSet;
import java.util.Set;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        boolean found = canReach(arr,start, visited);
        return found;
    }

    public boolean canReach(int[] arr, int pos, Set<Integer> visited) {
        if(pos<0 || pos>= arr.length || visited.contains(pos))return false;
        if(arr[pos] ==0)return true;
        visited.add(pos);
        return canReach(arr, pos + arr[pos], visited) || canReach(arr, pos - arr[pos], visited);
    }
}