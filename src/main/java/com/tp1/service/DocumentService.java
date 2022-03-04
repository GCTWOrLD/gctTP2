package com.tp1.service;

import com.tp1.model.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentService {
    private static List<Document> documents = new ArrayList<>();

    public static List<Document> getDocuments() {
        return documents;
    }

    public static void setDocuments(List<Document> liste) {
        DocumentService.documents = liste;
    }

    public static boolean addDocument(Document document) {
        return getDocuments().add(document);
    }

    public static boolean deleteDocument(Document document) {
        return getDocuments().remove(document);
    }

    public static Document rechercherDocument(int id) {
        for (Document document : getDocuments()) {
            if (document.getId() == id) {
                return document;
            }
        }
        return null;
    }
}
