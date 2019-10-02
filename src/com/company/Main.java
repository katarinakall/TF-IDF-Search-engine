package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        String searchTerm = searchEngine.getSearchTerm();
        List<SearchResult> results = searchEngine.getSearchResults(searchTerm);
        searchEngine.printSearchResults(results);

    }
}
