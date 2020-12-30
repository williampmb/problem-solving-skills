package codeingame;

import java.util.*;

public class FindNetworkEndpoint {

    public static void main(String[] args) {

    }

    public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
        Map<Integer, Integer> fromTo = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        int last = startNodeId;

        for (int i = 0; i < fromIds.length; i++) {
            fromTo.put(fromIds[i], toIds[i]);
        }
        Integer cur = startNodeId;
        while (!seen.contains(cur)) {
            last = cur;
            seen.add(cur);
            cur = (Integer) fromTo.get(cur);
            if (cur == null) {
                break;
            }
        }
        return last;
    }

}
