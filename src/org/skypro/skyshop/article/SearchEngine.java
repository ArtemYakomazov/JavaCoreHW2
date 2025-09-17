package org.skypro.skyshop.article;

public class SearchEngine {
    private final Searchable[] searchableItems;
    private int count = 0;


    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count++] = item;
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && item.searchTerm().contains(term)) {
                if (resultCount < 5) {
                    results[resultCount++] = item;
                } else {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultsNotFound {
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
        return bestMatch;
    }

}
