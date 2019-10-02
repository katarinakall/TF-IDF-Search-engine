package com.company;

import java.util.List;

public class TFIDECalculator {

    public double tf(List<String> doc, String searchTerm) {
        double frequency  = 0;
        for (String word : doc) {
            if (searchTerm.equalsIgnoreCase(word))
                frequency ++;
        }
        return frequency / doc.size();
    }

    public double idf(List<List<String>> docs, String searchTerm) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (searchTerm.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    public double tfIdf(List<String> doc, List<List<String>> docs, String searchTerm) {
        return tf(doc, searchTerm) * idf(docs, searchTerm);
    }
}
