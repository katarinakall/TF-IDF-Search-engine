package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        TFIDECalculator calculator = new TFIDECalculator();
        DocumentHandler dh = new DocumentHandler();

        SearchEngine searchEngine = new SearchEngine(calculator, dh);

        String searchTerm = getSearchTerm();
        searchEngine.buildInvertedIndex();
        List<SearchResult> results = searchEngine.getSearchResults(searchTerm);
        searchEngine.printSearchResults(results);

    }

    public static String getSearchTerm(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Word to search for: ");
        String searchTerm = null;
        try {
            searchTerm = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchTerm;
    }

}
