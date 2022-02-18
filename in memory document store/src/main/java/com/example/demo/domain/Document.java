package com.example.demo.domain;

import com.example.demo.domain.metadata.DocumentMetadata;

public class Document {

    private Dataset dataset;
    private DocumentMetadata documentMetadata;
    private String documentContent;

    public Document(Dataset dataset, DocumentMetadata documentMetadata, String documentContent) {
        this.dataset = dataset;
        this.documentMetadata = documentMetadata;
        this.documentContent = documentContent;
    }

    public DocumentMetadata getDocumentMetadata() {
        return documentMetadata;
    }

    public void setDocumentMetadata(DocumentMetadata documentMetadata) {
        this.documentMetadata = documentMetadata;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentMetadata=" + documentMetadata +
                '}';
    }
}
