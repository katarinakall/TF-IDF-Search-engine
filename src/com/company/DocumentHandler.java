package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentHandler {

    public List<List<String>> getDocuments() {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader("Dokument.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String document;
        List<List<String>> documents = new ArrayList<>();

        try {
            while ((document = fileReader.readLine()) != null) {
                if (document.length() > 1) {
                    List<String> list = toList(document);
                    documents.add(list);
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documents;
    }

    public List toList(String document) {
        List<String> doc = new ArrayList<>();
        String[] arr = document.toLowerCase().split(" ");

        for (String word : arr) {
            word = word.replaceAll("[^a-zA-Z]", "");
            doc.add(word);
        }

        return doc;
    }

}
