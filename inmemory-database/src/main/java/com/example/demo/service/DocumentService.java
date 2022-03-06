package com.example.demo.service;

import com.example.demo.domain.Dataset;
import com.example.demo.domain.Document;
import com.example.demo.domain.DocumentProperties;
import com.example.demo.domain.metadata.DatasetMetadata;
import com.example.demo.domain.metadata.DocumentMetadata;

import java.util.*;
import java.util.stream.Collectors;

public class DocumentService {

    private static final List<Document> documents = new ArrayList<>();
    private static final Map<String, Dataset> datasets = new HashMap<>();

    // Cache
    private static final Map<String, Map<String, List<DocumentProperties>>> documentPropertiesCache = new HashMap<>();

    public void createDataset(String name) {
        datasets.putIfAbsent(name, new Dataset(new DatasetMetadata(UUID.randomUUID().toString(), name)));
    }

    public void createDocument(String content, String datasetName, String documentName) {
        createDataset(datasetName);
        documents.add(new Document(datasets.get(datasetName), new DocumentMetadata(UUID.randomUUID().toString(), documentName), content));
        if (!documentPropertiesCache.isEmpty())
            updateDocumentPropertiesCache(documentName, content, datasetName);
    }

    public List<String> searchDocuments(String datasetName, String keyword) {
        if (!documentPropertiesCache.containsKey(datasetName) || !documentPropertiesCache.get(datasetName).containsKey(keyword)) {
            documentPropertiesCache.put(datasetName, new HashMap<>());
            documentPropertiesCache.get(datasetName).put(keyword, new ArrayList<>());
            documents.stream()
                    .filter( document -> document.getDataset().getDatasetMetadata().getName().equals(datasetName))
                    .forEach(document -> {
                        int count = countOccurrences(keyword, document.getDocumentContent());
                        if(count > 0) {
                            documentPropertiesCache.get(datasetName).get(keyword).add(
                                    new DocumentProperties(document.getDocumentMetadata().getName(),count));
                        }
                    });
        }

        return documentPropertiesCache.get(datasetName)
                .get(keyword)
                .stream()
                .sorted()
                .map(DocumentProperties::getDocumentName)
                .collect(Collectors.toList());
    }

    private void updateDocumentPropertiesCache(String documentName, String content, String dataset) {
        for (String keyword :  documentPropertiesCache.get(dataset).keySet()) {
            documentPropertiesCache.get(dataset).get(keyword).add(new DocumentProperties(documentName, countOccurrences(keyword, content)));
        }
    }

    private Integer countOccurrences(String keyword, String content) {
        if(keyword.isEmpty() || content.isEmpty())
            return 0;
        return content.split(keyword, -1).length - 1;
    }
}
