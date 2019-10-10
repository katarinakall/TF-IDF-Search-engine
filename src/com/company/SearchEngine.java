package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SearchEngine {
    private TFIDECalculator calculator;
    private DocumentHandler dh;
    private Map<String, List<SearchResult>> invertedIndex = new HashMap<>();

    public SearchEngine(TFIDECalculator calculator, DocumentHandler dh) {
        this.calculator = calculator;
        this.dh = dh;
    }


    public void buildInvertedIndex(){
        List<List<String>> docs = dh.getDocuments();
        int i = 1;
        for(List<String> doc: docs){
            String id = "Document " + i++;
            for(String term : doc){
                double score = calculator.tfIdf(doc, docs, term);
                SearchResult sResult = new SearchResult(id, score);

                if(invertedIndex.containsKey(term)){
                    List<SearchResult> result = invertedIndex.get(term);
                    if(result.contains(sResult)){
                        System.out.println("balla balla ballla");
                    }
                    result.add(sResult);

                } else{
                    List<SearchResult> result = new ArrayList<>();
                    result.add(sResult);
                    invertedIndex.put(term, result);
                }
            }
        }

        invertedIndex
                .keySet()
                .stream()
                .forEach(term -> {
                    Collections.sort(invertedIndex.get(term));
                });

    }

    public List<SearchResult> getSearchResults(String searchTerm){
        return invertedIndex.get(searchTerm);
    }

    public void printSearchResults(List<SearchResult> result){
        for (SearchResult searchResult : result) {
                System.out.println(searchResult.toString());

        }
    }
}
