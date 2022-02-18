package com.example.demo.domain;

import com.example.demo.domain.metadata.DatasetMetadata;

import java.util.List;

public class Dataset {

    private DatasetMetadata datasetMetadata;

    public Dataset(DatasetMetadata datasetMetadata) {
        this.datasetMetadata = datasetMetadata;
    }

    public DatasetMetadata getDatasetMetadata() {
        return datasetMetadata;
    }

    public void setDatasetMetadata(DatasetMetadata datasetMetadata) {
        this.datasetMetadata = datasetMetadata;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "datasetMetadata=" + datasetMetadata +
                '}';
    }
}
