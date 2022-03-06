package com.example.app.cache.domain.node;

public class FrequencyNode<Key> {
    private final Key key;
    protected FrequencyNode<Key> next;
    protected FrequencyNode<Key> prev;

    public FrequencyNode(Key key) {
        this.key = key;
    }

    public Key key() {
        return key;
    }
}