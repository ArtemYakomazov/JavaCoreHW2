package org.skypro.skyshop.article;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchableItems;
    private int count = 0;


    public SearchEngine() {
        searchableItems = new LinkedList<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
        count++;
    }

    public Map<String, Searchable> search(String term) {
        Map<String,Searchable> result = new TreeMap<>();
        for (Searchable item : searchableItems) {
            if (item.searchTerm().toLowerCase().contains(term.toLowerCase())) {
                result.put(item.getName(),item);
            }
        }
        return result;
    }

    public void findBestMatch(String search) throws BestResultsNotFound {
        Searchable bestMatch = null;
        int found = 0;

        for (Searchable searchable : searchableItems) {
            if (searchable != null) {
                String str = searchable.searchTerm().toLowerCase();
                int score = 0;
                int index = 0;
                while ((index = str.indexOf(search.toLowerCase(), index)) != -1) {
                    score++;
                    index++;
                }

                if (score > found) {
                    found = count;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultsNotFound(search);
        }
        System.out.println(bestMatch.getStringRepresentation());
    }

}
