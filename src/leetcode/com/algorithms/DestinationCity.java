package leetcode.com.algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> out = new HashSet<>();

        for (List<String> path : paths) {
            String source = path.get(0);
            out.add(source);
        }

        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!out.contains(destination))
                return destination;
        }
        return "";
    }
}
