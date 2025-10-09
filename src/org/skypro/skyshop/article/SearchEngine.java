package org.skypro.skyshop.article;


import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchableItems;
    private int count = 0;


    public SearchEngine() {
        searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
        count++;
    }

    public Set<Searchable> search(String term) {
        Set<Searchable> result = new TreeSet<>(new sortedTitleComparator());
        for (Searchable item : searchableItems) {
            if (item.searchTerm().toLowerCase().contains(term.toLowerCase())) {
                result.add(item);
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

    @Override
    public String toString() {
        return "Статьи" + searchableItems;
    }
}
