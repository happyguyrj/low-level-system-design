package com.example.app.cache.data;

public interface Storage<Key,Value> {

    void put(Key key, Value value);

    void remove(Key key);

    Value get(Key key);

}