package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchEngine {
    private TFIDECalculator calculator;
    private DocumentHandler dh;

    public SearchEngine() {
        this.calculator = new TFIDECalculator();
        this.dh = new DocumentHandler();
    }

    public String getSearchTerm(){
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

    public List<SearchResult> getSearchResults(String searchTerm){
        List<List<String>> documents = dh.getDocuments();

        List<SearchResult> result = new ArrayList<>();
        int n = 1;

        for (List<String> doc : documents) {
            result.add(new SearchResult("Dokument " + n++, calculator.tfIdf(doc, documents, searchTerm)));
        }
        return result;
    }

    public void printSearchResults(List<SearchResult> result){
        Collections.sort(result);
        for (SearchResult searchResult : result) {
            if (searchResult.getScore() > 0) {
                System.out.println(searchResult.toString());
            }
        }
    }
}
