package amazon.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Question5 {
    public static void main(String[] args) {

    }

    public ArrayList<String> topNCompetitors(int numCompetitors, int topNcompetitors, List<String> competitors,
            int numReviews, List<String> reviews) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> countReviews = new HashMap<>();

        // for each review, we need to look for competitors
        for (String review : reviews) {
            String[] words = review.split(" ");
            HashSet<String> reviewed = new HashSet<>();
            // Check who is reviewed in the current review
            for (String word : words) {
                // Does the reiview have only one different competitors? If so we should use a
                // break inside of the if
                if (countReviews.containsKey(word)) {
                    reviewed.add(word);
                }
            }

            // for each competitor that was mentioned at least once in the current review
            // it adds one to the count review
            Iterator<String> iterator = reviewed.iterator();
            while (iterator.hasNext()) {
                String competitorReviewed = iterator.next();
                if (countReviews.containsKey(competitorReviewed)) {
                    countReviews.put(competitorReviewed, countReviews.get(competitorReviewed));
                } else {
                    countReviews.put(competitorReviewed, 1);
                }
            }

        }

        ArrayList<String>[] ordering = new ArrayList[numReviews];
        // ordering by frequency all the competitors
        Iterator<String> it = countReviews.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Integer freq = countReviews.get(next);
            if (ordering[freq] == null) {
                ordering[freq] = new ArrayList<>();
            }
            ordering[freq].add(next);
        }

        // It should order just the list I could use
        int maxListToOrder = topNcompetitors;
        for (int i = numReviews - 1; i >= 0 && ordering[i] != null && maxListToOrder > 0; i--) {
            ArrayList<String> list = ordering[i];
            maxListToOrder -= list.size();
            Collections.sort(list);
        }

        // Iterate from the end to begining finding top N competitors
        for (int i = numReviews - 1; i >= 0 && ordering[i] != null && topNcompetitors > 0; i--) {
            for (String s : ordering[i]) {
                if (topNcompetitors > 0) {
                    ans.add(s);
                    topNcompetitors--;
                } else {
                    break;
                }
            }
        }

        return (ArrayList<String>) ans;

    }

}