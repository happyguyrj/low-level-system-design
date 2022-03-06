package com.example.demo.domain.metadata;

public abstract class MetaData {

    private String id;
    private String name;

    public MetaData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
