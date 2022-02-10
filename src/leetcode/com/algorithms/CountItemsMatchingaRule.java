package leetcode.com.algorithms;

import java.util.List;

public class CountItemsMatchingaRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int pos = 0;
        if (ruleKey.equals("color")) {
            pos = 1;
        } else if (ruleKey.equals("name")) {
            pos = 2;
        }

        int result = 0;
        for (List<String> item : items) {
            if (item.get(pos).equals(ruleValue)) {
                result++;
            }
        }

        return result;
    }
}
