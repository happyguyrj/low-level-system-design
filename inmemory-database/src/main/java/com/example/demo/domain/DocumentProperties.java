package com.example.demo.domain;

public class DocumentProperties implements Comparable<DocumentProperties> {

    private String documentName;
    private Integer keywordOccurrencesInDocument;

    public DocumentProperties(String document, Integer keywordOccurrencesInDocument) {
        this.documentName = document;
        this.keywordOccurrencesInDocument = keywordOccurrencesInDocument;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getKeywordOccurrencesInDocument() {
        return keywordOccurrencesInDocument;
    }

    public void setKeywordOccurrencesInDocument(Integer keywordOccurrencesInDocument) {
        this.keywordOccurrencesInDocument = keywordOccurrencesInDocument;
    }

    @Override
    public int compareTo(DocumentProperties o) {
        return this.keywordOccurrencesInDocument - o.keywordOccurrencesInDocument;
    }
}
